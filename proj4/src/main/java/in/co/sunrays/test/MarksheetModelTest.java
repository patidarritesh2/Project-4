package in.co.sunrays.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.bean.MarksheetBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.exception.DuplicateRecordException;
import in.co.sunrays.model.MarksheetModel;


public class MarksheetModelTest {
	public static void main(String[] args) {
		testAdd();
		// testDelete();
		// testUpdate();
		// testFindByRollNo();
	//	testFindByPK();
		//testsearch();
		//testMeritList();
		 // testList();
		
	}
	
	public static void testAdd() {

		try {
			MarksheetBean bean = new MarksheetBean();
			MarksheetModel model = new MarksheetModel();
			bean.setId(1);
			bean.setRollNo("100");
			bean.setPhysics(89);
			bean.setChemistry(79);
			bean.setMaths(89);
			bean.setStudentId(1l);
			long pk = model.add(bean);
			MarksheetBean addedbean = model.findByPK(pk);
			if (addedbean == null) {
				System.out.println("Test add fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

	}

	private static void testDelete() {
		try {
			MarksheetBean bean = new MarksheetBean();
			MarksheetModel model = new MarksheetModel();
			long pk = 9L;
			bean.setId(1);
			model.delete(bean);
			MarksheetBean deletedbean = model.findByPK(pk);
			if (deletedbean != null) {
				System.out.println("Test Delete fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	private static void testUpdate() {
		try {
			MarksheetModel model = new MarksheetModel();
			MarksheetBean bean = model.findByPK(2);
			// bean.setName("IPS");
			bean.setChemistry(65);
			bean.setMaths(66);
			// bean.setStudentId(2);
			model.update(bean);

			MarksheetBean updatedbean = model.findByPK(3L);
			System.out.println("Test Update succ");
			if (!"IIM".equals(updatedbean.getName())) {
				System.out.println("Test Update fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

	}

	private static void testFindByRollNo() {
		try {
			MarksheetModel model = new MarksheetModel();
			MarksheetBean bean = model.findByRollNo("45");
			if (bean == null) {
				System.out.println("Test Find By RollNo fail");
			}

			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getName());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	private static void testFindByPK() {
		 try {
	            MarksheetBean bean = new MarksheetBean();
	            MarksheetModel model= new MarksheetModel();
	            long pk = 2L;
	            bean = model.findByPK(1);
	            if (bean == null) {
	                System.out.println("Test Find By PK fail");
	            }
	            System.out.println(bean.getId());
	            System.out.println(bean.getRollNo());
	            System.out.println(bean.getName());
	            System.out.println(bean.getPhysics());
	            System.out.println(bean.getChemistry());
	            System.out.println(bean.getMaths());
	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }
	}

	private static void testsearch() {
	 
	        try {
	        	MarksheetModel model= new MarksheetModel();
	            MarksheetBean bean = new MarksheetBean();
	            List list = new ArrayList();
	            bean.setName("jsp");
	            list = model.search(bean, 1, 10);
	            if (list.size() < 0) {
	                System.out.println("Test Search fail");
	            }
	            Iterator it = list.iterator();
	            while (it.hasNext()) {
	                bean = (MarksheetBean) it.next();
	                System.out.println(bean.getId());
	                System.out.println(bean.getRollNo());
	                System.out.println(bean.getName());
	                System.out.println(bean.getPhysics());
	                System.out.println(bean.getChemistry());
	                System.out.println(bean.getMaths());
	            }
	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }
	}
	
	   public static void testMeritList() {
	        try {
	            MarksheetBean bean = new MarksheetBean();
	            MarksheetModel model= new MarksheetModel();
	            List list = new ArrayList();
	            list = model.getMeritList(1, 5);
	            if (list.size() < 0) {
	                System.out.println("Test List fail");
	            }
	            Iterator it = list.iterator();
	            while (it.hasNext()) {
	                bean = (MarksheetBean) it.next();
	                System.out.println(bean.getId());
	                System.out.println(bean.getRollNo());
	                System.out.println(bean.getName());
	                System.out.println(bean.getPhysics());
	                System.out.println(bean.getChemistry());
	                System.out.println(bean.getMaths());
	            }
	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }

	    }
		private static void testList() {
			 try {
		            MarksheetBean bean = new MarksheetBean();
		            MarksheetModel model= new MarksheetModel();
		            List list = new ArrayList();
		            list = model.list(1, 6);
		            if (list.size() < 0) {
		                System.out.println("Test List fail");
		            }
		            Iterator it = list.iterator();
		            while (it.hasNext()) {
		                bean = (MarksheetBean) it.next();
		                System.out.println(bean.getId());
		                System.out.println(bean.getRollNo());
		                System.out.println(bean.getName());
		                System.out.println(bean.getPhysics());
		                System.out.println(bean.getChemistry());
		                System.out.println(bean.getMaths());
		                System.out.println(bean.getCreatedBy());
		                System.out.println(bean.getCreatedDatetime());
		                System.out.println(bean.getModifiedBy());
		                System.out.println(bean.getModifiedDatetime());
		            }
		        } catch (ApplicationException e) {
		            e.printStackTrace();
		        }
			
		}
	}
