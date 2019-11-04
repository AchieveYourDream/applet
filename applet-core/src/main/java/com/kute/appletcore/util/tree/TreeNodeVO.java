package com.kute.appletcore.util.tree;

import org.apache.ibatis.type.Alias;

/**
 * 树节点
 * 
 * @author AI
 * @since 2016-11-19
 */
@Alias("TreeNodeVO")
public class TreeNodeVO {

	/* 标准树节点属性 */
	private String nodeCode; // 节点编码
	private String parentNodeCode; // 父节点编码
	private String nodeName; // 节点名称
	private String nodeIcon; // 节点图标
	private String nodeUrl; // 节点URL
	private String webUrl; // 前段URL
	private String isLeafNode; // 是否是叶子节点
	private String isSelected; // 节点是否被选中
	private String isChecked; // 节点是否被选中-复选框
	private String isExpanded; // 节点是否展开
	private String isDisabled; // 节点是否可用

	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}


	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getNodeIcon() {
		return nodeIcon;
	}

	public void setNodeIcon(String nodeIcon) {
		this.nodeIcon = nodeIcon;
	}

	public String getNodeUrl() {
		return nodeUrl;
	}

	public void setNodeUrl(String nodeUrl) {
		this.nodeUrl = nodeUrl;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getParentNodeCode() {
		return parentNodeCode;
	}

	public void setParentNodeCode(String parentNodeCode) {
		this.parentNodeCode = parentNodeCode;
	}

	public String getIsLeafNode() {
		return isLeafNode;
	}

	public void setIsLeafNode(String isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

	public String getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(String isSelected) {
		this.isSelected = isSelected;
	}

	public String getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

	public String getIsExpanded() {
		return isExpanded;
	}

	public void setIsExpanded(String isExpanded) {
		this.isExpanded = isExpanded;
	}

	public String getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(String isDisabled) {
		this.isDisabled = isDisabled;
	}

	/**
	 * 获取树节点数据对象
	 */
	public TreeNodeData getTreeNodeData() throws Exception {
		TreeNodeData tnd = new TreeNodeData();
		tnd.setNodeCode(this.getNodeCode());
		tnd.setParentNodeCode(this.getParentNodeCode());
		tnd.setNodeName(this.getNodeName());
		tnd.setNodeIcon(this.getNodeIcon() == null ? "" : this.getNodeIcon());
		tnd.setNodeUrl(this.getNodeUrl() == null ? "" : this.getNodeUrl());
		tnd.setIsLeafNode(this.getIsLeafNode() == null ? "" : this.getIsLeafNode());
		tnd.setIsSelected(this.getIsSelected() == null ? "" : this.getIsSelected());
		tnd.setIsChecked(this.getIsChecked() == null ? "" : this.getIsChecked());
		tnd.setIsExpanded(this.getIsExpanded() == null ? "" : this.getIsExpanded());
		tnd.setIsDisabled(this.getIsDisabled() == null ? "" : this.getIsDisabled());
		return tnd;
	}

//	/**
//	 * 获取树节点状态对象
//	 */
//	public TreeNodeState getTreeNodeState() throws Exception {
//		TreeNodeState tns = new TreeNodeState();
//		tns.setSelected(this.getIsSelected() == null ? false : this.getIsSelected());
//		tns.setChecked(this.getIsChecked() == null ? false : this.getIsChecked());
//		tns.setExpanded(this.getIsExpanded() == null ? false : this.getIsExpanded());
//		tns.setDisabled(this.getIsDisabled() == null ? false : this.getIsDisabled());
//		return tns;
//	}

}
