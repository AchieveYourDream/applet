package com.kute.appletmanage.security.dao;

import com.kute.appletcore.util.tree.TreeNodeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Name: 安全
 * @Description: 安全
 */
public interface SecurityMapper {
 /** 
 * @Description: 获取树节点
 * @Author: 王斌
 * @Date: 2019/10/29 
 */ 
    List<TreeNodeVO> getAccordionMenuList(@Param("username") String username) throws Exception;
}
