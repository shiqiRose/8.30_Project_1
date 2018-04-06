/**
 * 
 */
package com.lingzhuo.entity;

import com.lingzhuo.framework.entity.BaseEntity;

/** 
 * @ClassName: ExamineeEntity 
 * @Description: 考生注册信息表
 * @author Zyg 
 * @date 2017年8月30日 上午11:51:21 
 * 
 */

public class ExamineeEntity extends BaseEntity{
	private Integer exaId;// 报考人id
	private String username;// 用户名
	private String  pwd;//  密码
	private String rname;// 真实姓名 
	private String  cardno ;//省份正号码  ,
	private String  exaLeve;// 报考级别   ,
	private String  sex ;//性别 varchar2(1),phone varchar2(11),
	private String  email ;//邮箱varchar2(50),
	private String birthday;
	private String phone;
	private String province;// 省份varchar2(20),
	private String exaDate ;//报考日期varchar2(8), 
	private String exaTime ;//报考时间varchar2(6), 
	private String photo;// 照片名称varchar2(100),
	private String photoURL;// 存储路径 varchar2(200),
	private String examinestate;// 审核状态 varchar2(1),
	private String unauditedReason;//  驳回原因varchar2(500),
	private Integer examineUser ;//审核人 id number(15)
    private String examineDatetime ;//审核日期时间 varchar2(14))
    
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getExaId() {
		return exaId;
	}
	public void setExaId(Integer exaId) {
		this.exaId = exaId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getExaLeve() {
		return exaLeve;
	}
	public void setExaLeve(String exaLeve) {
		this.exaLeve = exaLeve;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getExaDate() {
		return exaDate;
	}
	public void setExaDate(String exaDate) {
		this.exaDate = exaDate;
	}
	public String getExaTime() {
		return exaTime;
	}
	public void setExaTime(String exaTime) {
		this.exaTime = exaTime;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	public String getExaminestate() {
		return examinestate;
	}
	public void setExaminestate(String examinestate) {
		this.examinestate = examinestate;
	}
	public String getUnauditedReason() {
		return unauditedReason;
	}
	public void setUnauditedReason(String unauditedReason) {
		this.unauditedReason = unauditedReason;
	}
	public Integer getExamineUser() {
		return examineUser;
	}
	public void setExamineUser(Integer examineUser) {
		this.examineUser = examineUser;
	}
	public String getExamineDatetime() {
		return examineDatetime;
	}
	public void setExamineDatetime(String examineDatetime) {
		this.examineDatetime = examineDatetime;
	}
    /*
     * create table ExamineeTable(
Exa_id number(15) primary key, username varchar2(20) unique not null,

 pwd varchar2(20) not null, 
 rname varchar2(20) not null,
  cardno varchar2(20) not null,
  exa_leve varchar2(2),birthday varchar2(8),
  sex varchar2(1),phone varchar2(11),
  email varchar2(50),
 Province varchar2(20),
 exa_date varchar2(8), 
 exa_time varchar2(6), 
 photo varchar2(100),
 photoURL varchar2(200),
 examinestate varchar2(1),
 UnauditedReason  varchar2(500),
 examineuser number(15),examinedatetime varchar2(14))
     * */
    
}
