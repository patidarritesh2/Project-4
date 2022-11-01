package in.co.sunrays.util;

import java.util.ResourceBundle;

/**
 * Read the property value from application
 *
 */
public class PropertyReader {
	private static ResourceBundle rb = ResourceBundle.getBundle("co.in.sunrays.bundle.system");

	public static String getValue(String key) {
		String val = null;

		try {
			val = rb.getString(key);
		} catch (Exception e) {
			val = key;
		}

		return val;

	}
	public static String getValue(String key, String param) {
		String msg = getValue(key);
		msg = msg.replace("{0}", param);
		return msg;
	}
	public static String getValue(String key, String[] params) {
		String msg = getValue(key);
		for (int i = 0; i < params.length; i++) {
			msg = msg.replace("{" + i + "}", params[i]);
		}
		return msg;
	}
	public static void main(String[] args) {
		String[] params = { "Roll No" };
		System.out.println(PropertyReader.getValue("error.require", params));
	}

}
