/**
 * 
 */
package com.lingzhuo.service;

import com.lingzhuo.entity.ExaminationEntity;
import com.lingzhuo.entity.ManagerEntity;
import com.lingzhuo.framework.service.BaseService;

/**
 * @ClassName: ManagerService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月30日 下午5:15:00
 *
 */
public interface ManagerService extends BaseService<ManagerEntity>{
	public ManagerEntity selectEntityByUser(String username,String pwd)throws Exception;
}
