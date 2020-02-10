package prob6;

public class Sub {
	private int left, right;
	private int sub = 0;
	public void setValue(int left, int right)
	{
		this.left = left;
		this.right = right;
	}
	public int calculate() {
		sub = left - right;
		return sub;
	}
}
