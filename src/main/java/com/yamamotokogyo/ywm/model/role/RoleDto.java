package com.yamamotokogyo.ywm.model.role;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;

public class RoleDto {
	// 権限ID
	@NotEmpty 
    private String roleId;
    
    // 権限コード
	@NotEmpty
    private int roleCode; 
    
    // 権限名
	@NotEmpty
    private String roleName; 
    
    // マスタ権限
    private String masterPermission; 

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
    
    //有効フラグ
    @NotEmpty 
    private Boolean validFlag;
    
    //バージョン
    @NotEmpty  
    private int version;

	public String getRoleId() {
		return roleId;
	}

	public int getRoleCode() {
		return roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public String getMasterPermission() {
		return masterPermission;
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

	public Boolean getValidFlag() {
		return validFlag;
	}

	public int getVersion() {
		return version;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setMasterPermission(String masterPermission) {
		this.masterPermission = masterPermission;
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

	public void setValidFlag(Boolean validFlag) {
		this.validFlag = validFlag;
	}

	public void setVersion(int version) {
		this.version = version;
	}

    
}
