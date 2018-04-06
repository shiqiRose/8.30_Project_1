/**
 * 
 */
package com.lingzhuo.dao;

import com.lingzhuo.entity.ExamineeEntity;
import com.lingzhuo.framework.dao.BaseDao;

/**
 * @ClassName: ExamineeDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月30日 下午5:03:04
 *
 */
public interface ExamineeDao extends BaseDao<ExamineeEntity>{
  public ExamineeEntity selectEntityByUser(String username,String pwd)throws Exception;
 
}
