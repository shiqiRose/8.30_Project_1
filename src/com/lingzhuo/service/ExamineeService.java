/**
 * 
 */
package com.lingzhuo.service;

import com.lingzhuo.entity.ExaminationEntity;
import com.lingzhuo.entity.ExamineeEntity;
import com.lingzhuo.framework.service.BaseService;

/**
 * @ClassName: ExamineeService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月30日 下午5:13:53
 *
 */
public interface ExamineeService extends BaseService<ExamineeEntity>{
	public ExamineeEntity selectEntityByUser(String username,String pwd)throws Exception;
}
