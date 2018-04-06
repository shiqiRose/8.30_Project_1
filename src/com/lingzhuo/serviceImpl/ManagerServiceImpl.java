/**
 * 
 */
package com.lingzhuo.serviceImpl;

import java.util.List;

import com.lingzhuo.dao.ManagerDao;
import com.lingzhuo.daoImpl.ManagerDaoImpl;
import com.lingzhuo.entity.ManagerEntity;
import com.lingzhuo.factory.BeanFactory;
import com.lingzhuo.service.ManagerService;

/**
 * @ClassName: ManagerServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月30日 下午5:18:36
 *
 */
public class ManagerServiceImpl implements ManagerService{
  public  static ManagerDao dao=(ManagerDao) BeanFactory.getBeanFactory().getBean(ManagerDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#saveEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int saveEntity(ManagerEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#updateEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int updateEntity(ManagerEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#deleteEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int deleteEntity(ManagerEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#selectAll(java.lang.String)
	 */
	@Override
	public List<ManagerEntity> selectAll(String wheresql) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#selectByKey(java.lang.String)
	 */
	@Override
	public ManagerEntity selectByKey(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.service.ManagerService#selectEntityByUser(java.lang.String, java.lang.String)
	 */
	@Override
	public ManagerEntity selectEntityByUser(String username, String pwd)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.selectEntityByUser(username, pwd);
	}

}
