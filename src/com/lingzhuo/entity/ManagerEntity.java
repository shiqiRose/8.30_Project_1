/**
 * 
 */
package com.lingzhuo.entity;

import com.lingzhuo.framework.entity.BaseEntity;

/** 
 * @ClassName: ManagerEntity 
 * @Description: 系统管理员信息实体
 * @author Zyg 
 * @date 2017年8月30日 上午11:56:58 
 * 
 */

public class ManagerEntity extends BaseEntity{
	public ManagerEntity(){
		System.out.println("被实例化");
	}
	private Integer managerId ;//number(15) primary key  , 
	private String username;// varchar2(20) not null,
	private String   pwd;// varchar2(20) not null
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
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
	
	
}
