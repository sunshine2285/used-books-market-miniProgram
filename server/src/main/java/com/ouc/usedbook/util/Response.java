package com.ouc.usedbook.util;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一响应类
 *
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/1 21:34
 */
@Data
@NoArgsConstructor
public class Response {
    private static final Integer OK = 200;
    private static final Integer FORBIDDEN = 403;
    private static final Integer NOT_FOUND = 404;
    private static final Integer SERVER_ERROR = 500;

    private Integer code;
    private String msg;
    private Object data;

    public Response(Integer code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Response ok(Object data){
        return new Response(OK, "success", data);
    }

    public static Response error(Object data){
        return new Response(SERVER_ERROR, "server error", data);
    }

    public static Response forbidden(Object data){
        return new Response(FORBIDDEN, "forbidden", data);
    }

    public static Response notfound(Object data){
        return new Response(NOT_FOUND, "not found", data);
    }
}
