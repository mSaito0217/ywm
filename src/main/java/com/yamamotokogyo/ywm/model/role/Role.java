package com.yamamotokogyo.ywm.model.role;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Roleエンティティのモデルクラス
 */
@Entity
@Table(name = "Role") 
public class Role {
	// 権限ID
	@Id
    @Column(name = "role_id" , nullable = false, unique = true) 
    private String roleId;
    
    // 権限コード
    @Column(name = "role_code" , nullable = false) 
    private int roleCode; 
    
    // 権限名
    @Column(name = "role_name" , nullable = false) 
    private String roleName; 
    
    // マスタ権限
    @Column(name = "master_permission") 
    private String masterPermission; 

	//初期登録日時
    @Column(name = "created_at", nullable = false)  
    private Date createdAt;
    
    //初期登録者
    @Column(name = "created_user", nullable = false)  
    private String createdUser;
    
    //最終更新日時
    @Column(name = "update_at", nullable = false)  
    private Date updateAt;
    
    //最終更新者
    @Column(name = "update_user", nullable = false)  
    private String updateUser;
    
    //有効フラグ
    @Column(name = "valid_flag", nullable = false)  
    private Boolean validFlag;
    
    //バージョン
    @Column(name = "version", nullable = false)  
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
    