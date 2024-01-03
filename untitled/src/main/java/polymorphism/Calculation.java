package polymorphism;


public class Calculation {

    public float calculate(float base, float height){
        System.out.println("Area of triangle");
        return (0.5f* base *height);
    }
    public double calculate(float radius){
        System.out.println("Area of circle");
        return (Math.PI * radius*radius);
    }

    public int calculate(int side){
        System.out.println("Area of squared");
        return side * side;
    }

    public double calculate(double length, double breadth){
        System.out.println("Area of rectangle");
        return length *breadth;
    }

}
