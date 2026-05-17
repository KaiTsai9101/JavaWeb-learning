package chapter1.test.controller;

import chapter1.test.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
        log.info("接收参数：{}, {}, {}", name, age, file);
        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();

        // 新文件名（防重复文件名后覆盖）
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));   // 获取文件后缀名
        String newFileName = UUID.randomUUID().toString() + extension;      // 将文件名转为UUID后拼接上文件后缀名

        // 保存文件
        file.transferTo(new File("F:/javaweb-learning/getImage/" + newFileName));
        return Result.success();
    }
}
