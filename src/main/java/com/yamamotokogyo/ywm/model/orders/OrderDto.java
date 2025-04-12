package com.yamamotokogyo.ywm.model.orders;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;

/**
 * Ordersエンティティに関するデータ転送オブジェクト (DTO)
 */
public class OrderDto { //注文ID
	@NotEmpty
	private String orderId;

	//作業番号
	private String workNumber;

	//品番１
	private String productNumber1;

	//品番２
	private String productNumber2;

	//対象製品名
	private String productName;

	//次数
	private String quantity;

	//品目
	private String item;

	//目的
	private String purpose;

	//手配品番
	private String arrangementsProductNumber;

	//手配品名
	private String arrangementsProductName;

	//材質
	private String material;

	//寸法
	private String size;

	//注文数
	private int orderVolume;

	//単位ID
	private String scaleId;

	//手配分類
	private String arrangementsType;

	//単価
	private int cost;

	//金額
	private BigDecimal amount;

	//納品予定日
	private Date deliveryScheduleDate;

	//納入場所
	private String deliveryPlace;

	//使用部署ID
	private String useDepartmentId;

	//直送直納
	private boolean directDelivery;

	//単価未決定理由
	private String costReasonPending;

	//単価決定予定期日
	private Date costDecisionScheduleDate;

	//希望納品日
	private Date desiredDeliveryScheduleDate;

	//承認者ID
	private String approverId;

	//依頼者ID
	private String requesterId;

	//発行者ID
	private String issuerId;

	//備考
	private String note;

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

	public String getOrderId() {
		return orderId;
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public String getProductNumber1() {
		return productNumber1;
	}

	public String getProductNumber2() {
		return productNumber2;
	}

	public String getProductName() {
		return productName;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getItem() {
		return item;
	}

	public String getPurpose() {
		return purpose;
	}

	public String getArrangementsProductNumber() {
		return arrangementsProductNumber;
	}

	public String getArrangementsProductName() {
		return arrangementsProductName;
	}

	public String getMaterial() {
		return material;
	}

	public String getSize() {
		return size;
	}

	public int getOrderVolume() {
		return orderVolume;
	}

	public String getScaleId() {
		return scaleId;
	}

	public String getArrangementsType() {
		return arrangementsType;
	}

	public int getCost() {
		return cost;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Date getDeliveryScheduleDate() {
		return deliveryScheduleDate;
	}

	public String getDeliveryPlace() {
		return deliveryPlace;
	}

	public String getUseDepartmentId() {
		return useDepartmentId;
	}

	public boolean isDirectDelivery() {
		return directDelivery;
	}

	public String getCostReasonPending() {
		return costReasonPending;
	}

	public Date getCostDecisionScheduleDate() {
		return costDecisionScheduleDate;
	}

	public Date getDesiredDeliveryScheduleDate() {
		return desiredDeliveryScheduleDate;
	}

	public String getApproverId() {
		return approverId;
	}

	public String getRequesterId() {
		return requesterId;
	}

	public String getIssuerId() {
		return issuerId;
	}

	public String getNote() {
		return note;
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

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	public void setProductNumber1(String productNumber1) {
		this.productNumber1 = productNumber1;
	}

	public void setProductNumber2(String productNumber2) {
		this.productNumber2 = productNumber2;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public void setArrangementsProductNumber(String arrangementsProductNumber) {
		this.arrangementsProductNumber = arrangementsProductNumber;
	}

	public void setArrangementsProductName(String arrangementsProductName) {
		this.arrangementsProductName = arrangementsProductName;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setOrderVolume(int orderVolume) {
		this.orderVolume = orderVolume;
	}

	public void setScaleId(String scaleId) {
		this.scaleId = scaleId;
	}

	public void setArrangementsType(String arrangementsType) {
		this.arrangementsType = arrangementsType;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setDeliveryScheduleDate(Date deliveryScheduleDate) {
		this.deliveryScheduleDate = deliveryScheduleDate;
	}

	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}

	public void setUseDepartmentId(String useDepartmentId) {
		this.useDepartmentId = useDepartmentId;
	}

	public void setDirectDelivery(boolean directDelivery) {
		this.directDelivery = directDelivery;
	}

	public void setCostReasonPending(String costReasonPending) {
		this.costReasonPending = costReasonPending;
	}

	public void setCostDecisionScheduleDate(Date costDecisionScheduleDate) {
		this.costDecisionScheduleDate = costDecisionScheduleDate;
	}

	public void setDesiredDeliveryScheduleDate(Date desiredDeliveryScheduleDate) {
		this.desiredDeliveryScheduleDate = desiredDeliveryScheduleDate;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public void setRequesterId(String requesterId) {
		this.requesterId = requesterId;
	}

	public void setIssuerId(String issuerId) {
		this.issuerId = issuerId;
	}

	public void setNote(String note) {
		this.note = note;
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
