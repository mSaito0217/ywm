package com.yamamotokogyo.ywm.controller.service.users;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yamamotokogyo.ywm.config.CommonVariable;
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
	*ユーザ情報を更新するサービス 
	* @param userDto
	*/
	@Transactional // トランザクション開始
	public Map<String, User> update(User oldUser, UserDto userDto, Authentication authentication) {
		// UserDtoからUserへの変換
		User user = new User();
		// 返却用
		Map<String,User> map = new LinkedHashMap<String,User>();

		// 更新前のバリデーションチェック
		if (checkValidation(userDto) != null) {
			// エラーメッセージが返却された場合は登録エラーとする
			map.put(checkValidation(userDto), user);
			return map;
		}

		// ユーザID
		user.setUserId(oldUser.getUserId());

		// 姓
		if (userDto.getFirstName().isBlank()) {
			user.setFirstName(oldUser.getFirstName());
		} else {
			user.setFirstName(userDto.getFirstName());
		}

		// 名
		if (userDto.getLastName().isBlank()) {
			user.setLastName(oldUser.getLastName());
		} else {
			user.setLastName(userDto.getLastName());
		}

		// 姓（カナ）
		if (userDto.getFirstNameKana().isBlank()) {
			user.setFirstNameKana(oldUser.getFirstNameKana());
		} else {
			user.setFirstNameKana(userDto.getFirstNameKana());
		}

		// 名（カナ）
		if (userDto.getLastNameKana().isBlank()) {
			user.setLastNameKana(oldUser.getLastNameKana());
		} else {
			user.setLastNameKana(userDto.getLastNameKana());
		}

		// パスワードをハッシュ化してから保存
		if (userDto.getPassword().isBlank()) {
			user.setPassword(oldUser.getPassword());
		} else {
			user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		}

		// メールアドレス
		if (userDto.getEmail().isBlank()) {
			user.setEmail(oldUser.getEmail());
		} else {
			user.setEmail(userDto.getEmail());
		}

		// 権限コード
		// TODO
		if (userDto.getRoleCode() == 0) {
			user.setRoleCode(oldUser.getRoleCode());
		} else {
			user.setRoleCode(userDto.getRoleCode());
		}

		// 有効フラグ
		// TODO
		if (userDto.getValidFlag() == null) {
			user.setValidFlag(oldUser.getValidFlag());
		} else {
			user.setValidFlag(userDto.getValidFlag());
		}

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

		// 前のバージョンからインクリメント
		user.setVersion(oldUser.getVersion() + 1);

		// データベースへの保存
		userRepository.save(user);

		System.out.println("ユーザ更新が完了しました。ユーザID：" + userDto.getUserId());
		map.put(CommonVariable.MSG_00, user);
		
		return map;
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
			return "8" + CommonVariable.ERROR_MSG_01 + mUserId;
		}

		// 姓
		if (userDto.getLastName().isBlank()) {
			// null もしくは 空 もしくは 空文字のみ
			return CommonVariable.ERROR_MSG_00 + mLastName;
		} else if (userDto.getLastName().length() > 255) {
			// 255文字以上の場合
			return "255" + CommonVariable.ERROR_MSG_01 + mLastName;
		}

		// TODO バリデーションチェックを追加する

		return null;
	}

	//全件検索
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
