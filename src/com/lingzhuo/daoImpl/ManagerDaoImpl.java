/**
 * 
 */
package com.lingzhuo.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;



import com.lingzhuo.common.datasouce.DBConnection;
import com.lingzhuo.dao.ManagerDao;
import com.lingzhuo.entity.ManagerEntity;

/**
 * @ClassName: ManagerDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月30日 下午5:09:21
 *
 */
public class ManagerDaoImpl implements ManagerDao{
    private PreparedStatement pst;
    private Connection conn;
    private ResultSet res;
	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#saveEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int saveEntity(ManagerEntity entity) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into  ManagerTable(managerId,username,pwd) values(?,?,?)";
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#updateEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int updateEntity(ManagerEntity entity) throws Exception {
		// TODO Auto-generated method stub
		String sql= "update ManagerTable set managerId=?,usernam=?,pwd=? where managerId=?";
		 
		
		 
		
		 
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#deleteEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int deleteEntity(ManagerEntity entity) throws Exception {
		// TODO Auto-generated method stub
		String sql= "delete from ManagerTable where managerId=?";
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#selectAll(java.lang.String)
	 */
	@Override
	public List<ManagerEntity> selectAll(String wheresql) throws Exception {
		// TODO Auto-generated method stub
		String sql= "select managerId,username,pwd from ManagerTable";
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#selectByKey(java.lang.String)
	 */
	@Override
	public ManagerEntity selectByKey(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql= "select managerId,username,pwd from ManagerTable where managerId=?";
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.dao.ManagerDao#selectByUser(java.lang.String, java.lang.String)
	 */
	@Override
	public ManagerEntity selectEntityByUser(String username, String pwd)
			throws Exception {
		// TODO Auto-generated method stub
		
		String sql= "select managerId,username,pwd from ManagerTable where username=? and pwd=? ";
		DBConnection db=new DBConnection();
		conn=db.getConn();
		pst=conn.prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, pwd);
		System.out.println("------------manager---"+sql);
		res=pst.executeQuery();
		ManagerEntity e=null;
		while(res.next()){
			e= new ManagerEntity();
			e.setManagerId(res.getInt(1));
			e.setUsername(res.getString(2));
			e.setPwd(res.getString(3));
		}
		pst.close();
		conn.close();
		return e;
	}

}
