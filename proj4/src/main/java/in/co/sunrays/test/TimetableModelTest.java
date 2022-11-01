package in.co.sunrays.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.bean.TimetableBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.model.TimetableModel;

public class TimetableModelTest {
public static void main(String[] args) throws Exception {
	//testAdd();
	//testcheckbysem();
	//testlist();
	//testupdate();
	//testdelete();
	testFindbypk();
}

private static void testFindbypk() throws Exception {
	// TODO Auto-generated method stub

			TimetableBean stb = new TimetableBean();

			TimetableModel stm = new TimetableModel();

			stb = stm.findByPK(1);

			System.out.println(stb.getId());
			System.out.println(stb.getCourse_Id());
			System.out.println(stb.getCourse_Name());
			System.out.println(stb.getCreatedBy());
			System.out.println(stb.getModifiedBy());
			System.out.println(stb.getCreatedDatetime());
			System.out.println(stb.getModifiedDatetime());
	
}

private static void testdelete() {
try {
	TimetableBean bean = new TimetableBean();
	TimetableModel model = new TimetableModel();
	int pk = 2;
	bean.setId(pk);
	model.delete(bean);
	System.out.println("Test Delete succ" + bean.getId());
	TimetableBean deletedbean = model.findByPK(pk);
	if (deletedbean == null) {
		System.out.println("Test Delete fail");
	}
} catch (Exception e) {
	e.printStackTrace();
}	
}

private static void testupdate() throws Exception {
	// TODO Auto-generated method stub

			TimetableModel tm = new TimetableModel();
			TimetableBean tb = tm.findByPK(1);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dt = new Date();

			// dt = sdf.parse("03/03/2012");
			// tb.setCourse_Name("botany");
			// tb.setSubject_Id(1);
			// tb.setCourse_Id(1);
			// tb.setExam_Date(dt);
			// tb.setCreatedDatetime(new Timestamp(new Date().getTime()));
			// tb.setId(1);
			tb.setSemester("3rd");
			System.out.println("sdfasdfadsfadsfadsfadsfadsfadsf");
			tm.update(tb);	
}

private static void testlist() throws Exception {
	  TimetableBean bean = new TimetableBean();
      TimetableModel model= new TimetableModel();
      List list = new ArrayList();
      list = model.list(1, 6);
      if (list.size() < 0) {
          System.out.println("Test List fail");
      }
      Iterator it = list.iterator();
      
      while (it.hasNext()) {
      	 bean = (TimetableBean) it.next();
      System.out.println(bean.getCourse_Name());
      System.out.println(bean.getSemester());
      }		 
	
}

private static void testcheckbysem() {
	TimetableBean bean = new TimetableBean();
	TimetableModel model = new TimetableModel();
	bean.setSemester("3rd");
	System.out.println(bean.getSubject_Name());
	//model.checkBysemester(1, 1, "3rd", );
	
}

private static void testAdd() throws Exception {
	TimetableBean tb = new TimetableBean();
	TimetableModel tm = new TimetableModel();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date dt = new Date();
	tb.setCourse_Name("B.sc");
	tb.setCourse_Id(2);
	tb.setSubject_Name("maths");
	tb.setSubject_Id(2);
	tb.setSemester("3rd");
	tb.setExam_Date(sdf.parse("04/03/2012"));
	tb.setExam_Time("4:00");
	tb.setModifiedBy("faculty");
	tb.setCreatedBy("admin");
	tb.setCreatedDatetime(new Timestamp(new Date().getTime()));
	tb.setModifiedDatetime(new Timestamp(new Date().getTime()));
	tm.add(tb);
	System.out.println("dsfdas");
}
}
