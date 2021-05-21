package basic.dev;

public class Rectangle extends Shape {
	private double canhA;
	private double canhB;


	public Rectangle(String name, double canhA, double canhB) {
		super(name);
		this.canhA = canhA;
		this.canhB = canhB;
	}

	@Override
	double chuVi() {
		// TODO Auto-generated method stub
		return 2 * (canhA + canhB);
	}

	@Override
	double dienTich() {
		// TODO Auto-generated method stub
		return canhA * canhB;
	}
	
	
	
}
