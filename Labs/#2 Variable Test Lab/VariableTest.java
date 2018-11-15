import java.util.Scanner;

public class VariableTest {
    public static void main (String[] args) {
        System.out.println("Part 1: Data Types");

        byte num1 = 1;
        System.out.println("num1 is a byte and has the value of " + num1 + ".");

        short num2 = 2;
        System.out.println("num2 is a short and has the value of " + num2 + ".");

        int num3 = 3;
        System.out.println("num3 is an int and has the value of " + num3 + ".");

        long num4 = 4;
        System.out.println("num4 is a long and has the value of " + num4 + ".");

        char letter = 'A';
        System.out.println("letter is a char and has the value of " + letter + ".");

        float num5 = 1.5f;
        System.out.println("num5 is a float and has the value of " + num5 + ".");

        double num6 = 1.5;
        System.out.println("num6 is a double and has the value of " + num6 + ".");

        boolean trueOrFalse = true;
        System.out.println("trueOrFalse is a boolean and has the value of " + trueOrFalse + ".");



        System.out.println("\nPart 2: Chars");

        char char0 = 34;
        char char1 = 72;
        char char2 = 101;
        char char3 = 108;
        char char4 = 108;
        char char5 = 111;
        char char6 = 32;
        char char7 = 87;
        char char8 = 111;
        char char9 = 114;
        char char10 = 108;
        char char11 = 100;
        char char12 = 33;
        char char13 = 34;

        System.out.print(char0);
        System.out.print(char1);
        System.out.print(char2);
        System.out.print(char3);
        System.out.print(char4);
        System.out.print(char5);
        System.out.print(char6);
        System.out.print(char7);
        System.out.print(char8);
        System.out.print(char9);
        System.out.print(char10);
        System.out.print(char11);
        System.out.print(char12);
        System.out.println(char13);



        System.out.println("\nPart 3: Integers");
        
        // formula for area of square
        int sideLengthSquare = 5;
        int areaSquare = sideLengthSquare * sideLengthSquare;

        System.out.println("Area of Square");
        System.out.println("area = side length * side length");
        System.out.println("side length = " + sideLengthSquare);
        System.out.println("area = " + areaSquare);

        // formula for perimeter of square
        int sideLengthSquare2 = 5;
        int perimeterSquare2 = sideLengthSquare2 * 4;

        System.out.println("\nPerimeter of Square");
        System.out.println("perimeters = side length * 4");
        System.out.println("side length = " + sideLengthSquare2);
        System.out.println("perimeter = " + perimeterSquare2);
        
        // formula for perimeter of rectange
        int lengthRectangle = 5;
        int widthRectangle = 6;
        int perimeterRectangle = lengthRectangle * 2 + widthRectangle * 2;

        System.out.println("\nPerimeter of Rectangle");
        System.out.println("perimeter = length * 2 + width * 2");
        System.out.println("length = " + lengthRectangle);
        System.out.println("width = " + widthRectangle);
        System.out.println("perimeter = " + perimeterRectangle);

        // formula for area of right triangle
        int leg1Triangle = 5;
        int leg2Triangle = 6;
        int areaTriangle = (leg1Triangle * leg2Triangle)/2;

        System.out.println("\nArea of Right Triangle");
        System.out.println("area = (1st leg * 2nd leg)/2");
        System.out.println("1st leg = " + leg1Triangle);
        System.out.println("2nd leg = " + leg2Triangle);
        System.out.println("area = " + areaTriangle);

        // formula for area of any triangle
        int baseTriangle2 = 12;
        int heightTriangle2 = 15;
        int areaTriangle2 = (baseTriangle2 * heightTriangle2)/2;

        System.out.println("\nArea of Any Triangle (doesn't have to be right)");
        System.out.println("area = (base * height)/2");
        System.out.println("base = " + baseTriangle2);
        System.out.println("height = " + heightTriangle2);
        System.out.println("area = " + areaTriangle2);



        System.out.println("\nPart 4: Double");

        // pythagorean theorem
        double a = 3;
        double b = 4;
        double c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
        System.out.println("Pythagorean Formula");
        System.out.println("c = sqrt( a^2 + b^2 )");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        // distance formula
        System.out.println("\nDistance Formula");
        double x1 = 5.5;
        double y1 = 3.2;
        double x2 = 1.6;
        double y2 = 9.8;
        double distance = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        System.out.println("The distance between (" + x1 + ", " + y1 + ")");
        System.out.println("and (" + x2 + ", " + y2 + ") is ");
        System.out.println(distance + ".");

        // circumference of circle
        double pi = 3.14;
        double radius = 4;
        double circumference = 2*pi*radius;

        System.out.println("\nCircumference of a Circle");
        System.out.println("circumference = 2*pi*radius");
        System.out.println("pi = " + pi);
        System.out.println("radius = " + radius);
        System.out.println("circumference = " + circumference);

        // area of cicle
        double pi2 = 3.14;
        double radius2 = 2;
        double areaCircle = pi*Math.pow(radius2,2);
        
        System.out.println("\nArea of a Circle");
        System.out.println("area = pi*radius^2");
        System.out.println("pi = " + pi2);
        System.out.println("radius = " + radius2);
        System.out.println("area = " + areaCircle);

        // volume of cylinder
        double pi3 = 3.14;
        double radius3 = 2;
        double heightCylinder = 5;
        double volumeCylinder = pi*Math.pow(radius3,2)*heightCylinder;

        System.out.println("\nVolume of Cylinder");
        System.out.println("volume = pi*radius^2*height");
        System.out.println("pi = " + pi3);
        System.out.println("radius = " + radius3);
        System.out.println("height = " + heightCylinder);
        System.out.println("volume = " + volumeCylinder);

        System.out.println("\nChallenge");

        // area of circle with input
        System.out.println("Area of a Circle");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a radius (enter an int): ");
        int radius4 = input.nextInt();
        double pi4 = 3.14;
        double areaCircle2 = pi * radius4 * radius4;

        System.out.println("radius = " + radius4);
        System.out.println("pi = " + pi4);
        System.out.println("area = " + areaCircle2);

        // circumference of circle with input
        System.out.println("\nCircumference of a Circle");

        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter a radius (enter a double): ");
        double radius5 = input2.nextDouble();
        double pi5 = 3.14;
        double circumferenceCircle = pi*2*radius5;

        System.out.println("radius = " + radius5);
        System.out.println("pi = " + pi5);
        System.out.println("circumference = " + circumferenceCircle);
    }
}