package com.kute.appletweb.number.impl;

import com.kute.appletcore.dao.InvOrderNumberMapper;
import com.kute.appletcore.entity.InvOrderNumber;
import com.kute.appletweb.number.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
@Service
public class NumberServiceImpl implements NumberService {


    @Autowired
    InvOrderNumberMapper invOrderNumberMapper;


    /**
     * 返回单号
     * @throws Exception
     */
    @Transactional( propagation = Propagation.REQUIRES_NEW)
    public String getNumber(String type,String dateFormat,Integer Places)throws Exception {
        String number = "";

            NumberFormat nf = NumberFormat.getInstance();
            // 设置是否使用分组
            nf.setGroupingUsed(false);
            // 设置最大整数位数
//			int num = Integer.parseInt(numberDao.getSysParameterConfigByPk("serial_number_length"));
            int num = Places;
            nf.setMaximumIntegerDigits(num);
            // 设置最小整数位数
            nf.setMinimumIntegerDigits(num);
            InvOrderNumber on = new InvOrderNumber();
            on.setPrefix(type);
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            String dateString = formatter.format(currentTime);
            on.setDateTime(dateString);
            InvOrderNumber ON = invOrderNumberMapper.selectByPrefixAndDateTime(on);
            if (ON == null) {
                    on.setSerialNumber(1);
                invOrderNumberMapper.insert(on);
                number = on.getPrefix() + on.getDateTime() + nf.format(Integer.valueOf(on.getSerialNumber()));
            } else {
                on.setSerialNumber(ON.getSerialNumber() + 1);
                invOrderNumberMapper.update(on);
                number = on.getPrefix()  + on.getDateTime() + nf.format(on.getSerialNumber());
            }
        return number;
    }

}
