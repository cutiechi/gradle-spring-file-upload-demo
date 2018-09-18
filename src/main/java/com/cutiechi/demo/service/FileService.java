package com.cutiechi.demo.service;

import com.cutiechi.demo.exception.FileUploadException;
import com.cutiechi.demo.model.dto.ServiceResult;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件业务逻辑层接口
 *
 * @author Cutie Chi
 */
public interface FileService {

    /**
     * 上传文件
     *
     * @param files 文件数组
     * @return 业务逻辑结果
     * @throws FileUploadException 文件上传异常
     */
    ServiceResult upload (MultipartFile[] files) throws FileUploadException;
}
