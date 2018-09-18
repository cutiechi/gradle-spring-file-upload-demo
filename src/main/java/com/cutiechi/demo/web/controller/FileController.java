package com.cutiechi.demo.web.controller;

import com.cutiechi.demo.exception.FileUploadException;

import com.cutiechi.demo.model.dto.JsonResponse;
import com.cutiechi.demo.model.dto.ServiceResult;

import com.cutiechi.demo.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.cutiechi.demo.model.dto.JsonResponse.Status.BAD_REQUEST;
import static com.cutiechi.demo.model.dto.JsonResponse.Status.OK;

/**
 * 文件 REST 控制器
 *
 * @author Cutie Chi
 */
@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController (FileService fileService) {
        this.fileService = fileService;
    }

    /**
     * 文件上传
     *
     * @param files 文件数组
     * @return 通用 JSON 响应
     * @throws FileUploadException 文件上传异常
     */
    @PostMapping(value = "")
    public JsonResponse upload (@RequestParam("file") MultipartFile[] files) throws FileUploadException {
        ServiceResult result = fileService.upload(files);
        return result.getStatus()
            ? new JsonResponse(OK.getValue(), result.getMessage())
            : new JsonResponse(BAD_REQUEST.getValue(), result.getMessage());
    }
}
