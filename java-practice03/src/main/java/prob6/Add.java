package prob6;

public class Add {
	private int left, right;
	private int sum = 0;
	public void setValue(int left, int right)
	{
		this.left = left;
		this.right = right;
	}
	public int calculate() {
		sum = left + right;
		return sum;
	}
}
