package ptit.insurance.utility;

public class Util {
	public static String nvl(String target, String replace) {
		if (target == null)
			return replace;
		else if (target.equals(""))
			return replace;
		return target;
	}
	
	public static boolean number(String number, int length) {
		try {
			long a = Long.parseLong(number);  
		} catch (NumberFormatException ex) {
			return false;
		}
		
		if (number.length() != length)
			return false;
		return true;
	}
}
