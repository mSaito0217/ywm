package com.yamamotokogyo.ywm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.yamamotokogyo.ywm.model.users.User;
import com.yamamotokogyo.ywm.model.users.UserSearchDto;

public interface UserDao extends Serializable {

    public List<User> search();

	/**
	 * 指定条件で検索を実行する
	 */
	List<User> search(UserSearchDto userSearchDto);
    
}