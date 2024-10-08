package com.yamamotokogyo.ywm.controller.service.users;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yamamotokogyo.ywm.model.users.User;

/**
 * ユーザーの認証情報を保持するクラス
 */
public class UserPrincipal implements UserDetails {
	
	 private User user; 

	    // コンストラクタでUserオブジェクトを受け取り、それをこのクラスのuserにセットします。
	    public UserPrincipal(User user) {
	        this.user = user;
	    }

	    // ユーザーに与えられる権限を返します。ここでは全てのユーザーに"USER"という権限を与えています。
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return Collections.singleton(new SimpleGrantedAuthority("USER"));
	    }
	    
	    
	    /**
	     * Userオブジェクトを返却
	     * @return
	     */
	    public User getUser() {
			return user;
	    }
	    

	    // Userオブジェクトのパスワードを返します。
	    @Override
	    public String getPassword() {
	        return user.getPassword();
	    }

	    // Userオブジェクトの名前を返します。
	    @Override
	    public String getUsername() {
	        return user.getLastName();
	    }

	    // アカウントが有効期限切れでないことを示すために、常にtrueを返します。
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    // アカウントがロックされていないことを示すために、常にtrueを返します。
	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    // 資格情報（ここではパスワード）が有効期限切れでないことを示すために、常にtrueを返します。
	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    // アカウントが有効であることを示すために、常にtrueを返します。
	    @Override
	    public boolean isEnabled() {
	        return true;
	    }


}
