package com.example.controller;

import com.example.common.Result;
import com.example.common.StatusCode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class  FileUploadController {


    @Value("${file.filePath}")

    String filePath;

    public String getFilePath() {
        return filePath;
    }

    /**
     * 用户头像上传
     *
     * @param type 表示头像类型
     * @param file 上传的文件组件
     * @return {type} RestFul 风格地址栏传参 对于这种方式传递必须在接受参数上加上@PathVariable注解
     */
    @PostMapping("/upload/{type}")
    public Result<String> userHeaderPicUpload(@PathVariable("type") String type,
                                              @RequestParam("file") MultipartFile file) throws IOException {
            // 获取上传文件的真实名字
        String originalFilename = file.getOriginalFilename();
        if ("".equals(originalFilename)) {
            return new Result<String>(false, StatusCode.ERROR, "没有名字");
        }
            // aa.jpg 获取文件的后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println("========================" + suffix);
            // 图片大小判断
        if (file.getSize() / 1024 / 1024 > 10) {
            return new Result<String>(false, StatusCode.ERROR, "图片不能大于10M");
        }
            // 图片类型判断
        if (".jpg".equals(suffix) || ".jpeg".equals(suffix) || ".png".equals(suffix)
                || ".gif".equals(suffix) || ".webp".equals(suffix)) {
            // 生成64 位长的字符串，可以保证不会重复
            String uuid = UUID.randomUUID().toString();
            System.out.println("uuid：" + uuid);
            String pathname = type + "/" + uuid + suffix;
            // 图片写入到本地磁盘的真实路径
            String targetFileDirectory = filePath + File.separator + "file" +
                    File.separator + type;
            System.out.println("targetFileDirectory " + targetFileDirectory);
            File file1 = new File(targetFileDirectory);
            if (!file1.exists()) { // 判断文件夹不存在就创建
                file1.mkdirs();
            }
            File newFile = new File(file1, uuid + suffix);
            // 将文件写入磁盘
            file.transferTo(newFile);
            return new Result<String>(true, StatusCode.OK, "图片上传成功", pathname);
        } else {
            return new Result<String>(false, StatusCode.ERROR, "请上传正确是的图片类型");
        }
    }

}
