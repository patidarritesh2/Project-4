package in.co.sunrays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.sunrays.bean.CollegeBean;
import in.co.sunrays.bean.StudentBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.exception.DatabaseException;
import in.co.sunrays.exception.DuplicateRecordException;
import in.co.sunrays.util.JDBCDataSource;

/**
 * JDBC Implementation of StudentModel
 * 
 * @author Ritesh Patidar
 */
public class StudentModel {

	// Find next PK
	
	/**
	 * create non business primary key
	 * @return
	 * @throws DatabaseException
	 */
	public Integer nextPK() throws DatabaseException {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM ST_STUDENT");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			
			throw new DatabaseException("Exception : Exception in getting PK");		
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk +1;
	}
	
	// Add a Student.
	
	/**
	 * add record in database
	 * @param bean
	 * @return
	 * @throws ApplicationException
	 */
	public long add(StudentBean bean) throws ApplicationException {
		Connection conn = null;
		
		CollegeModel cModel = new CollegeModel();
		CollegeBean collegeBean = cModel.findByPK(bean.getCollegeId());
		bean.setCollegeName(collegeBean.getName());
		
		StudentBean duplicateName = findByEmailId(bean.getEmail());
		int pk =0;
		/*
		 * if (duplicateName != null) { throw new
		 * DuplicateRecordException("Email already exists"); }
		 */
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			conn.setAutoCommit(false); // begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ST_STUDENT VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setLong(2, bean.getCollegeId());
			pstmt.setString(3, bean.getCollegeName());
			pstmt.setString(4, bean.getFirstName());
			pstmt.setString(5, bean.getLastName());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setLong(7, bean.getMobileNo());
			pstmt.setString(8, bean.getEmail());
			pstmt.setString(9, bean.getCreatedBy());
			pstmt.setString(10, bean.getModifiedBy());
			pstmt.setTimestamp(11, bean.getCreatedDatetime());
			pstmt.setTimestamp(12, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit();   // end transaction
			pstmt.close();
		
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add Student");
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}
	
	// Delete a Student
	
	/**
	 * delete record from database
	 * @param bean
	 * @throws ApplicationException
	 */
	public void delete(StudentBean bean) throws ApplicationException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ST_STUDENT WHERE ID=?");
			pstmt.setLong(1, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in delete Student");
		}finally {
			JDBCDataSource.closeConnection(conn);
		}	
	}
	
