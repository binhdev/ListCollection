package basic.dev;

public abstract class Shape {
	private String name;
	
	public Shape(String name) {
		super();
		this.name = name;
	}
	abstract double chuVi();
	abstract double dienTich();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Name: %s", name);
	}
}
