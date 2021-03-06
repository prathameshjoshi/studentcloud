package org.sd.tutorial.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@Table(name = "user")
public class User {

	protected static Logger logger = Logger.getLogger("controller");

	@Id
	@Column(name = "USER_ID")
	private Integer userid;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ENABLED")
	private Integer enabled;

	@Column(name = "AUTHORITY")
	private String authority;

	@Column(name = "LOCATION")
	private String location;

	public Integer getUserid() {
		logger.debug(" ** getUserid method of User Invoked ** ");
		logger.debug(" ** getUserid method of User Revoked ** ");
		return userid;
	}

	public void setUserid(Integer userid) {
		logger.debug(" ** setUserid method of User Invoked ** ");
		this.userid = userid;
		logger.debug(" ** setUserid method of User Revoked ** ");
	}

	public String getUsername() {
		logger.debug(" ** getUsername method of User Invoked ** ");
		logger.debug(" ** getUsername method of User Revoked ** ");
		return username;
	}

	public void setUsername(String username) {
		logger.debug(" ** setUsername method of User Invoked ** ");
		this.username = username;
		logger.debug(" ** setUsername method of User Revoked ** ");
	}

	public String getPassword() {
		logger.debug(" ** getPassword method of User Invoked ** ");
		logger.debug(" ** getPassword method of User Revoked ** ");
		return password;
	}

	public void setPassword(String password) {
		logger.debug(" ** setPassword method of User Invoked ** ");
		this.password = password;
		logger.debug(" ** setPassword method of User Revoked ** ");
	}

	public Integer getEnabled() {
		logger.debug(" ** getEnabled method of User Invoked ** ");
		logger.debug(" ** getEnabled method of User Revoked ** ");
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		logger.debug(" ** setEnabled method of User Invoked ** ");
		this.enabled = enabled;
		logger.debug(" ** setEnabled method of User Revoked ** ");
	}

	public String getAuthority() {
		logger.debug(" ** getAuthority method of User Invoked ** ");
		logger.debug(" ** getAuthority method of User Revoked ** ");
		return authority;
	}

	public void setAuthority(String authority) {
		logger.debug(" ** setAuthority method of User Invoked ** ");
		this.authority = authority;
		logger.debug(" ** setAuthority method of User Invoked ** ");
	}

	public String getLocation() {
		logger.debug(" ** getLocation method of User Invoked ** ");
		logger.debug(" ** getLocation method of User Revoked ** ");
		return location;
	}

	public void setLocation(String location) {
		logger.debug(" ** setLocation method of User Invoked ** ");
		this.location = location;
		logger.debug(" ** setLocation method of User Revoked ** ");
	}

}
