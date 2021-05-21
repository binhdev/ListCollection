package basic.dev;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/**
 * Viet chuong trinh xay dung lop abstract class Shape voi phuong thuc tru tuong 
 * tinhChuVi 
 * tinhDienTich
 * 
 * Xay dung 3 lop con ke thua lop Shape
 * Circle: banKinh
 * Rectangle: canhA, canhB
 * Triangle: canhA, canhB, canhC
 * 1. Viet ham nhap, xuat vao danh sach List<Shape> list doc tu file input
 * 2. Viet ham tim xem hinh nao co chu vi lon nhat, be nhat, hinh nao co dien tich lon nhat, be nhat
 * 3. Viet ham sap xep list theo danh sach chu vi be den lon
 * @author TranThanhBinh
 *
 */
public class MainApp {
	static List<Shape> readFromFile(String fileName) throws NumberFormatException, IOException{
		List<Shape> shapeList = new ArrayList<Shape>();
		
		FileInputStream fstream = new FileInputStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String strLine;
		while((strLine = br.readLine()) != null) {
			if(strLine.indexOf("#Triangle") == 0) {
				String name = strLine.substring(1, strLine.length());
				double canhA = Double.parseDouble(br.readLine());
				double canhB = Double.parseDouble(br.readLine());
				double canhC = Double.parseDouble(br.readLine());
				Triangle tg = new Triangle(name, canhA, canhB, canhC);
				shapeList.add(tg);
			}
			
			if(strLine.indexOf("#Circle") == 0) {
				String name = strLine.substring(1, strLine.length());
				double banKinh = Double.parseDouble(br.readLine());
				Circle circle = new Circle(name, banKinh);
				shapeList.add(circle);
			}
			
			if(strLine.indexOf("#Rectangle") == 0) {
				String name = strLine.substring(1, strLine.length());
				double canhA = Double.parseDouble(br.readLine());
				double canhB = Double.parseDouble(br.readLine());
				Rectangle rect = new Rectangle(name, canhA, canhB);
				shapeList.add(rect);
			}
			
		}
		
		return shapeList;
	}
	
	static void printList(List<Shape> list) {
		Iterator<Shape> it = list.iterator();
		while(it.hasNext()) {
			Shape shape = it.next();
			System.out.println(shape.toString());
		}
	}
	
	static void findMinMax(List<Shape> list) {
		if(list.isEmpty()) return;
		Shape min = list.get(0);
		Shape max = list.get(0);
		
		Iterator<Shape> it = list.iterator();
		while(it.hasNext()) {
			Shape shape = it.next();
			if(min.chuVi() > shape.chuVi()) {
				min = shape;
			}
			
			if(max.chuVi() < shape.chuVi()) {
				max = shape;
			}
		}
		
		System.out.println("Shape co chu vi be nhat");
		System.out.println(min);

		System.out.println("Shape co chu vi lon nhat");
		System.out.println(max);
	}
	
	static void sortList(List<Shape> list) {
		list.sort(new Comparator<Shape>() {

			@Override
			public int compare(Shape o1, Shape o2) {
				// TODO Auto-generated method stub
				return o1.chuVi() > o2.chuVi() ? 1 : -1;
			}
		});
		
		printList(list);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		List<Shape> shapeList = readFromFile("input.txt");
		
		System.out.println("In ra danh sach cac hinh");
		printList(shapeList);
		
		System.out.println("Tim min max chu vi");
		findMinMax(shapeList);
		
		System.out.println("Sap xep danh sach");
		sortList(shapeList);
	}
}
