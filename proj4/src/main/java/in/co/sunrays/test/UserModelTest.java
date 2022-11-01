package in.co.sunrays.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import in.co.sunrays.bean.UserBean;
import in.co.sunrays.model.UserModel;

public class UserModelTest {
public static void main(String[] args) throws Exception {
	//testAdd();
	//testDelete();
	//testUpdate();
	//testFindByPK();
	//testchangePassword();
	

}

private static void testchangePassword() throws Exception {
	UserModel model = new UserModel();

	UserBean bean = model.findByLogin("sheenu@gmail.com");
	String oldPassword = bean.getPassword();
	bean.setId(1l);
	bean.setPassword("Shinu@12#");
	bean.setConfirmPassword("Shinu@12#");
	String newPassword = bean.getPassword();
	try {
		model.changePassword(1l, oldPassword, newPassword);
		System.out.println("password has been change successfully");

	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

private static void testFindByPK() {
	try {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		long pk = 1L;
		bean = model.findByPK(pk);
		if (bean == null) {
			System.out.println("Test Find By PK fail");
		}
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLogin());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		System.out.println(bean.getRoleId());
		System.out.println(bean.getUnSuccessfulLogin());
		System.out.println(bean.getGender());
		System.out.println(bean.getLastLogin());
		System.out.println(bean.getLock());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

private static void testUpdate() {
	try {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-yyy");
		UserModel model = new UserModel();
		UserBean bean = model.findByPK(1L);

		bean.setFirstName("SheenU");
		bean.setLastName("Vyas");
		bean.setLogin("sheenu@gmail.com");
		bean.setPassword("pass8888");
		bean.setDob(sdf.parse("31-1-1992"));
		bean.setMobileNo(7768789999L);
		bean.setRoleId(1L);
		bean.setUnSuccessfulLogin(2);
		bean.setGender("Female");
		bean.setLastLogin(new Timestamp(new Date().getTime()));
		bean.setLock("Yes");
		bean.setRegisteredIP("33A");
		bean.setLastLoginIP("LastSd");
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

		UserBean updatedbean = model.findByPK(1L);
		if (!"sdfdsfd".equals(updatedbean.getLogin())) {
			System.out.println("Test Update Success");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

private static void testDelete() {
	try {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		long pk = 2L;
		bean.setId(pk);
		model.delete(bean);
		System.out.println("Test Delete succ" + bean.getId());
		UserBean deletedbean = model.findByPK(pk);
		if(deletedbean != null) {
			System.out.println("Test Delete fail");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

private static void testAdd() {
	try {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//bean.setId(5234L);
		bean.setFirstName("ranvir");
		bean.setLastName("singh");
		bean.setLogin("ranvir@gmail.com");
		bean.setPassword("pass123");
		bean.setDob(sdf.parse("1-1-1994"));
		bean.setMobileNo(7767609898L);
		bean.setRoleId(2L);
		bean.setUnSuccessfulLogin(2);
		bean.setGender("male");
		bean.setLastLogin(new Timestamp(new Date().getTime()));
		bean.setLock("yes");
		bean.setRegisteredIP("365d");
		bean.setLastLoginIP("LastinIp03");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		long pk = model.add(bean);
		UserBean addedbean = model.findByPK(pk);
		System.out.println("Test add succ");
		if(addedbean == null) {
			System.out.println("Test add fail");
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
