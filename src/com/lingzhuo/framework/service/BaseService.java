/**
 * 
 */
package com.lingzhuo.framework.service;

import java.util.List;

import com.lingzhuo.framework.entity.BaseEntity;

/**
 * @ClassName: BaseService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月30日 下午4:55:30
 *
 */
public interface BaseService<T extends BaseEntity> {
	public int saveEntity(T entity)throws Exception;
	public int updateEntity(T entity)throws Exception;
	public int deleteEntity(T entity)throws Exception;
	public List<T> selectAll(String wheresql)throws Exception;
	public T  selectByKey(String key)throws Exception;

}
