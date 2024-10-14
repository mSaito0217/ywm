package com.yamamotokogyo.ywm.model.role;

import jakarta.validation.constraints.NotEmpty;

/**
 * 権限検索画面から受け取る値に関するデータ転送オブジェクト (DTO)
 */
public class RoleSearchDto {

	// 権限ID
    @NotEmpty
    private String roleId; 
    
    // 権限コード
    private String roleCode; 
    
    // 権限名
    private String roleName; 
    
    // マスタ権限＿登録
    private String mpCreate; 
   
    // マスタ権限＿参照
    private String mpRead;
    
    // マスタ権限＿更新
    private String mpUpdate;
        
    // マスタ権限＿削除
    private String mpDelete;
            
    //有効フラグ
    private int valid;
    
    // 表示形式
    private String viewType;

	public String getRoleId() {
		return roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public String getMpCreate() {
		return mpCreate;
	}

	public String getMpRead() {
		return mpRead;
	}

	public String getMpUpdate() {
		return mpUpdate;
	}

	public String getMpDelete() {
		return mpDelete;
	}

	public int getValid() {
		return valid;
	}

	public String getViewType() {
		return viewType;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setMpCreate(String mpCreate) {
		this.mpCreate = mpCreate;
	}

	public void setMpRead(String mpRead) {
		this.mpRead = mpRead;
	}

	public void setMpUpdate(String mpUpdate) {
		this.mpUpdate = mpUpdate;
	}

	public void setMpDelete(String mpDelete) {
		this.mpDelete = mpDelete;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	
}
