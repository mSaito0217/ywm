package com.yamamotokogyo.ywm.controller.service.users;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yamamotokogyo.ywm.controller.repository.users.UserRepository;
import com.yamamotokogyo.ywm.model.users.User;
import com.yamamotokogyo.ywm.model.users.UserDto;

/**
 * Usersエンティティに関するサービスクラス
 */
@Service
public class UserService implements UserDetailsService { 

 @Autowired // Springが自動的にUserRepositoryの実装を注入します
 private UserRepository userRepository;

 @Autowired // Springが自動的にPasswordEncoderの実装を注入します
 private PasswordEncoder passwordEncoder;
 
 
 /**
 *ログイン時にユーザIDでユーザを検索するサービス
 */
@Override 
 public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
     User user = userRepository.findByUserId(userId); // ユーザーIDでユーザーを検索
     if (user == null) {
         throw new UsernameNotFoundException("User not found"); // ユーザーが見つからない場合
     }
     return new UserPrincipal(user); // ユーザーが見つかった場合
 }

 
 /**
 * ユーザIDでユーザ情報を検索するサービス
 * @param userId
 * @return
 */
public User findByUserId(String userId) {
     return userRepository.findByUserId(userId); 
 }


/**
 * 全件検索
 */
public Map<String, User> findByAll() {
	Map<String, User> users = new HashMap<String, User>(); 
	return users;
}
 
 /**
 *ユーザ情報を登録するサービス 
 * @param userDto
 */
@Transactional // トランザクション開始
 public void save(UserDto userDto) {
     // UserDtoからUserへの変換
     User user = new User();
     
     // ユーザID
     user.setUserId(userDto.getUserId());
     
     // 姓
     user.setFirstName(userDto.getFirstName());
     
     // 名
     user.setLastName(userDto.getLastName());
     
     // 姓（カナ）
     user.setFirstNameKana(userDto.getFirstNameKana());
     
     // 名（カナ）
     user.setLastNameKana(userDto.getLastNameKana());
     
     // パスワードをハッシュ化してから保存
     user.setPassword(passwordEncoder.encode(userDto.getPassword()));
     
     // メールアドレス
     user.setEmail(userDto.getEmail());
     
     // 権限コード
     user.setRoleCode("1");
     
     // 有効フラグ
     user.setValidFlag(true);
     
     // カレンダー日を取得
     // 現在日時を取得
     Date date = new Date();
     
     // 日時項目を設定
     user.setCreatedAt(date);
     user.setUpdateAt(date);
     
     user.setCreatedUser("test");
     user.setUpdateUser("test");
     
     user.setVersion(0);
     
     // データベースへの保存
     userRepository.save(user); // UserRepositoryを使ってユーザーをデータベースに保存します
     
     System.out.println("ユーザ登録が完了しました。ユーザID：" + userDto.getUserId());
     
 }
}
