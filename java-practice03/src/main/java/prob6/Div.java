package prob6;

public class Div {

	private int left, right;
	private int div = 0;
	public void setValue(int left, int right)
	{
		this.left = left;
		this.right = right;
	}
	public int calculate() {
		div = left * right;
		return div;
	}
}
