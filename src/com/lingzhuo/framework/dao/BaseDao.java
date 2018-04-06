/**
 * 
 */
package com.lingzhuo.framework.dao;

import java.util.List;

import com.lingzhuo.entity.ExaminationEntity;
import com.lingzhuo.entity.ExamineeEntity;
import com.lingzhuo.framework.entity.BaseEntity;
import com.lingzhuo.vo.PageVo;

/**
 * @ClassName: BaseDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @param <Entity>
 * @date 2017年8月30日 下午4:49:16
 *
 */
public interface BaseDao<T extends BaseEntity>{
	public int saveEntity(T entity)throws Exception;
	public int updateEntity(T entity)throws Exception;
	public int deleteEntity(T entity)throws Exception;
	public List<T> selectAll(String wheresql)throws Exception;
	public T  selectByKey(String key)throws Exception;
	/**
	 * @param p
	 * @param e
	 * @return
	 * @throws Exception
	 */
	

}