	// Find a Student by Email id..
	
	
	/**
	 * find record from database with emailid
	 * @param Email
	 * @return
	 * @throws ApplicationException
	 */
	public StudentBean findByEmailId(String Email) throws ApplicationException {
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_STUDENT WHERE EMAIL=?");
		StudentBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, Email);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				bean = new StudentBean();
				bean.setId(rs.getLong(1));
				bean.setCollegeId(rs.getLong(2));
				bean.setCollegeName(rs.getString(3));
				bean.setFirstName(rs.getString(4));
				bean.setLastName(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setMobileNo(rs.getLong(7));
				bean.setEmail(rs.getString(8));
				bean.setCreatedBy(rs.getString(9));
				bean.setModifiedBy(rs.getString(10));
				bean.setCreatedDatetime(rs.getTimestamp(11));
				bean.setModifiedDatetime(rs.getTimestamp(12));

			}
			rs.close();
		} catch (Exception e) {
			
			throw new ApplicationException("Exception : Exception in getting User by Email");
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}
	
	// Find a Student by PK
	
	/**
	 * find record from database with primary key
	 * @param pk
	 * @return
	 * @throws ApplicationException
	 */
	public StudentBean findByPK(long pk) throws ApplicationException {
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_STUDENT WHERE ID=?");
		StudentBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				bean = new StudentBean();
				bean.setId(rs.getLong(1));
				bean.setCollegeId(rs.getLong(2));
				bean.setCollegeName(rs.getString(3));
				bean.setFirstName(rs.getString(4));
				bean.setLastName(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setMobileNo(rs.getLong(7));
				bean.setEmail(rs.getString(8));
				bean.setCreatedBy(rs.getString(9));
				bean.setModifiedBy(rs.getString(10));
				bean.setCreatedDatetime(rs.getTimestamp(11));
				bean.setModifiedDatetime(rs.getTimestamp(12));
			}
			rs.close();
		} catch (Exception e) {
			
			throw new ApplicationException("Exception : Exception in getting User by pk");
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}
	
	// Update a Student..
	
	/**
	 * update record in database
	 * @param bean
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public void update(StudentBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		CollegeModel cModel = new CollegeModel();
		CollegeBean collegeBean = cModel.findByPK(bean.getCollegeId());
		bean.setCollegeName(collegeBean.getName());
		StudentBean beanExist = findByEmailId(bean.getEmail());
		if(beanExist != null && beanExist.getId() != bean.getId()) {
			throw new DuplicateRecordException("Email Id is already exist");
		}
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE ST_STUDENT SET COLLEGE_ID=?,COLLEGE_NAME=?,FIRST_NAME=?,LAST_NAME=?,DATE_OF_BIRTH=?,MOBILE_NO=?,EMAIL=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");
			pstmt.setLong(1, bean.getCollegeId());
			pstmt.setString(2, bean.getCollegeName());
			pstmt.setString(3, bean.getFirstName());
			pstmt.setString(4, bean.getLastName());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setLong(6, bean.getMobileNo());
			pstmt.setString(7, bean.getEmail());
			pstmt.setString(8, bean.getCreatedBy());
			pstmt.setString(9, bean.getModifiedBy());
			pstmt.setTimestamp(10, bean.getCreatedDatetime());
			pstmt.setTimestamp(11, bean.getModifiedDatetime());
			pstmt.setLong(12, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());	
			}
			throw new ApplicationException("Exception in updating Student ");
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
	}
	
	// Search of Student......
	
	public List search(StudentBean bean) throws ApplicationException {
		return search(bean, 0, 0);
	}

	// Search a Student with Pagination.............
	
	/**
	 * get record from database
	 * @param bean
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws ApplicationException
	 */
	public List search(StudentBean bean, int pageNo, int pageSize) throws ApplicationException {
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_STUDENT WHERE 1=1");
		if(bean != null) {
			if(bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
		if(bean.getFirstName() != null && bean.getFirstName().length() > 0) {
			sql.append(" AND FIRST_NAME like '" + bean.getFirstName() + "%'");
		}
		if (bean.getLastName() != null && bean.getLastName().length() > 0) {
			sql.append(" AND LAST_NAME like '" + bean.getLastName() + "%'");
		}
		if (bean.getDob() != null && bean.getDob().getDate() > 0) {
			sql.append(" AND DOB = " + bean.getDob());
		}
		if (bean.getMobileNo() != 0 && bean.getMobileNo() > 0) {
			sql.append(" AND MOBILE_NO like '" + bean.getMobileNo() + "%'");
		}
		if (bean.getEmail() != null && bean.getEmail().length() > 0) {
			sql.append(" AND EMAIL like '" + bean.getEmail() + "%'");
		}
		if (bean.getCollegeName() != null && bean.getCollegeName().length() > 0) {
			sql.append(" AND COLLEGE_NAME = " + bean.getCollegeName());
		}
		}
		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;

			sql.append(" Limit " + pageNo + ", " + pageSize);
		}
		ArrayList list = new ArrayList();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet  rs = ps.executeQuery();
			while(rs.next()) {
				bean = new StudentBean();
				bean.setId(rs.getLong(1));
				bean.setCollegeId(rs.getLong(2));
				bean.setCollegeName(rs.getString(3));
				bean.setFirstName(rs.getString(4));
				bean.setLastName(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setMobileNo(rs.getLong(7));
				bean.setEmail(rs.getString(8));
				bean.setCreatedBy(rs.getString(9));
				bean.setModifiedBy(rs.getString(10));
				bean.setCreatedDatetime(rs.getTimestamp(11));
				bean.setModifiedDatetime(rs.getTimestamp(12));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			
			throw new ApplicationException("Exception : Exception in search Student");
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return list;
	}
	
	// List of Student.........
	
	public List list() throws ApplicationException {
		return list(0, 0);
	}
	
	// list of Student with pagination...
	
	/**
	 * get all record from database
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws ApplicationException
	 */
	public List list(int pageNo, int pageSize) throws ApplicationException {
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from ST_STUDENT");
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setId(rs.getLong(1));
				bean.setCollegeId(rs.getLong(2));
				bean.setCollegeName(rs.getString(3));
				bean.setFirstName(rs.getString(4));
				bean.setLastName(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setMobileNo(rs.getLong(7));
				bean.setEmail(rs.getString(8));
				bean.setCreatedBy(rs.getString(9));
				bean.setModifiedBy(rs.getString(10));
				bean.setCreatedDatetime(rs.getTimestamp(11));
				bean.setModifiedDatetime(rs.getTimestamp(12));
				list.add(bean);
			}
			rs.close();
			
		} catch (Exception e) {
			throw new ApplicationException("Exception : Exception in getting list of Student");
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return list;
	}

}
