package com.ouc.usedbook.controller;

import com.ouc.usedbook.dto.DeleteDTO;
import com.ouc.usedbook.dto.UsedbookDTO;
import com.ouc.usedbook.entity.Usedbook;
import com.ouc.usedbook.service.UsedbookService;
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

    final UsedbookService usedbookService;

    public UsedbookController(UsedbookService usedbookService) {
        this.usedbookService = usedbookService;
    }

    @ApiOperation(value = "二手书列表", notes = "获取所有二手书列表", httpMethod = "GET")
    @GetMapping("/list")
    Response allUsedbookList() {
        return Response.ok(usedbookService.findAll());
    }

    @ApiOperation(value = "用户二手书列表", notes = "根据用户的id获取其出售的所有二手书列表", httpMethod = "GET")
    @GetMapping("/user/{uid}")
    Response userUsedbookList(@PathVariable Long uid) {
        return Response.ok(usedbookService.findByUid(uid));
    }

    @ApiOperation(value = "二手书详情", notes = "根据二手书的bid获取详细的二手书信息", httpMethod = "GET")
    @GetMapping("/{bid}")
    Response get(@PathVariable Long bid) {
        return Response.ok(usedbookService.findByBid(bid));
    }

    @ApiOperation(value = "删除二手书", notes = "用户删除待售书二手书信息", httpMethod = "POST")
    @PostMapping("/delete")
    Response delete(@RequestBody DeleteDTO deleteDTO) {
        usedbookService.delete(deleteDTO.getBid());
        return Response.ok("delete success", null);
    }

    @ApiOperation(value = "添加二手书", notes = "用户上传待售书二手书信息", httpMethod = "POST")
    @PostMapping("/add")
    Response add(@RequestBody UsedbookDTO usedbookDTO) {
        Usedbook usedbook = usedbookDTO.toUsedbook("");
        return Response.ok(usedbookService.add(usedbook));
    }

    @ApiOperation(value = "更新二手书", notes = "用户更新待售书二手书信息", httpMethod = "POST")
    @PostMapping("/update")
    Response update(@RequestBody UsedbookDTO usedbookDTO) {
        Usedbook usedbook = usedbookDTO.toUsedbook("");
        return Response.ok(usedbookService.update(usedbook));
    }

}