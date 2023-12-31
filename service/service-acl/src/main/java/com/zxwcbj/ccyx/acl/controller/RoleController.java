package com.zxwcbj.ccyx.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxwcbj.ccyx.acl.service.RoleService;
import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.acl.Role;
import com.zxwcbj.ccyx.vo.acl.RoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色管理
 * @author a8480
 **/
@RestController
@RequestMapping("/admin/acl/role")
@Api(tags = "用户管理")
@Slf4j
public class RoleController {
    @ApiOperation("获取角色分页列表")
    @GetMapping("{current}/{limit}")
    public Result getPageList(@PathVariable Long current,
                              @PathVariable Long limit,
                              RoleQueryVo roleQueryVo){
        //创建page对象,接收分页参数,页数和每页要多少条数据
        Page<Role> page=new Page<>(current, limit);
        IPage<Role> iPage= RoleService.selectRolePageList(page,roleQueryVo);
        return Result.ok(iPage);
    }

}
