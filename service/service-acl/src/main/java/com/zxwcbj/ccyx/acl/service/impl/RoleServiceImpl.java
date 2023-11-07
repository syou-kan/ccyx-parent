package com.zxwcbj.ccyx.acl.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.log.Log;
import com.zxwcbj.ccyx.acl.mapper.RoleMapper;
import com.zxwcbj.ccyx.acl.service.RoleService;
import com.zxwcbj.ccyx.model.acl.AdminRole;
import com.zxwcbj.ccyx.model.acl.Role;
import com.zxwcbj.ccyx.vo.acl.RoleQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 * @author a8480
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    /**
     * 1 角色列表(分页查询)
     * */
    @Override
    public IPage<Role> selectRolePageList(Page<Role> page, RoleQueryVo roleQueryVo) {
        //获取条件值
        String roleName =roleQueryVo.getRoleName();
        //创建map对象
        LambdaQueryWrapper<Role> wrapper=new LambdaQueryWrapper<>();
        //判断条件值是否为空，不为空则封装查询条件
        if (!StringUtils.isEmpty(roleName)){
            wrapper.like(Role::getRoleName,roleName);
        }
/*调用方法实现条件分页查询,输出 IPage<Role> 对象
* 可以将 RoleMapper 进行依赖注入
* */
        return baseMapper.selectPage(page, wrapper);
    }
    /**
     * 为用户分配角色
     **/
    @Override
    public void saveAdmin(Long adminId, Long[] roleId) {
        LambdaQueryWrapper<AdminRole> warp =new LambdaQueryWrapper<>();
        warp.eq(AdminRole::getAdminId,adminId);

    }
}