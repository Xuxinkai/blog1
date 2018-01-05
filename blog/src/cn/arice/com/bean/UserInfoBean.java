package cn.arice.com.bean;
/**
 * 
 * @author Arice 徐新凯
 * @description UserInfoBean 使用人的信息
 * @since 2016-4-5 下午4:14:11
 * @version 1.0
 *
 */
public class UserInfoBean {
	/**用户编号**/
	private String userid;
	/**登录名**/
	private String loginname;
	/**登录密码**/
	private String password;
	/**真实姓名**/
	private String realname;
	/**性别**/
	private String sex;
	/**出生日期**/
	private String birthday;
	/**邮箱**/
	private String email;
	/**电话号码**/
	private String telnumber;
	/**出生地址**/
	private String birthplace;
	/**居住地址**/
	private String liveplace;
	/**最后登录时间**/
	private String lastlogintime;
	/**介绍**/
	private String introduce;
	
	
	public UserInfoBean() {
		// TODO Auto-generated constructor stub
	}


	public UserInfoBean(String userid, String loginname, String password,
			String realname, String sex, String birthday, String email,
			String telnumber, String birthplace, String liveplace,
			String lastlogintime, String introduce) {
		super();
		this.userid = userid;
		this.loginname = loginname;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
		this.telnumber = telnumber;
		this.birthplace = birthplace;
		this.liveplace = liveplace;
		this.lastlogintime = lastlogintime;
		this.introduce = introduce;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getLoginname() {
		return loginname;
	}


	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRealname() {
		return realname;
	}


	public void setRealname(String realname) {
		this.realname = realname;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelnumber() {
		return telnumber;
	}


	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}


	public String getBirthplace() {
		return birthplace;
	}


	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}


	public String getLiveplace() {
		return liveplace;
	}


	public void setLiveplace(String liveplace) {
		this.liveplace = liveplace;
	}


	public String getLastlogintime() {
		return lastlogintime;
	}


	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}


	public String getIntroduce() {
		return introduce;
	}


	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
}
