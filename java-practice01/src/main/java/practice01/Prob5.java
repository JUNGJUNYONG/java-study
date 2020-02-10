package practice01;

public class Prob5 {

	public static void main(String[] args) {
		//for( int i = 1; i <=100; i++ ) {			
		//}
		for(int n = 1; n <= 100; n++)
		{
			int tendown = n % 10;
			int tenup = n / 10;
			if(n < 10)
			{
				System.out.print(n);
				System.out.print("짝");
				System.out.println();
			}
			else
			{
				if((tenup % 3 == 0) && (n % 10 == 0))
				{
					System.out.print(n);
					System.out.print("짝");
					System.out.println();
				}
				else if((tendown % 3 == 0) && (tenup % 3 == 0))
				{
					System.out.print(n);
					System.out.print("짝짝");
					System.out.println();
				}
				else if((tendown % 3 == 0) || (tenup % 3 == 0))
				{
					if(n % 10 != 0)
					{
						System.out.print(n);
						System.out.print("짝");
						System.out.println();
					}
				}
				
			}
		}
	}
}
