package com.kute.appletstatic.image;

import com.kute.appletcore.util.FileUtil;
import com.kute.appletcore.vo.ResponseResult;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping(value = "/static/")
public class ImagesController {

//    //二维码存放地址
//    @Value("${qrcodePath}")
//    private String qrcodePath;
    //图片存放地址
    @Value("${applet.imgSavePath}")
    private String imgSavePath;

//    /**
//     * 获取推荐二维码
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping(value = "/getQrcode",produces = MediaType.IMAGE_JPEG_VALUE)
//    public byte[] getImage(@Param("member_id") String  member_id) throws IOException {
//        File file = new File(qrcodePath+member_id+".png");
//        FileInputStream inputStream = new FileInputStream(file);
//        byte[] bytes = new byte[inputStream.available()];
//        inputStream.read(bytes, 0, inputStream.available());
//        return bytes;
//    }
//
//
//    /**
//     * 获取投诉信息照片
//     * @param ImagesId
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping(value = "/getImages",produces = MediaType.IMAGE_JPEG_VALUE)
//    public byte[] getImages(@Param("ImagesId") String  ImagesId) throws IOException {
//        File file = new File(qrcodePath+ImagesId);
//        FileInputStream inputStream = new FileInputStream(file);
//        byte[] bytes = new byte[inputStream.available()];
//        inputStream.read(bytes, 0, inputStream.available());
//        inputStream.close();
//        return bytes;
//    }




    /**
     * 获取applet图片
     * @throws IOException
     */
    @RequestMapping(value = "/getImages/{path}/{imgName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getRedImages(@PathVariable("path") String  path, @PathVariable("imgName") String  imgName) throws IOException {
        File file = new File(imgSavePath+path+"/"+imgName);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];

        inputStream.read(bytes, 0, inputStream.available());
        inputStream.close();
        return bytes;
    }

    @PostMapping(value = "/uploadingImages/{path}")
    @ApiOperation(value = "小程序图片上传(商品,量体师)", notes = "商品,量体师", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams({
    })
    public ResponseResult WXSmartProgram(@PathVariable("path") String  path, @RequestParam(value = "pic", required = false) MultipartFile file) throws Exception {
        ResponseResult result = new ResponseResult();
        if (!file.isEmpty()) {
            String clerk_image= FileUtil.uploadFile(imgSavePath+path,file);
            result.setCode("S");
            result.setData(clerk_image);
        } else {
            result.setCode("E");
            result.setData("参数格式错误");
        }
        return result;
    }
}
