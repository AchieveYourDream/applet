package com.kute.appletcore.util.tree;

/**
 * 树节点状态
 * @author AI
 * @since 2016-11-19
 */
public class TreeNodeState {

	private Boolean selected = false; // 是否被选中
	private Boolean checked = false; // 是否被选中-复选框
	private Boolean expanded = false; // 是否展开
	private Boolean disabled = false; // 是否可用

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
}
