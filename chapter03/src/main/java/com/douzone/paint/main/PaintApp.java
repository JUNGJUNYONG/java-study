package com.douzone.paint.main;


import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;

public class PaintApp {

	public static void main(String[] args) {
		Point point1 = new Point(2, 5);
		//drawPoint(point1);
		draw(point1);
		
		Point point2 = new Point(10, 50);
		//drawPoint(point2);
		draw(point2);
		//point2.show(false);
		
		
		Point point3 = new ColorPoint(50, 100, "red");
		//drawPoint(point3);
		draw(point3);
		point3.show(false);
		point3.show(true);
		
		Rect rect = new Rect();
		//drawRect(rect);
		//drawShape(rect);
		draw(rect);	
		
		Triangle triangle = new Triangle();
		//drawTriangle(triangle);
		//drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
		//drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("hello"));
		
		// instanceof test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		// 오류: class는 hierachy 상위와 하위만 instanceof 연산자를 사용할 수 있다.
		//System.out.println(circle instanceof Rect);
		
		Shape s = new Circle();
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rect);
		
		// Interface 는 hierachy 상관없이 instanceof 연산자를 사용할 수 있다.
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Runnable);
		
	}

	public static void draw(Drawable d) {
		d.draw();
	}
	
	public static void drawShape(Shape shape) {
		shape.draw();
	}
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
	
	public static void drawPoint(Point point) {
		point.show();
	}
}
