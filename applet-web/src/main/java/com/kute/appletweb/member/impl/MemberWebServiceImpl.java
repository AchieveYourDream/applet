package com.kute.appletweb.member.impl;

import com.kute.appletcore.dao.AppCusAddressMapper;
import com.kute.appletcore.dao.AppMemberMapper;
import com.kute.appletcore.entity.AppCusAddress;
import com.kute.appletcore.entity.AppMember;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.jwt.JWTTokenUtil;
import com.kute.appletcore.jwt.JWTUserDetails;
import com.kute.appletcore.util.AccountValidatorUtil;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.util.redis.RedisUtil;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletweb.member.dao.MemberWebMapper;
import com.kute.appletweb.member.service.MemberWebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberWebServiceImpl implements MemberWebService {

    private final Logger logger = LoggerFactory.getLogger(MemberWebService.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;
    @Autowired
    MemberWebMapper memberWebMapper;

    @Autowired
    AppCusAddressMapper appCusAddressMapper;

    @Autowired
    AppMemberMapper appMemberMapper;

    @Autowired
    JWTTokenUtil jwtTokenUtil;
    @Autowired
    RedisUtil redisUtil;




    /**
     * 登录
     */
    public ResponseResult login(String  username,String verificationCode ) throws Exception {
        ResponseResult result = new ResponseResult();
        String smsv = redisUtil.get(username);
        if (smsv != null && smsv.equals(verificationCode)) {
                //查询有没有会员信息
                AppMember merber = appMemberMapper.selectByPrimaryKey(username);
                if (merber == null) {
                    AppMember am = new AppMember();
                    am.setMemberTel(username);
                    am.setMemberSource("web");
                    appMemberMapper.insert(am);
                }
                String access_token = JWTTokenUtil.generateToken(secret, expiration, new JWTUserDetails(username));
                result.setCode(EnumResultType.SUCCESS.toString());

                //删除缓存验证码
                redisUtil.remove(username);
                result.setCode(EnumResultType.SUCCESS.toString());
                result.setData(access_token);
            } else {
                result.setCode("W");
                result.setInfo(ApplicationConstant.LOGIN_VALIDATE_09);

            }
            return result;
    }



    /**
     * 获取验证码
     *
     */
    public ResponseResult getVerificationCode(String username) throws Exception {

        ResponseResult result = new ResponseResult();
        if (!username.equals("") && AccountValidatorUtil.isMobile(username)) {
//            String number = RandomUtil.generateRandomCode("number", 6);
            String number ="123456";
//            String vars = "{\"code\":\"" + number + "\"}";
//            String appId = "12858";
//            String appKey = "5e1f6aa019d2dd869b5a8bb1c887f413";
//            String templateId = "kzCzx2";
//            String apiUrl = "https://api.mysubmail.com/message/xsend";
//            //发送短信
//    		SubmailUtil.sendSMS(username, vars, appId, appKey, templateId, apiUrl);
            redisUtil.set(username,number,5L);

            result.setCode(EnumResultType.SUCCESS.toString());
            result.setInfo("短信发送成功");
        } else {
            result.setCode(EnumResultType.ERROR.toString());
            result.setInfo("手机号码不正确..");
        }


        return result;
    }

    /**
     * 获取会员收货地址列表
     *
     * @param member_id 会员手机号
     * @return
     */
    public List<AppCusAddress> selectCusAddressList(String member_id) throws Exception {
        return memberWebMapper.selectCusAddressList(member_id);
    }

    /**
     * 插入收获地址
     */
    public int insetMemberAddress(AppCusAddress address) throws Exception {
        return appCusAddressMapper.insert(address);
    }

    /**
     * 修改收货地址
     */
    public int updateMemberAddress(AppCusAddress address) throws Exception {
        return appCusAddressMapper.updateByPrimaryKey(address);
    }

    /**
     * 删除收获地址
     */
    public int deleteMemberAddress(String id) throws Exception {
        return appCusAddressMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改默认地址
     * member_id 用户ID
     * id 需要默认收货地址
     */
    public void updateAddressDefault(String member_id, String id) throws Exception {
        memberWebMapper.updateAddressDefault(member_id);
        memberWebMapper.setAddressDefault(id);
    }


}
