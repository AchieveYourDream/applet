package com.kute.appletmanage.imformation.controller;


import com.kute.appletcore.entity.AppInformation;
import com.kute.appletcore.entity.SysDataStructNode;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.imformation.service.InformationManageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app/appInformation/")
public class InformationManageController {

    @Resource
    private InformationManageService informationManageService;

    /**
     * 获取小程序资讯管理菜单信息
     */
    @RequestMapping(value = "getAppInformationMenuInfo", method = RequestMethod.GET)
    public ResponseResult getAppInformationMenuInfo() throws Exception {
            List<SysDataStructNode> list = informationManageService.getAppInformationMenuInfo();
            return new ResponseResult("S", "",list);

    }

    /**
     * 获取小程序资讯管理列表
     */
    @RequestMapping(value = "selectAppInformationList", method = RequestMethod.POST)
    public ResponseResult selectAppInformationList( String useModule) {
            List<AppInformation> list = informationManageService.selectAppInformationList(useModule);
            return new ResponseResult("S", "",list);

    }

    /**
     * 插入小程序资讯管理
     */
    @RequestMapping(value = "insertAppInformation", method = RequestMethod.POST)
    public ResponseResult insertAppInformation( AppInformation ac) {
            informationManageService.insertAppInformation(ac);
            return new ResponseResult("S", "插入成功");

    }

    /**
     * 修改小程序资讯管理
     */
    @RequestMapping(value = "updateAppInformation", method = RequestMethod.POST)
    public ResponseResult updateAppInformation( AppInformation ac) {
            informationManageService.updateAppInformation(ac);
            return new ResponseResult("S", "修改成功");

    }

    /**
     * 撤回or上线 资讯管理
     */
    @RequestMapping(value = "updateInformationVisible", method = RequestMethod.POST)
    public ResponseResult updateInformationVisible( String isvisible, String informationId) {
            informationManageService.updateInformationVisible(isvisible, informationId);
            return new ResponseResult("S", "");

    }

//	  /**
//	   * 修改资讯管理头像
//	   */
//		  @RequestMapping("updateInformationImage")
//	  public @ResponseBody OperationResult updateInformationImage(@Param("informationId")String  informationId,@RequestParam MultipartFile pic){
//		OperationResult result = new OperationResult(); 
//		      try {
//		      if(pic!=null){
//		            String newFilePath= FileUtil.uploadFile(information_img_url,"",pic);
//		            informationService.updateInformationImage(informationId, newFilePath);
//		          result.setResult_code("Y");
//			  result.setResult_info(newFilePath);
//		       }else{
//		          result.setResult_code("N");
//		          result.setResult_info("图片为空");
//		       }
//		      } catch (Exception e) {
//				e.printStackTrace();
//
//			 result.setResult_code("N");
//			 result.setResult_info(e.getMessage());
//			}
//		      
//		      return result;
//		    }

    /**
     * 检查资讯管理是否存在
     */
    @RequestMapping(value = "checkInformationCode", method = RequestMethod.GET)
    public String checkInformationCode(Integer informationId) throws Exception {
        String responseText = "false";

        if (informationId == null || informationId.equals("")) {
            return responseText;
        }
        AppInformation ac = informationManageService.selectAppInformationByPk(informationId);

        if (ac == null) {
            responseText = "true";
        } else {
            responseText = "false";
        }

        return responseText;
    }

    /**
     * 检查资讯管理详细信息
     */
    @RequestMapping(value = "selectAppInformationByPk", method = RequestMethod.POST)
    public ResponseResult selectAppInformationByPk( Integer informationId) throws Exception {
            AppInformation ai = informationManageService.selectAppInformationByPk(informationId);
            return new ResponseResult("S", "",ai);
    }


}
