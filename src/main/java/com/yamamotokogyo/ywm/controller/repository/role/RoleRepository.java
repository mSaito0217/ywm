package com.yamamotokogyo.ywm.controller.repository.role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yamamotokogyo.ywm.model.role.Role;

/**
 * Roleエンティティに関するリポジトリインターフェース
 */
public interface RoleRepository extends JpaRepository<Role, String> {
	
	// 全件取得するメソッド
	List<Role> findAll();
	
}
