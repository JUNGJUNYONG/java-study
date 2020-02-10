
package prob6;

import java.util.Scanner;

public class Prob06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while( true ) {
			System.out.print(">>");
			String expr = scanner.nextLine();
			
			if("quit".equals(expr))
			{
				break;
			}
			String[] tokens = expr.split(" ");
			if(tokens.length != 3)
			{
				System.out.println(">> 계산할 수 없는 연산식입니다.");
				continue; //계속 진행하기 위해 if문 위로 다시 올림 
			}
			int lValue = Integer.parseInt(tokens[0]);
			int RValue = Integer.parseInt(tokens[2]);
			int result = 0;
			if("+".equals(tokens[1]))
			{
				Add add = new Add();
				add.setValue(lValue, RValue);
				result = add.calculate();
			}
			else if("-".equals(tokens[1]))
			{
				Sub sub = new Sub();
				sub.setValue(lValue, RValue);
				result = sub.calculate();
			}
			else if("*".equals(tokens[1]))
			{
				Div div = new Div();
				div.setValue(lValue, RValue);
				result = div.calculate();
			}
			else if("/".equals(tokens[1]))
			{
				Mul mul = new Mul();
				mul.setValue(lValue, RValue);
				result = mul.calculate();
			}
			else
			{
				System.out.println(">> +, -, *, /만 가능합니다.");
				continue; //계속 진행하기 위해 if문 위로 다시 올림 
			}
			System.out.println(">>" + result);
		}
		scanner.close();
	}

}
