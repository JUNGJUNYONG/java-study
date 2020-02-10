package prob4;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		String str = "";
		
		for(int i = 0; i < strArr.length; i++)
		{
			str += strArr[i];
		}
		return str;
	}
}
