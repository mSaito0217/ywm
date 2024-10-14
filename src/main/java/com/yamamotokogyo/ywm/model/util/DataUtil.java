package com.yamamotokogyo.ywm.model.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.yamamotokogyo.ywm.model.users.User;

/**
 * データ加工に関する共通部品
 */
public class DataUtil {
	
	
	
	/**
	 * ユーザ検索の結果を加工する処理
	 * @param result
	 * @return List<User>
	 */
	public static List<User> resultUserList(List<Map<String, Object>> result) {
		
		//返却用のリスト
        List<User> list = new ArrayList<User>();
        
        if(result.size() == 0) {
        	// 結果が0件であれば空のlistを返す
        	return list;
        }
        
        // 取得データのレコード数繰り返し
        for(int i = 0; result.size() > i; i++ ){
        	Map<String, Object> map = result.get(i);
        	// 空の箱を作成
        	User user = new User();
        	// すべてのキー（項目）を取得
        	List<String> keylist = map.keySet().stream().collect(Collectors.toCollection(ArrayList::new));
        	
        	for(int j = 0; keylist.size() > j; j++) {
        		String key = keylist.get(j);
        		//String value = (String) map.get(key);
        		if (key.equals("user_id")) {
        			user.setUserId((String)map.get(key));
        		} else if (key.equals("role_code")) {
        			user.setRoleCode((int) map.get(key));
        		} else if (key.equals("last_name")) {
        			user.setLastName((String)map.get(key));
        		} else if (key.equals("first_name")) {
        			user.setFirstName((String)map.get(key));
        		} else if (key.equals("email")) {
        			user.setEmail((String)map.get(key));
        		} else if (key.equals("valid_flag")) {
       				user.setValidFlag((Boolean)map.get(key));
        			
        		}
        	}
        	list.add(user);
        }
        
		return list;
	}

}
