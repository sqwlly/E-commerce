package user.model;

/**
 * @描述 : 用户扩展信息
 * @创建者：程新状
 * @创建时间： 2020/4/26
 *
 */
public class UserExtendInfo {

	/** 所在学校 **/
	private String school;
	/** 住址 **/
	private String address;
	/** 身份证 **/
	private String codeNum;
	/** 手机号 **/
	private String phone;

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCodeNum() {
		return codeNum;
	}

	public void setCodeNum(String codeNum) {
		this.codeNum = codeNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
