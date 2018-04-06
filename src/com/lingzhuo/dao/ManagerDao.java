/**
 * 
 */
package com.lingzhuo.dao;

import com.lingzhuo.entity.ManagerEntity;
import com.lingzhuo.framework.dao.BaseDao;

/**
 * @ClassName: ManagerEntity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月30日 下午5:04:18
 *
 */
public interface ManagerDao extends BaseDao<ManagerEntity>{
 public ManagerEntity selectEntityByUser(String username,String pwd)throws Exception;
}
