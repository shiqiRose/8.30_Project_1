/**
 * 
 */
package com.lingzhuo.entity;

import com.lingzhuo.framework.entity.BaseEntity;

/** 
 * @ClassName: ExaminationEntity 
 * @Description: 考务人员信息实体 
 * @author Zyg 
 * @date 2017年8月30日 上午11:58:33 
 * 
 */

public class ExaminationEntity extends BaseEntity {
	private Integer examinationId ;//number(15) primary key , 
	 private String  username ;//用户名 varchar2(20) not null,
	 private String   pwd  ;//密码 varchar2(20) not null,
	 private String  rname ;//真实姓名 varchar2(20) not null,
	 private String sex;//性别 varchar2(1),
	 private String   cardno;//身份证号码  varchar2(20), 
	 private String createDate;//创建日期 varchar2(8), 
	 private String createTime ;//创建时间 varchar2(6), 
	 private String createuser;//创建人id  number(15))
	public Integer getExaminationId() {
		return examinationId;
	}
	public void setExaminationId(Integer examinationId) {
		this.examinationId = examinationId;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
}
