package org.sd.tutorial.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.sd.tutorial.form.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {

	protected static Logger logger = Logger.getLogger("dao");

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * public UserDAOImpl() { this(sessionFactory); }
	 */
	/*
	 * public UserDAOImpl(SessionFactory sessionfactory) {
	 * logger.debug(" ** UserDAOImpl method of UserDAOImpl Invoked ** ");
	 * logger.debug(sessionfactory); this.sessionFactory = sessionfactory;
	 * logger.debug(this.sessionFactory); }
	 */

	@Transactional
	public void addUser(User user) {
		logger.debug(" ** addUser method of UserDAOImpl Invoked ** ");
		sessionFactory.getCurrentSession().save(user);
		logger.debug(" ** addUser method of UserDAOImpl Revoked ** ");
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> listUser() {

		logger.debug(" ** listUser method of UserDAOImpl Invoked ** ");
		logger.debug(" ** listUser method of UserDAOImpl Revoked ** ");
		return sessionFactory.getCurrentSession().createQuery("from User")
				.list();
	}

	@Transactional
	public void removeUser(Integer userid) {
		logger.debug(" ** removeUser method of UserDAOImpl Invoked ** ");
		User user = (User) sessionFactory.getCurrentSession().load(User.class,
				userid);
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}
		logger.debug(" ** removeUser method of UserDAOImpl Revoked ** ");
	}

	@Transactional
	public void getUserLocation(String username) {
		logger.debug(" ** getUserLocation method of UserDAOImpl Invoked ** ");
		User user = (User) sessionFactory.getCurrentSession().load(User.class,
				username);
		if (null != user) {
			sessionFactory.getCurrentSession().createQuery(
					"select location from user ");
		}
		logger.debug(" ** getUserLocation method of UserDAOImpl Revoked** ");
	}
}
