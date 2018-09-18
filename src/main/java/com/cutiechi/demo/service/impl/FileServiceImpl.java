package com.cutiechi.demo.service.impl;

import com.cutiechi.demo.exception.FileUploadException;
import com.cutiechi.demo.model.dto.ServiceResult;
import com.cutiechi.demo.service.FileService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件业务逻辑层实现类
 *
 * @author Cutie Chi
 */
@Service
public class FileServiceImpl implements FileService {

    /**
     * 上传文件
     *
     * @param files 文件数组
     * @return 业务逻辑结果
     * @throws FileUploadException 文件上传异常
     */
    @Override
    public ServiceResult upload (MultipartFile[] files) throws FileUploadException {
        final String FILES_DICTIONARY = "D:\\Codes\\Spring\\gradle-spring-file-upload-demo\\";
        try {
            if (files.length > 0) {
                for (MultipartFile file : files) {
                    String fileName = file.getOriginalFilename();
                    file.transferTo(new File(FILES_DICTIONARY + fileName));
                }
                return ServiceResult.success("上传文件成功！");
            } else {
                return ServiceResult.fail("没有选择任何文件，上传文件失败！");
            }
        } catch (IOException exception) {
            throw new FileUploadException("服务器错误，上传文件失败！");
        }
    }
}
