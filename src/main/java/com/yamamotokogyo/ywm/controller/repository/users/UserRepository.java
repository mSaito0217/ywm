package com.yamamotokogyo.ywm.controller.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yamamotokogyo.ywm.model.users.User;

/**
 * Usersエンティティに関するリポジトリインターフェース
 */
// JpaRepositoryを拡張して、UserオブジェクトとそれらのIDとしてLong型を扱えるようにします。
public interface UserRepository extends JpaRepository<User, String> {
 // メールアドレスでユーザーを探すメソッド。
	User findByUserId(String userId);
}