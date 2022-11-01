package in.co.sunrays.exception;
/**
 * DatabaseException is propogated by DAO classes when an unhandled Database
 * exception occurred
 * 
 * @author Ritesh Patidar
 */
public class RecordNotFoundException extends Exception {

	public RecordNotFoundException(String msg) {

		super(msg);
	}

}
