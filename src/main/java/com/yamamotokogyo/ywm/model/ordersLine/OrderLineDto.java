package com.yamamotokogyo.ywm.model.ordersLine;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;

/**
 * OrdersLineエンティティに関するデータ転送オブジェクト (DTO)
 */
public class OrderLineDto {
	//注文明細ID
	@NotEmpty
	private String orderLineId;

	//注文ID
	@NotEmpty
	private String orderId;

	//設計品番
	private String designProductNumber;

	//手配品番
	private String arrangementsProductNumber;

	//部品名
	private String partsName;

	//規格
	private String standard;

	//寸法
	private String size;

	//製作部署ID
	private String createDepartmentId;

	//単位
	private String unit;

	//初期登録日時
	@NotEmpty
	private Date createdAt;

	//初期登録者
	@NotEmpty
	private String createdUser;

	//最終更新日時
	@NotEmpty
	private Date updateAt;

	//最終更新者
	@NotEmpty
	private String updateUser;

	//中止フラグ
	@NotEmpty
	private boolean validFlag;

	//バージョン
	@NotEmpty
	private int version;

	public String getOrderLineId() {
		return orderLineId;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getDesignProductNumber() {
		return designProductNumber;
	}

	public String getArrangementsProductNumber() {
		return arrangementsProductNumber;
	}

	public String getPartsName() {
		return partsName;
	}

	public String getStandard() {
		return standard;
	}

	public String getSize() {
		return size;
	}

	public String getCreateDepartmentId() {
		return createDepartmentId;
	}

	public String getUnit() {
		return unit;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public boolean isValidFlag() {
		return validFlag;
	}

	public int getVersion() {
		return version;
	}

	public void setOrderLineId(String orderLineId) {
		this.orderLineId = orderLineId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setDesignProductNumber(String designProductNumber) {
		this.designProductNumber = designProductNumber;
	}

	public void setArrangementsProductNumber(String arrangementsProductNumber) {
		this.arrangementsProductNumber = arrangementsProductNumber;
	}

	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setCreateDepartmentId(String createDepartmentId) {
		this.createDepartmentId = createDepartmentId;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setValidFlag(boolean validFlag) {
		this.validFlag = validFlag;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
