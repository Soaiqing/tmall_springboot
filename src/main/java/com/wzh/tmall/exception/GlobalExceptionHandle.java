package com.wzh.tmall.exception;
 
import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
 
import java.lang.reflect.UndeclaredThrowableException;
 
/**
 * 全局异常处理配置
 * @author wzh
 * @date 2022-3-14 15:04:40
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandle {
 
    /**
     * 顶级异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e){
        //annotation抛出的异常
        if(e instanceof UndeclaredThrowableException) {
            e = (Exception) ((UndeclaredThrowableException)e).getUndeclaredThrowable();
        }
        log.error("[handleException]: ",e);
        return R.failed(e.getMessage());
    }
}