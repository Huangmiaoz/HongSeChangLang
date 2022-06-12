package com.common;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//SpringMVC的异常处理器
@Slf4j
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){
        //记录日志
        //通知运维
        //通知开发
        log.info("全局异常错误：" + ex.getMessage());;
        return Result.fail(null, ex.getMessage());
    }
}