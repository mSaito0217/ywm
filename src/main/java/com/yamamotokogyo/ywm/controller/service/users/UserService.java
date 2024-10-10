package com.yamamotokogyo.ywm.controller.service.users;

import java.util.Date;
import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yamamotokogyo.ywm.controller.config.CommonVariable;
import com.yamamotokogyo.ywm.controller.repository.users.UserDaoImpl;
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

 @Autowired
 private UserDaoImpl userDaoImpl;
 
 public String mUserId = "ユーザID";
 public String mLastName = "ユーザ名（姓）";
 
 
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
 *ユーザ情報を登録するサービス 
 * @param userDto
 */
@Transactional // トランザクション開始
 public String save(UserDto userDto, Authentication authentication) {
     // UserDtoからUserへの変換
     User user = new User();
     
     // 登録前のバリデーションチェック
     if (checkValidation(userDto) != null) {
    	 // エラーメッセージが返却された場合は登録エラーとする
    	 return checkValidation(userDto);
     }
     
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
     user.setRoleCode(1);
     
     // 有効フラグ
     user.setValidFlag(true);
     
     // カレンダー日を取得
     // 現在日時を取得
     Date date = new Date();
     
     // 日時項目を設定
     user.setCreatedAt(date);
     user.setUpdateAt(date);
     
     // ログインユーザを取得
     UserPrincipal userInfo = (UserPrincipal) authentication.getPrincipal();
     // 登録日と更新日にユーザIDを設定
     user.setCreatedUser(userInfo.getUserID());
     user.setUpdateUser(userInfo.getUserID());
     
     // 新規登録なのでバージョンは0固定
     user.setVersion(0);
     
     // データベースへの保存
     userRepository.save(user); 
     
     System.out.println("ユーザ登録が完了しました。ユーザID：" + userDto.getUserId());
     
     return CommonVariable.MSG_00;
 }


	/**
	 * ユーザ情報のバリデーションチェック
	 * @param userDto
	 */
	public String checkValidation(UserDto userDto) {
		
		// ユーザID
		if (userDto.getUserId().isBlank()) {
			// null もしくは 空 もしくは 空文字のみ
			return CommonVariable.ERROR_MSG_00 + mUserId;
		} else if (userDto.getUserId().length() > 8) {
			// 8文字以上の場合
			return "8"+ CommonVariable.ERROR_MSG_01 + mUserId;
		}
		
		// 姓
		if (userDto.getLastName().isBlank()) {
			// null もしくは 空 もしくは 空文字のみ
			return CommonVariable.ERROR_MSG_00 + mLastName;
		} else if (userDto.getLastName().length() > 255) {
			// 255文字以上の場合
			return "255"+ CommonVariable.ERROR_MSG_01 + mLastName;
		} 
		
		// TODO バリデーションチェックを追加する
		
		return null;
	}
	
    //全件検索
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
