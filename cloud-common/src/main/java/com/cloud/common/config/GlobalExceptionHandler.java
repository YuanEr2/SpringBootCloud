package com.cloud.common.config;

import com.cloud.common.result.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 * @ClassName:ExceptionHandler
 * @Description: TODO 全局异常处理类
 * @Auther: RuanChaoChao
 * @Date: 2023/5/26 23:34
 */
@RestControllerAdvice
@Log4j2
@Component
public class GlobalExceptionHandler {

    public GlobalExceptionHandler() {
        log.info("全局异常处理器，启动成功");
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<String> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request){
        String uri = request.getRequestURI();
        String method = request.getMethod();
        log.error("路径：[{} - {}]，请求异常：[{}]",uri, method, exception.getMessage(), exception);
        return Result.error(exception.getMessage());

    }

    @ExceptionHandler(Exception.class)
    public Result<String> exception(Exception exception, HttpServletRequest request){
        String uri = request.getRequestURI();
        String method = request.getMethod();
        log.error("路径：[{} - {}]，请求异常[{}]",uri, method, exception.getMessage(), exception);
        return Result.error(exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result<String> runtimeException(RuntimeException exception, HttpServletRequest request){
        String uri = request.getRequestURI();
        String method = request.getMethod();
        log.error("路径：[{} - {}]，请求异常[{}]",uri, method, exception.getMessage(), exception);
        return Result.error(exception.getMessage());
    }

}


