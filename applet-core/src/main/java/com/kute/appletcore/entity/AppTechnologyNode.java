package com.kute.appletcore.entity;

public class AppTechnologyNode {
    /**
     * 
     */
    private Integer id;

    /**
     * 工艺节点编码
     */
    private String nodeCode;

    /**
     * 工艺父节点编码
     */
    private String parentNodeCode;

    /**
     * 工艺节点名称
     */
    private String nodeName;

    /**
     * 启用标识[y:启用;n:禁用]
     */
    private String enabledFlag;

    /**
     * 说明
     */
    private String description;

    /**
     * 显示顺序
     */
    private Integer displayOrder;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 工艺节点编码
     * @return node_code 工艺节点编码
     */
    public String getNodeCode() {
        return nodeCode;
    }

    /**
     * 工艺节点编码
     * @param nodeCode 工艺节点编码
     */
    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    /**
     * 工艺父节点编码
     * @return parent_node_code 工艺父节点编码
     */
    public String getParentNodeCode() {
        return parentNodeCode;
    }

    /**
     * 工艺父节点编码
     * @param parentNodeCode 工艺父节点编码
     */
    public void setParentNodeCode(String parentNodeCode) {
        this.parentNodeCode = parentNodeCode;
    }

    /**
     * 工艺节点名称
     * @return node_name 工艺节点名称
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * 工艺节点名称
     * @param nodeName 工艺节点名称
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * 启用标识[y:启用;n:禁用]
     * @return enabled_flag 启用标识[y:启用;n:禁用]
     */
    public String getEnabledFlag() {
        return enabledFlag;
    }

    /**
     * 启用标识[y:启用;n:禁用]
     * @param enabledFlag 启用标识[y:启用;n:禁用]
     */
    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    /**
     * 说明
     * @return description 说明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 说明
     * @param description 说明
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 显示顺序
     * @return display_order 显示顺序
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * 显示顺序
     * @param displayOrder 显示顺序
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}