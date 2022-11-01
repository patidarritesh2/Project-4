package in.co.sunrays.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.bean.StudentBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.exception.DuplicateRecordException;
import in.co.sunrays.model.StudentModel;

public class StudentModelTest {
public static void main(String[] args) throws Exception {
	testAdd();
	//testDelete();
	//testUpdate();
	//testFindByPK();
	//testFindByEmailId();
	//testSearch();
	//testList();
}

private static void testList() {
try {
	StudentModel model = new StudentModel();
	StudentBean bean = new StudentBean();
	List list = new ArrayList();
	list = model.list(1, 10);
    if (list.size() < 0) {
        System.out.println("Test list fail");
    }
    Iterator it = list.iterator();
    while(it.hasNext()) {
    	bean = (StudentBean) it.next();
    	System.out.println(bean.getId());
    	System.out.println(bean.getFirstName());
    	System.out.println(bean.getLastName());
    	System.out.println(bean.getDob());
    	System.out.println(bean.getMobileNo());
    	System.out.println(bean.getEmail());
    	System.out.println(bean.getCollegeId());
    	System.out.println(bean.getCreatedBy());
    	System.out.println(bean.getCreatedDatetime());
    	System.out.println(bean.getModifiedBy());
    	System.out.println(bean.getModifiedDatetime());
    }
} catch (ApplicationException e) {
	e.printStackTrace();
}	
}

private static void testUpdate() throws Exception {
	try {
		StudentModel model = new StudentModel();
		StudentBean bean = model.findByPK(1L);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		bean.setCollegeId(2021L);
		bean.setCollegeName("SIT indore");
		bean.setFirstName("vivek");
		bean.setLastName("joshi");
		bean.setDob(sdf.parse("01/06/1992"));
		bean.setMobileNo(772409);
		bean.setEmail("Asddss@FGSDF.VOM");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(bean);
		
		StudentBean updatedbean = model.findByPK(1L);
		if (!"rr".equals(updatedbean.getFirstName())) {
			System.out.println("Test Update success");
		}
		
	} catch (ApplicationException e) {
		e.printStackTrace();
	} catch (DuplicateRecordException e) {
		e.printStackTrace();
	}
}

private static void testSearch() {
try {
	StudentModel model = new StudentModel();
	StudentBean bean = new StudentBean();
	List list = new ArrayList();
	bean.setFirstName("sita");
	list = model.search(bean, 0, 0);
	if(list.size() < 0) {
		System.out.println("Test Serach fail");
	}
	Iterator it = list.iterator();
	while(it.hasNext()) {
		bean = (StudentBean) it.next();
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getDob());
		System.out.println(bean.getMobileNo());
		System.out.println(bean.getEmail());
		System.out.println(bean.getCollegeId());
	}
	
} catch (ApplicationException e) {
	e.printStackTrace();
}	
}

private static void testFindByEmailId() {
	try {
		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();
		bean = model.findByEmailId("kjghjghjg@FGSDF.VOM");
		if(bean != null) {
			System.out.println("Test Find By EmailId fail");
		}
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getDob());
		System.out.println(bean.getMobileNo());
		System.out.println(bean.getEmail());
		System.out.println(bean.getCollegeId());
	} catch(ApplicationException e) {
		e.printStackTrace();
	}
	
}

private static void testFindByPK() {
try {
	StudentModel model = new StudentModel();
	StudentBean bean = new StudentBean();
	long pk = 1L;
	bean = model.findByPK(pk);
	if(bean == null) {
		System.out.println("Test Find By PK fail");
	}
	System.out.println(bean.getId());
	System.out.println(bean.getFirstName());
	System.out.println(bean.getLastName());
	System.out.println(bean.getDob());
	System.out.println(bean.getMobileNo());
	System.out.println(bean.getEmail());
	System.out.println(bean.getCollegeId());
} catch (ApplicationException e) {
	e.printStackTrace();
}	
}

private static void testDelete() {
	try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		long pk = 10L;
		bean.setId(3);
		model.delete(bean);
		StudentBean deletebean = model.findByPK(pk);
		if(deletebean != null) {
			System.out.println("Test Delete fail");
		}
	} catch (ApplicationException e) {
		e.printStackTrace();
	}
	
}

private static void testAdd() throws Exception {
	try {
		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		bean.setId(6);
		bean.setCollegeName("SIT Indore");
		bean.setFirstName("Ranvir");
		bean.setLastName("Kapoor");
		bean.setDob(sdf.parse("1/11/1992"));
		bean.setMobileNo(971567825);
		bean.setEmail("ranvirk@gmail.com");
		bean.setCollegeId(1L);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		long pk = model.add(bean);
		StudentBean addedbean = model.findByPK(pk);
		if(addedbean == null) {
			System.out.println("Test add fail");
		}
	} catch (ApplicationException e) {
		e.printStackTrace();
	}
	//catch (DuplicateRecordException e) {
		//e.printStackTrace();
	//}
	
}
}
