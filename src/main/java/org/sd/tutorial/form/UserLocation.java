package org.sd.tutorial.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@Table(name = "user_location")
public class UserLocation {

	protected static Logger logger = Logger.getLogger("controller");

	@Id
	@Column(name = "USER_LOCATION_ID")
	private Integer userlocationid;

	@Column(name = "USER_ID")
	private Integer userid;

	@Column(name = "LOCATION")
	private String location;

	public void setUserlocationid(Integer userlocationid) {
		logger.debug(" ** setUserLocationId method of UserLocation Invoked ** ");
		this.userlocationid = userlocationid;
		logger.debug(" ** setUserLocationId method of UserLocation Revoked ** ");
	}

	public Integer getUserlocationid() {
		logger.debug(" ** getUserlocaitonid method of UserLocation Invoked ** ");
		logger.debug(" ** getUserlocationid method of UserLocation Revoked ** ");
		return userlocationid;
	}

	public String getLocation() {
		logger.debug(" ** getLocation method of UserLocation Invoked ** ");
		logger.debug(" ** getLocation method of UserLocation Revoked ** ");
		return location;
	}

	public void setLocation(String location) {
		logger.debug(" ** setLocation method of UserLocation Invoked ** ");
		this.location = location;
		logger.debug(" ** setLocation method of UserLocation Revoked ** ");
	}

	public Integer getUserid() {
		logger.debug(" ** getUserid method of UserLocation Invoked ** ");
		logger.debug(" ** getUserid method of UserLocation Revoked ** ");
		return userid;
	}

	public void setUserid(Integer userid) {
		logger.debug(" ** setUserid method of UserLocation Invoked ** ");
		this.userid = userid;
		logger.debug(" ** setUserid method of UserLocation Revoked ** ");
	}

}
