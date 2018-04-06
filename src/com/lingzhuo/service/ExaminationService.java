/**
 * 
 */
package com.lingzhuo.service;

import java.util.List;

import com.lingzhuo.entity.ExaminationEntity;
import com.lingzhuo.entity.ExamineeEntity;
import com.lingzhuo.framework.service.BaseService;
import com.lingzhuo.vo.PageVo;

/**
 * @ClassName: ExaminationService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月30日 下午5:12:54
 *
 */
public interface ExaminationService extends BaseService<ExaminationEntity>{
	public ExaminationEntity selectEntityByUser(String username,String pwd)throws Exception;
	public int selectEntityTotal(ExamineeEntity entity)throws Exception;
	public List<ExamineeEntity> selectEntityPageTotal(PageVo p,ExamineeEntity entity)throws Exception;
	public int deleteEntityById(Integer exaId)throws Exception;
	public ExamineeEntity selectEntityById(String key)throws Exception;
	public int updateExaminee(String exid, String state, String userId,String examineMsg) throws Exception;
	/**
	 * @param exaId
	 * @return
	 */
	
	


}
