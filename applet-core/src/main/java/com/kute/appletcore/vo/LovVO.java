package com.kute.appletcore.vo;

import com.kute.appletcore.entity.SysLovColumn;
import com.kute.appletcore.entity.SysLovDefine;
import org.apache.ibatis.type.Alias;

import java.util.List;


@Alias("LovVO")
public class LovVO {
	private SysLovDefine sld;
	private List<SysLovColumn> slcList;
	

	public SysLovDefine getSld() {
		return sld;
	}

	public void setSld(SysLovDefine sld) {
		this.sld = sld;
	}

	public List<SysLovColumn> getSlcList() {
		return slcList;
	}

	public void setSlcList(List<SysLovColumn> slcList) {
		this.slcList = slcList;
	}

}
