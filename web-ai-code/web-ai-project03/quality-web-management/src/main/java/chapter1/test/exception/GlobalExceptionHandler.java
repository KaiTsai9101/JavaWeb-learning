package chapter1.test.exception;

import chapter1.test.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常处理
@Slf4j
@RestControllerAdvice       // 添加这个注解，表示这个类是处理全局异常的类
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("程序出错", e);
        return Result.error("程序出错，请联系管理员");
    }

    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("程序出错", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");     // 获取错误信息索引值
        String errMsg = message.substring(i);       // 截取错误信息
        String[] arr = errMsg.split(" ");       // 根据空格进行分割
        return Result.error(arr[2] + "已存在");
    }
}
