package com.kute.appletcore.util;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;



public class FileUtil {
    /**
     * 通用上传方法
     * @param savePath
     * @param multipartFile
     * @return
     */
    public static String uploadFile(String savePath, MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        //获取源文件后缀
        String suffix=originalFilename.substring(originalFilename.lastIndexOf("."));
        //拼装新文件名称
        String newFileName=System.currentTimeMillis()+suffix;
        File file=new File(savePath+"/"+ newFileName);//    /home/linai/+newFileName
        try {
            //调用spring提供的方法进行文件读写
//            multipartFile.transferTo(file);
            Thumbnails.of(multipartFile.getInputStream()).scale(0.5f).toFile(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }
}
