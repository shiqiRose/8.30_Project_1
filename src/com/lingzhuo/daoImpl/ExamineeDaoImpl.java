/**
 * 
 */
package com.lingzhuo.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.lingzhuo.common.datasouce.DBConnection;
import com.lingzhuo.dao.ExamineeDao;
import com.lingzhuo.entity.ExaminationEntity;
import com.lingzhuo.entity.ExamineeEntity;
import com.lingzhuo.vo.PageVo;

/**
 * @ClassName: ExamineeDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月30日 下午5:08:34
 *
 */
public class ExamineeDaoImpl implements ExamineeDao{
    private PreparedStatement pst;
    private Connection conn;
    private ResultSet res;
    
	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#saveEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int saveEntity(ExamineeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into  ExamineeTable(Exa_id, username, pwd , rname ,cardno ,exa_leve ,birthday,sex ,"
				+ "phone ,email ,Province ,exa_date, exa_time , photo,photoURL,examinestate) "
				+ " values(EXAMINEETABLE_SEQ.nextVal,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		 DBConnection db=new DBConnection();
		 conn=db.getConn();
		 pst=conn.prepareStatement(sql);
		
		 pst.setString(1, entity.getUsername());
		 pst.setString(2, entity.getPwd());
		 pst.setString(3, entity.getRname());
		 pst.setString(4, entity.getCardno());
		 pst.setString(5, entity.getExaLeve());
		 pst.setString(6, entity.getBirthday());
		 pst.setString(7, entity.getSex());
		 pst.setString(8, entity.getPhone());
		 pst.setString(9, entity.getEmail());
		 pst.setString(10, entity.getProvince());
		 pst.setString(11, entity.getExaDate());
		 pst.setString(12, entity.getExaTime());
		 pst.setString(13, entity.getPhoto());
		 pst.setString(14, entity.getPhotoURL());
		 pst.setString(15, entity.getExaminestate());
		
		int i=pst.executeUpdate();
		pst.close();
		conn.close();
		return i;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#updateEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int updateEntity(ExamineeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		String sql="update ExamineeTable set Exa_id=?, username=?, pwd=? , rname =?,cardno=? ,exa_leve =?,birthday=?,"
				+ "sex=? ,phone =?,email =?,Province =?,exa_date=?, exa_time =?, photo=?,photoURL=?,examinestate=? ,"
				+ " UnauditedReason=?,examineuser=?,examinedatetime =? where Exa_id=?";
		/*insert into  ExamineeTable(Exa_id, username, pwd , rname ,cardno ,exa_leve ,birthday,sex ,
				phone ,email ,Province ,exa_date,  exa_time , photo,photoURL,examinestate , UnauditedReason,
				examineuser,examinedatetime) values('5','lisi1','admin','李四1','123321','1','19990608',
				'1','1213','2313@12132.com','陕西','19800201','12:09','1','D:/','n','您太优秀',10,'19800219'); */
		return 0;
		
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#deleteEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int deleteEntity(ExamineeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from ExaminneeTable where Exa_id=?";
		return 0;
		
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#selectAll(java.lang.String)
	 */
	@Override
	public List<ExamineeEntity> selectAll(String wheresql) throws Exception {
		// TODO Auto-generated method stub
		String sql="select Exa_id, username, pwd , rname ,cardno ,exa_leve ,birthday,sex ,phone ,email ,Province ,"
				+ "exa_date,  exa_time , photo,photoURL,examinestate , UnauditedReason,examineuser,examinedatetime "
				+ "from ExamineeTable ";
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#selectByKey(java.lang.String)
	 */
	@Override
	public ExamineeEntity selectByKey(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select Exa_id, username, pwd , rname ,cardno ,exa_leve ,birthday,sex ,phone ,email ,Province ,"
				+ "exa_date,  exa_time , photo,photoURL,examinestate , UnauditedReason,examineuser,examinedatetime "
				+ "from ExamineeTable where Exa_id=?";
		return null;
		
	
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.dao.ExamineeDao#selectByUser(java.lang.String, java.lang.String)
	 */
	@Override
	public ExamineeEntity selectEntityByUser(String username, String pwd)
			throws Exception {
		// TODO Auto-generated method stub
		
		String sql="select Exa_id, username, pwd , rname ,cardno ,exa_leve ,birthday,sex ,phone ,email ,Province , "
				+ " exa_date,  exa_time , photo,photoURL,examinestate , UnauditedReason,examineuser,examinedatetime  "
				+ " from ExamineeTable where username=? and pwd=? ";
		DBConnection db=new DBConnection();
		conn=db.getConn();
		pst=conn.prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2,pwd);
		ExamineeEntity e=null;
		res=pst.executeQuery();
		while(res.next()){
			e=new ExamineeEntity();
			e.setExaId(res.getInt(1));
			e.setUsername(res.getString(2));
			e.setPwd(res.getString(3));
			e.setRname(res.getString(4));
			e.setCardno(res.getString(5));
		    e.setExaLeve(res.getString(6));
			e.setBirthday(res.getString(7));
			e.setSex(res.getString(8));
			e.setPhone(res.getString(9));
			e.setEmail(res.getString(10));
			e.setProvince(res.getString(11));
			e.setExaDate(res.getString(12));
			e.setExaTime(res.getString(13));
			e.setPhoto(res.getString(14));
			e.setPhotoURL(res.getString(15));
		    e.setExaminestate(res.getString(16));
			e.setUnauditedReason(res.getString(17));
			e.setExamineUser(res.getInt(18));
			e.setExamineDatetime(res.getString(19));
			
		}
		pst.close();
		conn.close();
		return e;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#selectEntityPageTotal(com.lingzhuo.vo.PageVo, com.lingzhuo.entity.ExamineeEntity)
	 */
	
}
