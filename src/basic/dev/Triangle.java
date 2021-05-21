package basic.dev;

public class Triangle extends Shape {
	private double canhA;
	private double canhB;
	private double canhC;
	public Triangle(String name, double canhA, double canhB, double canhC) {
		super(name);
		this.canhA = canhA;
		this.canhB = canhB;
		this.canhC = canhC;
	}
	
	@Override
	double chuVi() {
		// TODO Auto-generated method stub
		return canhA + canhB + canhC;
	}
	
	@Override
	double dienTich() {
		// TODO Auto-generated method stub
		double p = chuVi()/2;
		return Math.sqrt(p * (p-canhA) * (p-canhB) * (p-canhC));
	}
	
}
