package chapter03;

public class ArrayUtils {
	public static double[] intToDouble(int[] src) {
		double[] result = null;
		
		if(src == null) {
			return result;
		}
		
		int size = src.length;
		result = new double[size];
		
		for(int i = 0; i < size; i++) {
			result[i] = src[i];
		}
		
		return result;
	}
}
