package org.sd.tutorial.service;

import java.util.List;

import org.sd.tutorial.form.User;

public interface UserService {

	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(Integer userid);

	public void getUserLocation(String username);
}
