package com.gg.microservicecommon.entity.sys;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @authorliwangwang
 * @site www.liwangwang.com
 * @company xxx公司
 * @create 2019-10-25 15:44
 */
public class TreeNode  {

    private int perid;//主id
    private String pername;//菜单名字
    private int pid;//父id
    private String permission;//路径
    private String pericon;//图片

    private List<TreeNode> children;//这个菜单项的儿子

    public  TreeNode(){

    }
    public   TreeNode(Map<String,Object> map){
        this.perid = Integer.parseInt(map.get("perid").toString());
        this.pername = map.get("pername").toString();
        this.pid = Integer.parseInt(map.get("pid").toString());
        this.permission = map.get("permission").toString();
        this.pericon = map.get("pericon") !=null ? map.get("pericon").toString() : null ;

    }

    public int getPerid() {
        return perid;
    }

    public void setPerid(int perid) {
        this.perid = perid;
    }

    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPericon() {
        return pericon;
    }

    public void setPericon(String pericon) {
        this.pericon = pericon;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "perid=" + perid +
                ", pername='" + pername + '\'' +
                ", pid=" + pid +
                ", permission='" + permission + '\'' +
                ", pericon='" + pericon + '\'' +
                ", children=" + children +
                '}';
    }
}
