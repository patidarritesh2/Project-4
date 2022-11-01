package in.co.sunrays.exception;

/**
 *  ApplicationException is propogated from Service classes when an business
 * logic exception occurered.
 * 
 * @author Ritesh Patidar
 */
public class ApplicationException extends Exception {
    /**
     * 
     *            : Error message
     */
	public ApplicationException(String msg) {
		super(msg);
	}
}

