/**
 * 
 */
package com.lingzhuo.serviceImpl;

import java.util.List;

import com.lingzhuo.dao.ExaminationDao;
import com.lingzhuo.daoImpl.ExminationDaoImpl;
import com.lingzhuo.entity.ExaminationEntity;
import com.lingzhuo.entity.ExamineeEntity;
import com.lingzhuo.factory.BeanFactory;
import com.lingzhuo.service.ExaminationService;
import com.lingzhuo.vo.PageVo;

/**
 * @ClassName: ExaminationServiceIMpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月30日 下午5:16:18
 *
 */
public class ExaminationServiceImpl implements ExaminationService{
    private static ExaminationDao dao=(ExaminationDao) BeanFactory.getBeanFactory().getBean(ExminationDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#saveEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int saveEntity(ExaminationEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#updateEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int updateEntity(ExaminationEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#deleteEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int deleteEntity(ExaminationEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#selectAll(java.lang.String)
	 */
	@Override
	public List<ExaminationEntity> selectAll(String wheresql) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.service.BaseService#selectByKey(java.lang.String)
	 */
	@Override
	public ExaminationEntity selectByKey(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.service.ExaminationService#selectEntityByUser(java.lang.String, java.lang.String)
	 */
	@Override
	public ExaminationEntity selectEntityByUser(String username, String pwd)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.selectEntityByUser(username, pwd);
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.service.ExaminationService#selectEntityTotal(com.lingzhuo.entity.ExaminationEntity)
	 */
	@Override
	public int selectEntityTotal(ExamineeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectEntityTotal(entity);
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.service.ExaminationService#selectEntityPageTotal(com.lingzhuo.vo.PageVo, com.lingzhuo.entity.ExamineeEntity)
	 */
	@Override
	public List<ExamineeEntity> selectEntityPageTotal(PageVo p,ExamineeEntity entity)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.selectEntityPageTotal(p,entity);
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.service.ExaminationService#deleteEntityById(java.lang.Integer)
	 */
	@Override
	public int deleteEntityById(Integer exaId) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteEntityById(exaId);
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.service.ExaminationService#selectEntityById(java.lang.String)
	 */
	@Override
	public ExamineeEntity selectEntityById(String key) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectEntityById(key);
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.service.ExaminationService#updateExaminee(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int updateExaminee(String exid, String state, String userId,
			String examineMsg) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateExaminee(exid, state, userId, examineMsg);
	}

}
