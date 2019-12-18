package com.gg.microservicesysproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.sys.SysPermission;
import com.gg.microservicecommon.entity.sys.TreeNode;
import com.gg.microservicesysproviderhystrix.dao.SysPermissionDao;
import com.gg.microservicesysproviderhystrix.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (SysPermission)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 11:29:39
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysPermissionDao sysPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param perid 主键
     * @return 实例对象
     */
    @Override
    public SysPermission queryById(Integer perid) {
        return this.sysPermissionDao.queryById(perid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysPermission> queryAllByLimit(int offset, int limit) {
        return this.sysPermissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermission insert(SysPermission sysPermission) {
        this.sysPermissionDao.insert(sysPermission);
        return sysPermission;
    }

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermission update(SysPermission sysPermission) {
        this.sysPermissionDao.update(sysPermission);
        return this.queryById(sysPermission.getPerid());
    }

    /**
     * 通过主键删除数据
     *
     * @param perid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer perid) {
        return this.sysPermissionDao.deleteById(perid) > 0;
    }

    /**
     *  作为一个过度，相当于翻译
     * @param uid
     * @param pid
     * @return
     */
    @Override
    public List<TreeNode> getTreeNodePlus(String uid ,String pid){
        List<Map<String,Object>> list = sysPermissionDao.getTreeNode(uid, pid);
        if (list != null && list.size() > 0) {
            List<TreeNode> treeNodes = new ArrayList<>();
            list.forEach(map -> {
                treeNodes.add(new TreeNode(map));
            });

            return treeNodes;
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> getTreeNodeByRoleid(String roleid) {
        return this.sysPermissionDao.getTreeNodeByRoleid(roleid);
    }

    @Override
    public int delRolePermission(String roleid) {
        return this.sysPermissionDao.delRolePermission(roleid);
    }

    @Override
    public int addRolePermission(String roleid, String perid) {
        return this.sysPermissionDao.addRolePermission(roleid,perid);
    }


    @Override
    public List<TreeNode> getTreeNode(String uid) {
        //先获取顶部节点 //getMenu相当于 sql语句 菜单
        List<TreeNode> treeNodes = this.getTreeNodePlus(uid,"-1");

        //判断是否为空 注意 这里必须要size > 0
        if(treeNodes != null && treeNodes.size() > 0){
            //经顶层节点通通都 遍历一遍
            for (TreeNode t: treeNodes) {
                //这里就传入 用户 id 节点 id 和 次节点 对象
                try {
                    menuTree(uid,t);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return treeNodes;
    }

    /**
     *
     * @Title menuTree
     * @Description  递归获取菜单树
     * @param uid 用户id
     * @param treeNode 这是 父节点
     * @throws Exception
     *
     */
    private void menuTree(String uid, TreeNode treeNode) throws Exception{
        //获取菜单
        List<TreeNode>  childNode = this.getTreeNodePlus(""+uid,""+treeNode.getPerid());//pid
        if(childNode != null && childNode.size() > 0){
            treeNode.setChildren(childNode);
            //循环子节点 继续递归
            for (TreeNode t: childNode) {
                menuTree(uid, t);
            }
        }
    }
}