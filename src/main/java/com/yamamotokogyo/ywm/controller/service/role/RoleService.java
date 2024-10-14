package com.yamamotokogyo.ywm.controller.service.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamamotokogyo.ywm.controller.repository.role.RoleRepository;
import com.yamamotokogyo.ywm.model.role.Role;

/**
 * Roleエンティティに関するサービスクラス
 */
@Service
public class RoleService {

	@Autowired 
	private RoleRepository roleRepository;
	
	//全件検索
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

}
