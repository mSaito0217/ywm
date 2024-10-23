package com.yamamotokogyo.ywm.model.orders;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;

/**
 * Ordersエンティティに関するデータ転送オブジェクト (DTO)
 */
public class OrderDto {
	
	 //注文ID
	@NotEmpty
	private String OrderId;

	 //作業番号
	@NotEmpty
	private String WorkNumber;

	 //品番１
	private String ProductNumber1;

	 //品番２
	private String ProductNumber2;

	 //対象製品名
	private String ProductName;

	 //次数
	private String Quantity;

	 //品目
	private String Item;

	 //目的
	private String Purpose;

	 //手配品番
	private String ArrangementsProductNumber;

	 //手配品名
	private String ArrangementsProductName;

	 //材質
	private String Material;

	 //寸法
	private String Size;

	 //注文数
	private int OrderVolume;

	 //単位ID
	private String ScaleId;

	 //手配分類
	private String ArrangementsType;

	 //単価
	private int Cost;

	 //金額
	private BigDecimal Amount;

	 //納品予定日
	private Date DeliveryScheduleDate;

	 //納入場所
	private String DeliveryPlace;

	 //使用部署ID
	private String UseDepartmentId;

	 //直送直納
	private boolean DirectDelivery;

	 //単価未決定理由
	private String CostReasonPending;

	 //単価決定予定期日
	private Date CostDecisionScheduleDate;

	 //希望納品日
	private Date DesiredDeliveryScheduleDate;

	 //承認者ID
	private String ApproverId;

	 //依頼者ID
	private String RequesterId;

	 //発行者ID
	private String IssuerId;

	 //備考
	private String Note;

	 //初期登録日時
	@NotEmpty
	private Date CreatedAt;

	 //初期登録者
	@NotEmpty
	private String CreatedUser;

	 //最終更新日時
	@NotEmpty
	private Date UpdateAt;

	 //最終更新者
	@NotEmpty
	private String UpdateUser;

	 //中止フラグ
	@NotEmpty
	private boolean ValidFlag;

	 //バージョン
	@NotEmpty
	private int Version;

	public String getOrderId() {
		return OrderId;
	}

	public String getWorkNumber() {
		return WorkNumber;
	}

	public String getProductNumber1() {
		return ProductNumber1;
	}

	public String getProductNumber2() {
		return ProductNumber2;
	}

	public String getProductName() {
		return ProductName;
	}

	public String getQuantity() {
		return Quantity;
	}

	public String getItem() {
		return Item;
	}

	public String getPurpose() {
		return Purpose;
	}

	public String getArrangementsProductNumber() {
		return ArrangementsProductNumber;
	}

	public String getArrangementsProductName() {
		return ArrangementsProductName;
	}

	public String getMaterial() {
		return Material;
	}

	public String getSize() {
		return Size;
	}

	public int getOrderVolume() {
		return OrderVolume;
	}

	public String getScaleId() {
		return ScaleId;
	}

	public String getArrangementsType() {
		return ArrangementsType;
	}

	public int getCost() {
		return Cost;
	}

	public BigDecimal getAmount() {
		return Amount;
	}

	public Date getDeliveryScheduleDate() {
		return DeliveryScheduleDate;
	}

	public String getDeliveryPlace() {
		return DeliveryPlace;
	}

	public String getUseDepartmentId() {
		return UseDepartmentId;
	}

	public boolean isDirectDelivery() {
		return DirectDelivery;
	}

	public String getCostReasonPending() {
		return CostReasonPending;
	}

	public Date getCostDecisionScheduleDate() {
		return CostDecisionScheduleDate;
	}

	public Date getDesiredDeliveryScheduleDate() {
		return DesiredDeliveryScheduleDate;
	}

	public String getApproverId() {
		return ApproverId;
	}

	public String getRequesterId() {
		return RequesterId;
	}

	public String getIssuerId() {
		return IssuerId;
	}

	public String getNote() {
		return Note;
	}

	public Date getCreatedAt() {
		return CreatedAt;
	}

	public String getCreatedUser() {
		return CreatedUser;
	}

	public Date getUpdateAt() {
		return UpdateAt;
	}

	public String getUpdateUser() {
		return UpdateUser;
	}

	public boolean isValidFlag() {
		return ValidFlag;
	}

	public int getVersion() {
		return Version;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	public void setWorkNumber(String workNumber) {
		WorkNumber = workNumber;
	}

	public void setProductNumber1(String productNumber1) {
		ProductNumber1 = productNumber1;
	}

	public void setProductNumber2(String productNumber2) {
		ProductNumber2 = productNumber2;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public void setItem(String item) {
		Item = item;
	}

	public void setPurpose(String purpose) {
		Purpose = purpose;
	}

	public void setArrangementsProductNumber(String arrangementsProductNumber) {
		ArrangementsProductNumber = arrangementsProductNumber;
	}

	public void setArrangementsProductName(String arrangementsProductName) {
		ArrangementsProductName = arrangementsProductName;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public void setSize(String size) {
		Size = size;
	}

	public void setOrderVolume(int orderVolume) {
		OrderVolume = orderVolume;
	}

	public void setScaleId(String scaleId) {
		ScaleId = scaleId;
	}

	public void setArrangementsType(String arrangementsType) {
		ArrangementsType = arrangementsType;
	}

	public void setCost(int cost) {
		Cost = cost;
	}

	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}

	public void setDeliveryScheduleDate(Date deliveryScheduleDate) {
		DeliveryScheduleDate = deliveryScheduleDate;
	}

	public void setDeliveryPlace(String deliveryPlace) {
		DeliveryPlace = deliveryPlace;
	}

	public void setUseDepartmentId(String useDepartmentId) {
		UseDepartmentId = useDepartmentId;
	}

	public void setDirectDelivery(boolean directDelivery) {
		DirectDelivery = directDelivery;
	}

	public void setCostReasonPending(String costReasonPending) {
		CostReasonPending = costReasonPending;
	}

	public void setCostDecisionScheduleDate(Date costDecisionScheduleDate) {
		CostDecisionScheduleDate = costDecisionScheduleDate;
	}

	public void setDesiredDeliveryScheduleDate(Date desiredDeliveryScheduleDate) {
		DesiredDeliveryScheduleDate = desiredDeliveryScheduleDate;
	}

	public void setApproverId(String approverId) {
		ApproverId = approverId;
	}

	public void setRequesterId(String requesterId) {
		RequesterId = requesterId;
	}

	public void setIssuerId(String issuerId) {
		IssuerId = issuerId;
	}

	public void setNote(String note) {
		Note = note;
	}

	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}

	public void setCreatedUser(String createdUser) {
		CreatedUser = createdUser;
	}

	public void setUpdateAt(Date updateAt) {
		UpdateAt = updateAt;
	}

	public void setUpdateUser(String updateUser) {
		UpdateUser = updateUser;
	}

	public void setValidFlag(boolean validFlag) {
		ValidFlag = validFlag;
	}

	public void setVersion(int version) {
		Version = version;
	}

}
