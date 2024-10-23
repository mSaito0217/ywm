package com.yamamotokogyo.ywm.model.orders;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Ordersエンティティのモデルクラス
 */
@Table(name = "Orders") 
public class Order {

	 //注文ID
	@Id
	@Column(name = "order_id" , nullable = false, unique = true)
	private String OrderId;

	 //作業番号
	@Column(name = "work_number", unique = true)
	private String WorkNumber;

	 //品番１
	@Column(name = "product_number_1")
	private String ProductNumber1;

	 //品番２
	@Column(name = "product_number_2")
	private String ProductNumber2;

	 //対象製品名
	@Column(name = "product_name")
	private String ProductName;

	 //次数
	@Column(name = "quantity")
	private String Quantity;

	 //品目
	@Column(name = "Item")
	private String Item;

	 //目的
	@Column(name = "purpose")
	private String Purpose;

	 //手配品番
	@Column(name = "arrangements_product_number")
	private String ArrangementsProductNumber;

	 //手配品名
	@Column(name = "arrangements_product_name")
	private String ArrangementsProductName;

	 //材質
	@Column(name = "material")
	private String Material;

	 //寸法
	@Column(name = "size")
	private String Size;

	 //注文数
	@Column(name = "order_volume")
	private int OrderVolume;

	 //単位ID
	@Column(name = "scale_id")
	private String ScaleId;

	 //手配分類
	@Column(name = "arrangements_type")
	private String ArrangementsType;

	 //単価
	@Column(name = "cost")
	private int Cost;

	 //金額
	@Column(name = "amount")
	private BigDecimal Amount;

	 //納品予定日
	@Column(name = "delivery_schedule_date")
	private Date DeliveryScheduleDate;

	 //納入場所
	@Column(name = "delivery_place")
	private String DeliveryPlace;

	 //使用部署ID
	@Column(name = "use_department_id")
	private String UseDepartmentId;

	 //直送直納
	@Column(name = "direct_delivery")
	private boolean DirectDelivery;

	 //単価未決定理由
	@Column(name = "cost_reason_pending")
	private String CostReasonPending;

	 //単価決定予定期日
	@Column(name = "cost_decision_schedule_date")
	private Date CostDecisionScheduleDate;

	 //希望納品日
	@Column(name = "desired_delivery_schedule_date")
	private Date DesiredDeliveryScheduleDate;

	 //承認者ID
	@Column(name = "approver_id")
	private String ApproverId;

	 //依頼者ID
	@Column(name = "requester_id")
	private String RequesterId;

	 //発行者ID
	@Column(name = "Issuer_id")
	private String IssuerId;

	 //備考
	@Column(name = "note")
	private String Note;

	 //初期登録日時
	@Column(name = "created_at" , nullable = false)
	private Date CreatedAt;

	 //初期登録者
	@Column(name = "created_user" , nullable = false)
	private String CreatedUser;

	 //最終更新日時
	@Column(name = "update_at" , nullable = false)
	private Date UpdateAt;

	 //最終更新者
	@Column(name = "update_user" , nullable = false)
	private String UpdateUser;

	 //中止フラグ
	@Column(name = "valid_flag" , nullable = false)
	private boolean ValidFlag;

	 //バージョン
	@Column(name = "version" , nullable = false)
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