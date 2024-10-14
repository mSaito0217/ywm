package com.yamamotokogyo.ywm.controller.repository.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yamamotokogyo.ywm.model.dao.UserDao;
import com.yamamotokogyo.ywm.model.users.User;
import com.yamamotokogyo.ywm.model.users.UserSearchDto;
import com.yamamotokogyo.ywm.model.util.DataUtil;

@Repository
public class UserDaoImpl implements UserDao {

    //Entityを利用するために必要な機能を提供する
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public UserDaoImpl() {
        super();
    }

    public UserDaoImpl(EntityManager manager) {
        this();
        entityManager = manager;
    }
	
	
	/**
	 * 指定条件で検索を実行する
	 */
	public List<User> search(UserSearchDto userSearchDto) {
		StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("u.user_id, ");
        sql.append("u.role_code, ");
        sql.append("u.last_name, ");
        sql.append("u.first_name, ");
        sql.append("u.email, ");
        sql.append("u.valid_flag ");
        sql.append("FROM ");
        sql.append("users u ");
        
        
        List<String> sqlList = new ArrayList<String>();
        
        // ユーザID
        if (!userSearchDto.getUserId().isBlank()) {
        	sqlList.add("u.user_id like '%" + userSearchDto.getUserId() + "%'");
        }
        
        // ロールコード
        List<String> role = new ArrayList<>();
        if (userSearchDto.getRoleAdmin() != 0) {
        	role.add("1"); // 管理者
        }
        if (userSearchDto.getRoleEmployee() != 0) {
        	role.add("2"); // 社員
        }
        if (userSearchDto.getRoleContract() != 0) {
        	role.add("3"); // 契約社員
        }
        if(role.size() > 0) {
        	sqlList.add("u.role_code in (" + String.join(" , ",role) + ")");
        }
        
        // 姓
        if (!userSearchDto.getLastName().isBlank()) {
        	sqlList.add("u.last_name like '%" + userSearchDto.getLastName() + "%'");
        }
        
        // 名
        if (!userSearchDto.getFirstName().isBlank()) {
        	sqlList.add("u.first_name like '%" + userSearchDto.getFirstName() + "%'");
        }
        
        // 姓（カナ）
        if (!userSearchDto.getLastNameKana().isBlank()) {
        	sqlList.add("u.last_name_kana like '%" + userSearchDto.getLastNameKana() + "%'");
        }
        
        // 名（カナ）
        if (!userSearchDto.getFirstNameKana().isBlank()) {
        	sqlList.add("u.first_name_kana like '%" + userSearchDto.getFirstNameKana() + "%'");
        }
        
        // メールアドレス
        if (!userSearchDto.getEmail().isBlank()) {
        	sqlList.add("u.email like '%" + userSearchDto.getEmail() + "%'");
        }
        
        // 無効を含まない
        if (userSearchDto.getValid() == 1) {
        	sqlList.add("u.valid_flag = true");
        }
        
        if (sqlList.size() != 0) {
        	sql.append("WHERE ");
        	sql.append(String.join(" and ", sqlList));
        }
        
        //SQLの出力
        System.out.println(sql.toString());
        
        // SQLの実行
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql.toString());
        
        // 結果の整形
        List<User> users = DataUtil.resultUserList(result);
        
        return users;
	}

	@Override
	public List<User> search() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	

	
}
