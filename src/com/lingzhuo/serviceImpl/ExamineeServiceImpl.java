/**
 * 
 */
package com.lingzhuo.serviceImpl;

import java.util.List;

import com.lingzhuo.dao.ExamineeDao;
import com.lingzhuo.daoImpl.ExamineeDaoImpl;
import com.lingzhuo.entity.ExamineeEntity;
import com.lingzhuo.factory.BeanFactory;
import com.lingzhuo.service.ExamineeService;

/**
 * @ClassName: ExamineeServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月30日 下午5:17:44
 *
 */
public class ExamineeServiceImpl implements ExamineeService{
  public static ExamineeDao dao=(ExamineeDao) BeanFactory.getBeanFactory().getBean(ExamineeDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#saveEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int saveEntity(ExamineeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return dao.saveEntity(entity);
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#updateEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int updateEntity(ExamineeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#deleteEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int deleteEntity(ExamineeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#selectAll(java.lang.String)
	 */
	@Override
	public List<ExamineeEntity> selectAll(String wheresql) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#selectByKey(java.lang.String)
	 */
	@Override
	public ExamineeEntity selectByKey(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.service.ExamineeService#selectEntityByUser(java.lang.String, java.lang.String)
	 */
	@Override
	public ExamineeEntity selectEntityByUser(String username, String pwd)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.selectEntityByUser(username, pwd);
	}

}
