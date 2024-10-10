package com.yamamotokogyo.ywm.controller.repository.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yamamotokogyo.ywm.model.users.User;

/**
 * Usersエンティティに関するリポジトリインターフェース
 */
// JpaRepositoryを拡張して、UserオブジェクトとそれらのIDとしてLong型を扱えるようにします。
public interface UserRepository extends JpaRepository<User, String> {
	
	// ユーザIDでユーザーを探すメソッド。
	User findByUserId(String userId);
	
	// 全件取得するメソッド
	List<User> findAll();
}