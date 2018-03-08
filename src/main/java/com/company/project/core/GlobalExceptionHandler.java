package com.company.project.core;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangchun on 2018/3/6.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value=Exception.class)
    private Map<String,Object> exceptionHandler(HttpServletRequest request, Exception e){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",1);
        modelMap.put("errMsg",e.getMessage());
        return modelMap;
    }
}
