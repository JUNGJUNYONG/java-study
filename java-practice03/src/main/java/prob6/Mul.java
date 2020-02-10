package prob6;

public class Mul {

	private int left, right;
	private int mul = 0;
	public void setValue(int left, int right)
	{
		this.left = left;
		this.right = right;
	}
	public int calculate() {
		mul = left / right;
		return mul;
	}
}
