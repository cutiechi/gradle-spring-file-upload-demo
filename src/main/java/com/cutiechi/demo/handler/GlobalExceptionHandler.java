package com.cutiechi.demo.handler;

import com.cutiechi.demo.exception.FileUploadException;
import com.cutiechi.demo.model.dto.JsonResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.cutiechi.demo.model.dto.JsonResponse.Status.INTERNAL_SERVER_ERROR;

/**
 * 全局异常处理类
 *
 * @author Cutie Chi
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 文件上传异常处理方法
     *
     * @param exception 文件上传异常
     * @return 通用 JSON 响应
     */
    @ExceptionHandler(FileUploadException.class)
    @ResponseBody
    public JsonResponse fileUploadException (FileUploadException exception) {
        return new JsonResponse(INTERNAL_SERVER_ERROR.getValue(), exception.getMessage());
    }
}
