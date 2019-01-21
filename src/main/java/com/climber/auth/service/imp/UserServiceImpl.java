package com.climber.auth.service.imp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.climber.auth.bean.UserInfo;
import com.climber.auth.bean.UserInfoDetails;
import com.climber.auth.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {

	private final static Set<UserInfo> users = new HashSet<>();
	 
    static {
        users.add(new UserInfo(1, "user1", new BCryptPasswordEncoder().encode("123456")));
        users.add(new UserInfo(2, "user2",	new BCryptPasswordEncoder().encode("123456")));
        users.add(new UserInfo(3, "user3", new BCryptPasswordEncoder().encode("123456")));
        users.add(new UserInfo(4, "user4", new BCryptPasswordEncoder().encode("123456")));
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		for (UserInfo user : users) {
			if(user.getUserName().equals(username)){
				return UserDetailConverter.convert(user);
			}
		}
		return null;
	}
	
	
	private static class UserDetailConverter {
        static UserDetails convert(UserInfo user) {
            return new UserInfoDetails(user);
        }
    }

}
