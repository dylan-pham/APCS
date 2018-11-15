import java.util.Scanner;

public class Formulas {
    private double pi = 3.14;
    private double gravity = -9.8;
    private Scanner kb = new Scanner(System.in);

    public void selectFormula() {
        System.out.println("\n1. Area of a circle");
        System.out.println("2. Circumference of a circle");
        System.out.println("3. Area of a square");
        System.out.println("4. Perimeter of a square");
        System.out.println("5. Area of triangle");
        System.out.println("6. Perimeter of triangle");
        System.out.println("7. Area of parallelogram");
        System.out.println("8. Area of a trapezoid");
        System.out.println("9. Volume of a cube");
        System.out.println("10. Volume of a cylinder");
        System.out.println("11. Final Velocity of falling object (stand-still)");
        System.out.println("12. Time of falling object (stand-still)");
        System.out.println("13. Final position of falling object (stand-still)");
        System.out.println("14. Position of object");
        System.out.println("15. Dispacement of object");
    }

    public void circleArea1() {
        System.out.println("\nThis calculates the area of a circle.");
        System.out.print("Enter a radius: ");
        int radius1 = kb.nextInt();
        double area1 = pi*radius1*radius1;
        System.out.println("The area of the circle is " + area1 + ".");
    }

    public void circleCircumference2() {
        System.out.println("\nThis calculates the circumference of a circle.");
        System.out.print("Enter a radius: ");
        int radius2 = kb.nextInt();
        double area2 = 2*pi*radius2;
        System.out.println("The circumference of the circle is " + area2 + ".");
    }

    public void squareArea3() {
        System.out.println("\nThis calculates the area of a square.");
        System.out.print("Enter a length: ");
        int length3 = kb.nextInt();
        int area3 = length3 * length3;
        System.out.println("The area of the square is " + area3 + ".");
    }

    public void squarePerimeter4() {
        System.out.println("\nThis calculates the perimeter of a square.");
        System.out.print("Enter a length: ");
        int length4 = kb.nextInt();
        int perimeter4 = length4*4;
        System.out.println("The perimeter of the square is " + perimeter4 + ".");
    }

    public void triangleArea5() {
        System.out.println("\nThis calculates the area of a triangle.");
        System.out.print("Enter a height: ");
        int height5 = kb.nextInt();
        System.out.print("Enter a base: ");
        int base5 = kb.nextInt();
        double area5 = (base5*height5)/2.0;
        System.out.println("The area of the triangle is " + area5 + ".");
    }

    public void trianglePerimeter6() {
        System.out.println("\nThis calculates the perimeter of a triangle.");
        System.out.print("Enter the 1st side length: ");
        int firstSideLength6 = kb.nextInt();
        System.out.print("Enter the 2nd side length: ");
        int secondSideLength6 = kb.nextInt();
        System.out.print("Enter the 3rd side length: ");
        int thirdSideLength6 = kb.nextInt();
        double perimeter6 = firstSideLength6 + secondSideLength6 + thirdSideLength6;
        System.out.println("The perimeter of the triangle is " + perimeter6 + ".");
    }

    public void parallelogramArea7() {
        System.out.println("\nThis calculates the area of a parallelogram.");
        System.out.print("Enter a height: ");
        int height7 = kb.nextInt();
        System.out.print("Enter a base: ");
        int base7 = kb.nextInt();
        double area7 = (base7*height7)/2.0;
        System.out.println("The area of the parallelogram is " + area7 + ".");
    }

    public void trapezoidArea8() {
        System.out.println("\nThis calculates the area of a trapezoid.");
        System.out.print("Enter the 1st base: ");
        int firstBase8 = kb.nextInt();
        System.out.print("Enter the 2nd base: ");
        int secondBase8 = kb.nextInt();
        System.out.print("Enter the height: ");
        int height8 = kb.nextInt();
        double area8 = ((firstBase8+secondBase8)/2.0) * height8;
        System.out.println("The area of the trapezoid is " + area8 + ".");
    }

    public void cubeVolume9() {
        System.out.println("\nThis calculates the volume of a cube.");
        System.out.print("Enter a length: ");
        int length9 = kb.nextInt();
        int volume9 = length9 * length9 * length9;
        System.out.println("The volume of the cube is " + volume9 + ".");
    }

    public void cylinderVolume10() {
        System.out.println("\nThis calculates the volume of a cylinder.");
        System.out.print("Enter a radius: ");
        int radius10 = kb.nextInt();
        System.out.print("Enter a height: ");
        int height10 = kb.nextInt();
        double volume10 = pi * radius10 * radius10 * height10;
        System.out.println("The volume of the cylinder is " + volume10 + ".");
    }

    public void finalVelocitySS11() {
        System.out.println("\nThis calculates the final velocity of a falling object from stand-still.");
        System.out.print("Enter the time it takes for your object to fall: ");
        int time11 = kb.nextInt();
        double finalVelocity11 = gravity*time11;
        System.out.println("The final velocity of the object is " + finalVelocity11 + "m/s.");
    }

    public void timeSS12() {
        System.out.println("\nThis calculates the time of a falling object from stand-still.");
        System.out.print("Enter the final velocity: ");
        int finalVelocity12 = kb.nextInt();
        double time12 = finalVelocity12/gravity;
        System.out.println("The time the object is falling is " + time12 + "s.");
    }

    public void finalPositionSS13() {
        System.out.println("\nThis calculates the final position of a falling object that starts from stand-still.");
        System.out.print("Enter the time at the final position: ");
        int time13 = kb.nextInt();
        System.out.print("Enter the initial position: ");
        int initialPosition13 = kb.nextInt();
        double finalPosition13 = initialPosition13 + 0.5 * 9.8 * (time13 * time13);
        System.out.println("The final position of the object is " + finalPosition13 + "m.");
    }

    public void position14() {
        System.out.println("\nThis calculates the position of an object.");
        System.out.print("Enter a certain time: ");
        int time14 = kb.nextInt();
        System.out.print("Enter the average velocity: ");
        int averageVelocity14 = kb.nextInt();
        double position14 = averageVelocity14 * time14;
        System.out.println("The position the object is " + position14 + "m.");
    }

    public void displacement15() {
        System.out.println("\nThis calculates the displacement of an object.");
        System.out.print("Enter the initial positon of the object: ");
        int initialPosition15 = kb.nextInt();
        System.out.print("Enter the final position object: ");
        int finalPosition15 = kb.nextInt();
        double displacement15 = finalPosition15 - initialPosition15;
        System.out.println("The displacement of the object is " + displacement15 + "s.");
    }
}