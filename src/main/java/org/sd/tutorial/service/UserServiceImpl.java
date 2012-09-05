package org.sd.tutorial.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.sd.tutorial.dao.UserDAO;
import org.sd.tutorial.form.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
public class UserServiceImpl implements UserService {

	protected static Logger logger = Logger.getLogger("service");

	@Qualifier("userDAOImpl")
	@Autowired
	private UserDAO userDAO;

	@Transactional
	public void addUser(User user) {
		logger.debug(" ** addUser method of UserServiceImpl Invoked ** ");
		userDAO.addUser(user);
		logger.debug(" ** addUser method of UserServiceImpl Revoked ** ");
	}

	@Transactional
	public List<User> listUser() {
		logger.debug(" ** listUser method of UserServiceImpl Invoked ** ");
		logger.debug(" ** listUser method of UserServiceImpl Revoked ** ");
		return userDAO.listUser();
	}

	@Transactional
	public void removeUser(Integer userid) {
		logger.debug(" ** removeUser method of UserServiceImpl Invoked ** ");
		userDAO.removeUser(userid);
		logger.debug(" ** removeUser method of UserServiceImpl Revoked ** ");
	}

	@Transactional
	public void getUserLocation(String username) {
		logger.debug(" ** getUserLocation method of UserServiceImpl Invoked ** ");
		userDAO.getUserLocation(username);
		logger.debug(" ** getUserLocation method of UserServiceImpl Revoked ** ");
	}
}
