package com.yamamotokogyo.ywm.model.users;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Usersエンティティのモデルクラス
 */
@Entity  // DBテーブル
@Table(name = "Users")  // テーブル名
public class User {
	// ユーザID
	@Id
    @Column(name = "user_id" , nullable = false, unique = true) 
    private String userId;
    
    //権限コード
    @Column(name = "role_code" , nullable = false)  // データベースに合わせてカラム名を修正
    private String roleCode; 
    
    // 姓
    @Column(name = "last_name", nullable = false) 
    private String lastName;
    
    // 名
    @Column(name = "first_name", nullable = false) 
    private String firstName;
        
    // 姓（カナ）
    @Column(name = "last_name_kana") 
    private String lastNameKana;
    
    // 名（カナ）
    @Column(name = "first_name_kana") 
    private String firstNameKana;
    
    //パスワード
    @Column(name = "password", nullable = false) 
    private String password;
    
    //メールアドレス
    @Column(name = "email")  
    private String email;
    
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

    
	public String getUserId() {
		return userId;
	}

	public String getRoleCode() {
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

	public void setRoleCode(String roleCode) {
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
