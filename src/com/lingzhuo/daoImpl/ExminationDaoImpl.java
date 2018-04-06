/**
 * 
 */
package com.lingzhuo.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;









import com.lingzhuo.common.datasouce.DBConnection;
import com.lingzhuo.common.utils.DateFormatSupport;
import com.lingzhuo.dao.ExaminationDao;
import com.lingzhuo.entity.ExaminationEntity;
import com.lingzhuo.entity.ExamineeEntity;
import com.lingzhuo.vo.PageVo;

/**
 * @ClassName: ExminationDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月30日 下午5:07:02
 *
 */
public class ExminationDaoImpl implements ExaminationDao{
     private PreparedStatement  pst;
     private Connection conn;
     private ResultSet res;
	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#saveEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int saveEntity(ExaminationEntity entity) throws Exception {
		// TODO Auto-generated method stub
		String sql=" insert into  ExaminationTable(examinationId,username,pwd,rname,sex,cardno,"
				+ "createDate,createTime,createuser)  values(?,?,?,?,?,?,?,?,?)";
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#updateEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int updateEntity(ExaminationEntity entity) throws Exception {
		// TODO Auto-generated method stub
		String sql="update ExaminationTable set examinationId=?,username=?,pwd=?,rname=?,sex=?,cardno=?,"
				+ "createDate=?,createTime=?,createuser=? where examinationId=?";
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#deleteEntity(com.lingzhuo.framework.entity.BaseEntity)
	 */
	@Override
	public int deleteEntity(ExaminationEntity entity) throws Exception {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#selectAll(java.lang.String)
	 */
	@Override
	public List<ExaminationEntity> selectAll(String wheresql) throws Exception {
		// TODO Auto-generated method stub
		String sql ="select examinationId,username,pwd,rname,sex,cardno,"
				+ "createDate,createTime,createuser from ExaminationTable";
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.framework.dao.BaseDao#selectByKey(java.lang.String)
	 */
	@Override
	public ExaminationEntity selectByKey(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql ="select examinationId,username,pwd,rname,sex,cardno,"
				+ "createDate,createTime,createuser from ExaminationTable where examinationId=?";
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.dao.ExaminationDao#selectEntityByUser(java.lang.String, java.lang.String)
	 */
	@Override
	public ExaminationEntity selectEntityByUser(String username, String pwd)
			throws Exception {
		// TODO Auto-generated method stub
		
		String sql ="select examinationId,username,pwd,rname,sex,cardno, "
				+ " createDate,createTime,createuser from ExaminationTable where username=? and pwd=? ";
		DBConnection db=new DBConnection();
		conn=db.getConn();
		pst=conn.prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, pwd);
		res=pst.executeQuery();
		ExaminationEntity e=null;
		while(res.next()){
			e=new ExaminationEntity();
			e.setExaminationId(res.getInt(1));
			e.setUsername(res.getString(2));
			e.setPwd(res.getString(3));
			e.setRname(res.getString(4));
			e.setSex(res.getString(5));
			e.setCardno(res.getString(6));
			e.setCreateDate(res.getString(7));
			e.setCreateTime(res.getString(8));
			e.setCreateuser(res.getString(9));
		}
		pst.close();
		conn.close();
		return e;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.dao.ExaminationDao#selectEntityTotal(com.lingzhuo.entity.ExaminationEntity)
	 */
	@Override
	public int selectEntityTotal(ExamineeEntity entity) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql= new StringBuffer("select count(*) from ");
		sql.append("ExamineeTable a where 1=1  ");
		if(entity!=null){
			if(entity.getRname()!=null&&!entity.getRname().trim().equals("")){
				sql.append(" and  a.rname like '%"+entity.getRname()+"%'");
			}
			if(entity.getCardno()!=null&&!entity.getCardno().trim().equals("")){
				sql.append(" and a.cardno ='"+entity.getCardno()+"'");
			}
			if(entity.getExaLeve()!=null&&!entity.getExaLeve().trim().equals("")){
				sql.append(" and a.exa_leve='"+entity.getExaLeve()+"'");
			}
			if(entity.getExaminestate()!=null&&!entity.getExaminestate().trim().equals("")){
				sql.append(" and nvl(a.examinestate,'N')='"+entity.getExaminestate()+"'");
			}
		 
		}
	  
		DBConnection db=new DBConnection();
		conn=db.getConn();
		pst=conn.prepareStatement(sql.toString());
		res=pst.executeQuery();
		
		int total=0;
		while(res.next()){
			 total=res.getInt(1);
		}
	   pst.close();
	   conn.close();
	   return total;
	}
		
	
	/* (non-Javadoc)
	 * @see com.lingzhuo.dao.ExaminationDao#selectEntityPageTotal(com.lingzhuo.vo.PageVo, com.lingzhuo.entity.ExaminationEntity)
	 */

		// TODO Auto-generated method stub
		

	/* (non-Javadoc)
	 * @see com.lingzhuo.dao.ExaminationDao#selectEntityPageTotal(com.lingzhuo.vo.PageVo, com.lingzhuo.entity.ExamineeEntity)
	 */
	@Override
	public List<ExamineeEntity> selectEntityPageTotal(PageVo p,ExamineeEntity entity)
			throws Exception {
		// TODO Auto-generated method stub
		List<ExamineeEntity> list=new ArrayList<ExamineeEntity>();
		StringBuffer sql=new StringBuffer("select a.Exa_id, a.username, a.pwd , a.rname ,a.cardno ,a.exa_leve ,a.birthday,a.sex ,a.phone ,"
				+ "a.email ,a.Province ,a.exa_date,  a.exa_time , a.photo,a.photoURL,a.examinestate , a.UnauditedReason,a.examineuser,"
				+ "a.examinedatetime  from(select rownum r,Exa_id, username, pwd , rname ,cardno ,exa_leve ,birthday,sex ,phone ,"
				+ "email ,Province ,exa_date,  exa_time , photo,photoURL,examinestate , UnauditedReason,examineuser,"
				+ "examinedatetime from ExamineeTable where 1=1 ");
		if(entity!=null){
			if(entity.getRname()!=null&&!entity.getRname().trim().equals("")){
				sql.append(" and  rname like '%"+entity.getRname()+"%'");
			}
			if(entity.getCardno()!=null&&!entity.getCardno().trim().equals("")){
				sql.append(" and cardno ='"+entity.getCardno()+"'");
			}
			if(entity.getExaLeve()!=null&&!entity.getExaLeve().trim().equals("")){
				sql.append(" and exa_leve='"+entity.getExaLeve()+"'");
			}
			if(entity.getExaminestate()!=null&&!entity.getExaminestate().trim().equals("")){
				sql.append(" and nvl(examinestate,'N')='"+entity.getExaminestate()+"'");
			}
		}
		
		sql.append(" )a where a.r between  ");
		sql.append( p.getOffset()+" and "+(p.getOffset()+p.getPageSize()-1));
		System.out.println("---sql---:"+sql);
		DBConnection db=new DBConnection();
		conn=db.getConn();
		pst=conn.prepareStatement(sql.toString());
		res=pst.executeQuery();
		while(res.next()){
		ExamineeEntity	e=new ExamineeEntity();
			e.setExaId(res.getInt(1));
			e.setUsername(res.getString(2));
			e.setPwd(res.getString(3));
			e.setRname(res.getString(4));
			e.setCardno(res.getString(5));
		    e.setExaLeve(res.getString(6));
			e.setBirthday(DateFormatSupport.format1(res.getString(7)));
			e.setSex(res.getString(8));
			e.setPhone(res.getString(9));
			e.setEmail(res.getString(10));
			e.setProvince(res.getString(11));
			e.setExaDate(DateFormatSupport.format1(res.getString(12)));
			e.setExaTime(DateFormatSupport.format2(res.getString(13)));
			e.setPhoto(res.getString(14));
			e.setPhotoURL(res.getString(15));
		    e.setExaminestate(res.getString(16));
			e.setUnauditedReason(res.getString(17));
			e.setExamineUser(res.getInt(18));
			e.setExamineDatetime(DateFormatSupport.format3(res.getString(19)));
            list.add(e);
			
		}
		pst.close();
		conn.close();
		return list;	
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.dao.ExaminationDao#deleteEntityById(java.lang.Integer)
	 */
	@Override
	public int deleteEntityById(Integer exaId) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from  ExamineeTable  where Exa_id=?";
		System.out.println("----delete----"+sql);
		DBConnection db=new DBConnection();
		conn=db.getConn();
		pst=conn.prepareStatement(sql);
		pst.setInt(1,exaId);
		int i=pst.executeUpdate();
		pst.close();
		conn.close();
		return i;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.dao.ExaminationDao#selectEntityById(java.lang.String)
	 */
	@Override
	public ExamineeEntity selectEntityById(String key) throws Exception {
		// TODO Auto-generated method stub
		
		String sql="select Exa_id, username, pwd , rname ,cardno ,exa_leve ,birthday,sex ,phone ,email ,Province , "
				+ " exa_date,  exa_time , photo,photoURL,examinestate , UnauditedReason,examineuser,examinedatetime  "
				+ " from ExamineeTable where Exa_id=? ";
		DBConnection db=new DBConnection();
		conn=db.getConn();
		pst=conn.prepareStatement(sql);
		pst.setString(1, key);
		System.out.println("-----selectbyid-----"+sql);
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
	 * @see com.lingzhuo.dao.ExaminationDao#updateExaminee(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int updateExaminee(String exid, String state, String userId,
			String examineMsg) throws Exception {
		// TODO Auto-generated method stub
		String sql="update examineeTable set examinestate=?,UnauditedReason=?,examineuser=?  where Exa_id=? ";
		DBConnection db=new DBConnection();
		conn=db.getConn();
		pst=conn.prepareStatement(sql);
		pst.setString(4,exid);
		pst.setString(1, state);
		pst.setString(3,userId);
		pst.setString(2,examineMsg);
		int i=pst.executeUpdate();
		pst.close();
		conn.close();
		return i;
	}

	/* (non-Javadoc)
	 * @see com.lingzhuo.dao.ExaminationDao#deleteEntityById(java.lang.Integer)
	 */
	

}
