package in.co.sunrays.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.bean.SubjectBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.exception.DuplicateRecordException;
import in.co.sunrays.model.SubjectModel;

public class SubjectModelTest {
public static void main(String[] args) throws Exception {
	//testAdd();
	//testdelete();
	//testupdate();
	testsearch();
	//testList();
}

private static void testList() {
	try {
		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();
		List list = new ArrayList();
		list = model.list(1, 6);
		if(list.size() < 0) {
			System.out.println("Test List fail");
		}
		Iterator it = list.iterator();
		while(it.hasNext()) {
			bean = (SubjectBean) it.next();
			 System.out.println(bean.getId());
             System.out.println(bean.getSubject_Name());
	         System.out.println(bean.getCourse_Name());
	         System.out.println(bean.getCourse_Id());
             System.out.println(bean.getCreatedBy());
             System.out.println(bean.getCreatedDatetime());
             System.out.println(bean.getModifiedBy());
             System.out.println(bean.getModifiedDatetime());
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

private static void testsearch() {
	try {
		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();
		List list = new ArrayList();
		list = model.search(bean);
		if(list.size() < 0) {
			System.out.println("Test List fail");
		}
		Iterator it = list.iterator();
		while(it.hasNext()) {
			bean = (SubjectBean) it.next();
			 System.out.println(bean.getId());
             System.out.println(bean.getSubject_Name());
	         System.out.println(bean.getCourse_Name());
	         System.out.println(bean.getCourse_Id());
             System.out.println(bean.getCreatedBy());
             System.out.println(bean.getCreatedDatetime());
             System.out.println(bean.getModifiedBy());
             System.out.println(bean.getModifiedDatetime());
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

private static void testupdate() {
try {
	SubjectModel model = new SubjectModel();
	SubjectBean bean = model.findByPK(1);
	bean.setSubject_Name("chesdmi");
	bean.setCourse_Name("bsc");
	bean.setCourse_Id(301);
	bean.setDescription("fhekf");
	bean.setCreatedBy("admin");
	bean.setModifiedBy("admin");
	bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	model.update(bean);
	SubjectBean addedBean = model.findByPK(1);
	if(addedBean == null) {
		System.out.println("Test add fail");
	}
} catch (Exception e) {
	e.printStackTrace();
}	
}

private static void testdelete() {
try {
	SubjectBean bean = new SubjectBean();
	SubjectModel model = new SubjectModel();
	bean.setId(2L);
	model.delete(bean);
	SubjectBean  addedBean = model.findByPK(2L);
	if(addedBean == null) {
		System.out.println("Test add fail");
	}
	
} catch (ApplicationException e) {
	e.printStackTrace();
}	
}

private static void testAdd() throws Exception {
try {
	SubjectBean bean = new SubjectBean();
	SubjectModel model = new SubjectModel();
	
	bean.setSubject_Name("English");
	bean.setCourse_Name("BA");
	bean.setCourse_Id(2);
	bean.setDescription("Advance");
	bean.setCreatedBy("admin");
	bean.setModifiedBy("admin");
	bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	long pk = model.add(bean);
	SubjectBean addedBean = model.findByPK(pk);
	if (addedBean == null) {
		System.out.println("Test add fail");
	}
} catch (ApplicationException e) {
	e.printStackTrace();
}	
}
}
