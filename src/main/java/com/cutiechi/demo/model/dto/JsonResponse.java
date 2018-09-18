package com.cutiechi.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 通用 JSON 响应数据传输对象
 *
 * @author Cutie Chi
 */
@Getter
@Setter
public class JsonResponse {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    public JsonResponse (Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 状态码枚举
     */
    public enum Status {

        /**
         * OK 请求成功
         */
        OK(20000),

        /**
         * Bad Request 请求错误
         */
        BAD_REQUEST(400),

        /**
         * Internal Server Error 内部服务器错误
         */
        INTERNAL_SERVER_ERROR(500);


        /**
         * 状态码
         */
        private Integer code;

        Status (int code) {
            this.code = code;
        }

        /**
         * 获取枚举对应的状态码
         *
         * @return 状态码
         */
        public Integer getValue () {
            return code;
        }
    }
}
