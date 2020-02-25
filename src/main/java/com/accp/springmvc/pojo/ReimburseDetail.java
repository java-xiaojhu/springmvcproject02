package com.accp.springmvc.pojo;

import java.util.List;

/**
 * 报销详情表(reimburse_detail)
 * @author 小虎
 *
 */
public class ReimburseDetail {
	//详情编号
	private Integer id;
	//报销主表编号
	private Integer mainId;
	//事项金额
	private Double subTotal;
	//事项描述
	private String desc;
	//报销单图片名
	private String pictureName;
	//报销单真实路径
	private String picturePath;
	

	public ReimburseDetail() {
		super();
	}

	public ReimburseDetail(Double subTotal, String desc, String pictureName, String picturePath) {
		super();
		this.subTotal = subTotal;
		this.desc = desc;
		this.pictureName = pictureName;
		this.picturePath = picturePath;
	}

	public ReimburseDetail(Integer id, Integer mainId, Double subTotal, String desc, String pictureName,
			String picturePath) {
		super();
		this.id = id;
		this.mainId = mainId;
		this.subTotal = subTotal;
		this.desc = desc;
		this.pictureName = pictureName;
		this.picturePath = picturePath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMainId() {
		return mainId;
	}

	public void setMainId(Integer mainId) {
		this.mainId = mainId;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	@Override
	public String toString() {
		return "ReimburseDetail [id=" + id + ", mainId=" + mainId + ", subTotal=" + subTotal + ", desc=" + desc
				+ ", pictureName=" + pictureName + ", picturePath=" + picturePath + "]";
	}


	
}
