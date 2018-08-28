package com.restservice.userdao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Component;

import com.restserive.user.User;

@Component
public class UserDao {
	
	static List<User> users = new ArrayList<User>();
	static int userCount=4;
	static {
		
		users.add(new User(1,"Shri",LocalDate.now()));
		users.add(new User(2,"shru",LocalDate.now()));
		users.add(new User(3,"sunny",LocalDate.now()));
		users.add(new User(4,"iru",LocalDate.now()));
	}
	public List<User> findAll()
	{
		return users;
	}
	public  User save(User user)
	{
		if(user.getId()==null)
		{
			user.setId(userCount++);

		}
		users.add(user);
		return user;

	}
	
	public User findById(int id)
	{
		for(User user:users)
		{
			if(user.getId()==id)
			{
				return user;
			}
		}
		return null;
	}
		public  User deleteById(int id)
		{
			Iterator<User> iterator=users.iterator();
			while(iterator.hasNext())
			{
				User user=iterator.next();
				if(user.getId()==id)
				{
					iterator.remove();
					return user;
				}
			}
			return null;
		}
	}

