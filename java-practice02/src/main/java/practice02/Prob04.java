package practice02;

public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		int input = str.length();
		char[] result = new char[input];
		
		for(int i = input - 1; i >= 0; i--)
		{
			result[i] = str.charAt(i);
		}
		return result;
	}

	public static void printCharArray(char[] array){
		for(int i = 0; i< array.length; i++)
		{
			System.out.print(array[i]);
		}
		System.out.println();
	}
}
