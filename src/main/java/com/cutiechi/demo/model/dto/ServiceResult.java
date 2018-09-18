package com.cutiechi.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务逻辑层统一返回结果数据传输对象
 *
 * @author Cutie Chi
 */
@Getter
@Setter
public final class ServiceResult {

    /**
     * 业务逻辑结果是否成功
     */
    private Boolean status;

    /**
     * 业务逻辑结果附带的信息
     */
    private String message;

    private ServiceResult () {

    }

    private ServiceResult (Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * 业务逻辑结果成功
     *
     * @param message 成功附带的信息
     * @return ServiceResult
     */
    public static ServiceResult success (String message) {
        return new ServiceResult(true, message);
    }

    /**
     * 业务逻辑结果失败
     *
     * @param message 失败附带的信息
     * @return ServiceResult
     */
    public static ServiceResult fail (String message) {
        return new ServiceResult(false, message);
    }
}
