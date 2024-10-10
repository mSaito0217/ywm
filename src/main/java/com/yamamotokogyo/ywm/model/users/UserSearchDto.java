package com.yamamotokogyo.ywm.model.users;

import jakarta.validation.constraints.NotEmpty;

/**
 * ユーザ検索画面から受け取る値に関するデータ転送オブジェクト (DTO)
 */
public class UserSearchDto {

	// ユーザーID
    @NotEmpty
    private String userId; 
    
    // 権限(管理者）
    private int roleAdmin; 
    
    // 権限(社員）
    private int roleEmployee; 
    
    // 権限(契約社員）
    private int roleContract; 
   
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
    
    // メールアドレス
    private String email;
            
    //有効フラグ
    @NotEmpty
    private int valid;
    
    //バージョン
    @NotEmpty
    private int version;
    
    // 表示形式
    private String viewType;

	public String getUserId() {
		return userId;
	}

	public int getRoleAdmin() {
		return roleAdmin;
	}

	public int getRoleEmployee() {
		return roleEmployee;
	}

	public int getRoleContract() {
		return roleContract;
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

	public String getEmail() {
		return email;
	}

	public int getValid() {
		return valid;
	}

	public int getVersion() {
		return version;
	}

	public String getViewType() {
		return viewType;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setRoleAdmin(int roleAdmin) {
		this.roleAdmin = roleAdmin;
	}

	public void setRoleEmployee(int roleEmployee) {
		this.roleEmployee = roleEmployee;
	}

	public void setRoleContract(int roleContract) {
		this.roleContract = roleContract;
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
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}


}
