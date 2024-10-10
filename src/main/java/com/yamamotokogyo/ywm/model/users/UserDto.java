package com.yamamotokogyo.ywm.model.users;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;

/**
 * Userエンティティに関するデータ転送オブジェクト (DTO)
 */
public class UserDto {

	// ユーザーID
    @NotEmpty
    private String userId; 
    
    // 権限コード
    @NotEmpty
    private int roleCode; 
   
    // 姓
    @NotEmpty
    private String lastName;
    
    // 名
    @NotEmpty
    private String firstName;
        
    // 姓（カナ）
    private String lastNameKana;
    
    // 名（カナ）
    private String firstNameKana;
    
    //パスワード
    @NotEmpty
    private String password;
    
    //メールアドレス 
    private String email;
    
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

	public String getUserId() {
		return userId;
	}

	public int getRoleCode() {
		return roleCode;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastNameKana() {
		return lastNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
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

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
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
