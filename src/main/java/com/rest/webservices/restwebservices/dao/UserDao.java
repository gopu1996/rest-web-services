package com.rest.webservices.restwebservices.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.rest.webservices.restwebservices.user.UserEntity;

@Component
public class UserDao {
	
	private static List<UserEntity> users = new ArrayList<>();
	
	private static int userCount = 0;
	
	static {
		users.add(new UserEntity(++userCount, "Gopal", LocalDate.now().minusYears(30)));
		users.add(new UserEntity(++userCount, "Navi", LocalDate.now().minusYears(20)));
		users.add(new UserEntity(++userCount, "milan", LocalDate.now().minusYears(24)));
		users.add(new UserEntity(++userCount, "Nishant", LocalDate.now().minusYears(29)));
		users.add(new UserEntity(++userCount, "pintu", LocalDate.now().minusYears(26)));
	}
	
	public List<UserEntity> findAll(){
		return users;
	}
	
	public UserEntity findOne(int id) {
//		return users.stream().filter(x -> x.getiD().equals(id)).findFirst().get();
		
		Predicate<? super UserEntity> predicate = user -> user.getiD().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public List<UserEntity> deleteUserById(int id) {
	
		 users.remove(users.stream().filter(x -> x.getiD().equals(id)).findFirst().get());
		 
		 return users ;
	}

	
	public UserEntity saveUser(UserEntity user) {
		user.setiD(++userCount);
		users.add(user);
		return user;
	}


}
