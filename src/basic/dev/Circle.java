package basic.dev;

public class Circle extends Shape {
	private double banKinh;
	
	public Circle(String name, double banKinh) {
		super(name);
		this.banKinh = banKinh;
	}

	@Override
	double chuVi() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * banKinh;
	}

	@Override
	double dienTich() {
		// TODO Auto-generated method stub
		return Math.PI * banKinh * banKinh;
	}

}
