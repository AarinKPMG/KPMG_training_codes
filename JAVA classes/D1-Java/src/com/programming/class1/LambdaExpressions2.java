package com.programming.class1;

interface Circle{
	double getAreaAndCircumference(double radius);
}

public class LambdaExpressions2 {
	
	public static void main(String[] args) {
		
		Circle circleArea = (r)->Math.PI*r*r;
		Circle circleCircumference = (r)->2*Math.PI*r;
		
		LambdaExpressions2 obj = new LambdaExpressions2();
		
		double area = obj.circleOperation(10,circleArea );
		double circumference = obj.circleOperation(100,circleCircumference);
		
		System.out.println("Area is "+area+" and Circumference is "+circumference);
		
	}
	
	double circleOperation( double radius , Circle c) {
		return c.getAreaAndCircumference(radius);
	}
	
}
