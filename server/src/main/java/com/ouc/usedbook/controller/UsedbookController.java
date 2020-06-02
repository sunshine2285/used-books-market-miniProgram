package com.ouc.usedbook.controller;

import com.ouc.usedbook.dto.DeleteDTO;
import com.ouc.usedbook.dto.UsedbookDTO;
import com.ouc.usedbook.util.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/2 9:28
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/usedbook")
public class UsedbookController {

    @ApiOperation(value = "二手书列表", notes = "获取所有二手书列表", httpMethod = "GET")
    @GetMapping("/list")
    Response allUsedbookList(){
        return Response.ok(null);
    }

    @ApiOperation(value = "用户二手书列表", notes = "根据用户的id获取其出售的所有二手书列表", httpMethod = "GET")
    @GetMapping("/user/{id}")
    Response userUsedbookList(@PathVariable long id){
        return Response.ok(null);
    }

    @ApiOperation(value = "添加二手书", notes = "用户上传待售书二手书信息", httpMethod = "POST")
    @PostMapping("/add")
    Response add(UsedbookDTO usedbookDTO){
        return Response.ok(null);
    }

    @ApiOperation(value = "添加二手书", notes = "用户上传待售书二手书信息", httpMethod = "POST")
    @PostMapping("/delete")
    Response delete(DeleteDTO deleteDTO){
        return Response.ok(null);
    }

    @ApiOperation(value = "更新二手书", notes = "用户更新待售书二手书信息", httpMethod = "POST")
    @PostMapping("/update")
    Response update(UsedbookDTO usedbookDTO){
        return Response.ok(null);
    }
}