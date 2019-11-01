package com.kute.appletmanage.security.impl;


import com.kute.appletcore.dao.SysUserMapper;
import com.kute.appletcore.entity.SysUser;
import com.kute.appletcore.util.JsonUtil;
import com.kute.appletcore.util.MD5Util;
import com.kute.appletcore.util.RSAUtil;
import com.kute.appletcore.util.tree.TreeNode;
import com.kute.appletcore.util.tree.TreeNodeVO;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.security.dao.SecurityMapper;
import com.kute.appletmanage.security.jwt.JWTTokenUtil;
import com.kute.appletmanage.security.jwt.JWTUserDetails;
import com.kute.appletmanage.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Name: 安全
 * @Description: 安全
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-20
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-20
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private String expiration;
    @Value("${key.private}")
    private String privateKey;

    @Autowired
    JWTTokenUtil jwtTokenUtil;

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SecurityMapper securityMapper;



    /**
     * 登录
     */
   public ResponseResult login(String  login_username,String  login_password) throws Exception {
        String loginStatus = "S";
        String loginMessage = "";
        SysUser sysUser = sysUserMapper.selectUserByUserName(login_username);
        // 1.用户名
       if (sysUser == null) {
           loginStatus = "W";
           loginMessage = "用户不存在!";
       }
       // 3.密码
       if ("S".equals(loginStatus) ) {

           if (!sysUser.getUserStatus().equals("Y")) {
               loginStatus = "W";
               loginMessage = "用户已失效!";
           }
       }
       // 3.密码
       if ("S".equals(loginStatus) ) {
            String  decryptPassword = RSAUtil.decrypt(login_password, privateKey);
           if (!sysUser.getPassword().equals(MD5Util.MD5(decryptPassword))) {
               loginStatus = "W";
               loginMessage = "密码不正确!";
           }
       }
        Map map =new HashMap();
       if ("S".equals(loginStatus) ) {
           String loginToken = JWTTokenUtil.generateToken(secret, expiration, new JWTUserDetails(sysUser.getUsername()));
           map.put("username", sysUser.getUsername());
           map.put("Authorization", loginToken);
           map.put("bootstrapSkin", sysUser.getSkin());
           map.put("realname", sysUser.getRealname());
       }

        return new ResponseResult(loginStatus,loginMessage,map);
    }



    @Override
    public Map<String, String> getImageVerificationCode() {
        return null;
    }

    @Override
    public ResponseResult getMenuTree(String username) throws Exception {

        // 获取手风琴菜单列表
        List<TreeNodeVO> accordionMenuList = securityMapper.getAccordionMenuList(username);

        List<TreeNode> rootNodeList=this.generateSubTree(accordionMenuList, "M");
        String json = JsonUtil.getJSONFromObjectList(rootNodeList);
//
        json = json.replaceAll("\"nodes\":\\[\\],", "");

        return new ResponseResult("S","",json);
    }

    /**
     * 递归生成子树
     */
    private List<TreeNode> generateSubTree(List<TreeNodeVO> list,String  parentNode) throws Exception {

        List<TreeNode> subNodeList = new ArrayList<>();
        for (TreeNodeVO menu : list) {
            TreeNode subNode = new TreeNode();
            subNode.setText(menu.getNodeName());
            subNode.setData(menu.getTreeNodeData());
            String menuId = menu.getNodeCode();
            String parentCode = menu.getParentNodeCode();
            if (parentNode.equals(parentCode) ) {
                List<TreeNode> menuLists = generateSubTree(list, menuId);
                subNode.setNodes(menuLists);
                subNodeList.add(subNode);
            }
        }
        return subNodeList;
    }

//    /**
//     * 获取验证码
//     *
//     * @param username
//     */
//    public ResponseResult getVerificationCode(String username) throws Exception {
//
//        ResponseResult result = new ResponseResult();
//        if (!username.equals("") && AccountValidatorUtil.isMobile(username)) {
//            String number = RandomUtil.generateRandomCode("number", 6);
//            String vars = "{\"code\":\"" + number + "\"}";
//            String appId = "12858";
//            String appKey = "5e1f6aa019d2dd869b5a8bb1c887f413";
//            String templateId = "kzCzx2";
//            String apiUrl = "https://api.mysubmail.com/message/xsend";
//            //发送短信
//    		SubmailUtil.sendSMS(username, vars, appId, appKey, templateId, apiUrl);
//            String uuid  =UUIDUtil.getUUID();
//            redisUtil.set(uuid,number,5L);
//            result.setCode("S");
//            result.setInfo("短信发送成功");
//            result.setData(uuid);
//        } else {
//            result.setCode("E");
//            result.setInfo("手机号码不正确..");
//        }
//
//
//        return result;
//    }





}
