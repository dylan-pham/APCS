import java.util.Scanner;
import java.util.Random;

public class TriviaLab {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random randNum = new Random();
        int scoreGeography = 0;
        int scoreMath = 0;

        System.out.print("Would you like to play a geography trivia game or a math trivia game? ");
        String choice = keyboard.nextLine();

        if (choice.equals("geography")) {
            System.out.print("1. What is the capital of Great Britain? ");
            String capitalName = keyboard.nextLine();
            if (capitalName.equals("london")) {
                System.out.println("Nice job! +1\n");
                scoreGeography = scoreGeography + 1;
            } else{
                System.out.println("Fail.\n");
            }

            System.out.print("2. What continent is Brazil in? ");
            String continentName = keyboard.nextLine();
            if (continentName.equals("south america")) {
                System.out.println("Nice job! +1\n");
                scoreGeography = scoreGeography + 1;
            } else{
                System.out.println("Fail.\n");
            }

            System.out.print("3. Is India part of Asia? ");
            String yesOrNo = keyboard.nextLine();
            if (yesOrNo.equals("yes")) {
                System.out.println("Nice job! +1\n");
                scoreGeography = scoreGeography + 1;
            } else{
                System.out.println("Fail.\n");
            }

            System.out.print("4. What is the name of the ocean between Europe and North America? ");
            String oceanName = keyboard.nextLine();
            if (oceanName.equals("atlantic")) {
                System.out.println("Nice job! +1\n");
                scoreGeography = scoreGeography + 1;
            } else{
                System.out.println("Fail.\n");
            }

            System.out.print("5. What is the capital of Russia? ");
            String capitalName2 = keyboard.nextLine();
            if (capitalName2.equals("moscow")) {
                System.out.println("Nice job! +1\n");
                scoreGeography = scoreGeography + 1;
            } else{
                System.out.println("Fail.\n");
            }

            System.out.print("6. What country's capital is Madrid? ");
            String countryName = keyboard.nextLine();
            if (countryName.equals("spain")) {
                System.out.println("Nice job! +1\n");
                scoreGeography = scoreGeography + 1;
            } else{
                System.out.println("Fail.\n");
            }

            System.out.print("7. What is the biggest state in the US? ");
            String stateName = keyboard.nextLine();
            if (stateName.equals("alaska")) {
                System.out.println("Nice job! +1\n");
                scoreGeography = scoreGeography + 1;
            } else{
                System.out.println("Fail.\n");
            }

            System.out.print("8. Is australia a landlocked country? ");
            String yesOrNo2 = keyboard.nextLine();
            if (yesOrNo2.equals("no")) {
                System.out.println("Nice job! +1\n");
                scoreGeography = scoreGeography + 1;
            } else{
                System.out.println("Fail.\n");
            }

            System.out.print("9. What country has the greatest population on earth? ");
            String countryName2 = keyboard.nextLine();
            if (countryName2.equals("china")) {
                System.out.println("Nice job! +1\n");
                scoreGeography = scoreGeography + 1;
            } else{
                System.out.println("Fail.\n");
            }

            System.out.print("FINAL Q. What continent is Mexico on? ");
            String continentName2 = keyboard.nextLine();
            if (continentName2.equals("northAmerica")) {
                System.out.println("Nice job! +1\n");
                scoreGeography = scoreGeography + 1;
            } else{
                System.out.println("Fail.\n");
            }

            System.out.println("Congrats you scored " + scoreGeography + "/10");
        } 
        
        else {
            int length = randNum.nextInt(20) + 1;
            int width = randNum.nextInt(20) + 1;
            int rectangleArea = length * width;
            System.out.print("1. What is the area of a rectangle with length " + length + " and width " + width + " ? ");
            int rectangleAreaInput = keyboard.nextInt();
            if (rectangleAreaInput == rectangleArea) {
                System.out.println("Nice job! +1\n");
                scoreMath = scoreMath + 1;
            } else {
                System.out.println("Fail.\n");
            }

            int radius = randNum.nextInt(20) + 1;
            double circleCircumference = 2*3.14*radius;
            System.out.print("2. What is the circumference of a circle with a radius of " + radius + "? ");
            double circleCircumferenceInput = keyboard.nextDouble();
            if (circleCircumferenceInput == circleCircumference) {
                System.out.println("Nice job! +1\n");
                scoreMath = scoreMath + 1;
            } else {
                System.out.println("Fail.\n");
                System.out.println(circleCircumference);
            }

            int radius2 = randNum.nextInt(20) + 1;
            double circleArea = 3.14*radius2*radius2;
            System.out.print("3. What is the area of circle with a radius of " + radius2 +"? ");
            double circleAreaInput = keyboard.nextDouble();
            if (circleAreaInput == circleArea) {
                System.out.println("Nice job! +1\n");
                scoreMath = scoreMath + 1;
            } else {
                System.out.println("Fail.\n");
                System.out.println(circleArea);
            }

            int radius3 = randNum.nextInt(20) + 1;
            int height = randNum.nextInt(20) + 1;
            double cylinderVolume = 3.14*radius3*radius3*height;
            System.out.print("4. What is the volume of cylinder with a radius of " + radius3 + " and height of " + height + "? ");
            double volumeInput = keyboard.nextDouble();
            if (volumeInput == cylinderVolume) {
                System.out.println("Nice job! +1\n");
                scoreMath = scoreMath + 1;
            } else {
                System.out.println("Fail.\n");
                System.out.println(cylinderVolume);
            }

            int height2 = randNum.nextInt(20) + 1;
            int base = randNum.nextInt(20) + 1;
            double triangleArea = (base*height2)/2.0;
            System.out.print("5. What is the area of a triangle with a height of " + height2 + " and base of " + base + "? ");
            double triangleAreaInput = keyboard.nextDouble();
            if (triangleAreaInput == triangleArea) {
                System.out.println("Nice job! +1\n");
                scoreMath = scoreMath + 1;
            } else {
                System.out.println("Fail.\n");
            }

            int sideLength = randNum.nextInt(20) + 1;
            int cubeVolume = sideLength*sideLength*sideLength;
            System.out.print("6. What is the volume of a cube with a length of " + sideLength + "? ");
            int cubeVolumeInput = keyboard.nextInt();
            if (cubeVolumeInput == cubeVolume) {
                System.out.println("Nice job! +1\n");
                scoreMath = scoreMath + 1;
            } else {
                System.out.println("Fail.\n");
            }

            int height3 = randNum.nextInt(20) + 1;
            int base2 = randNum.nextInt(20) + 1;
            int parallelogramArea = height3 * base2;
            System.out.print("7. What is the area of a parallelogram with a height of " + height3 + " and base of " + base2 + "? ");
            int parallelogramAreaInput = keyboard.nextInt();
            if (parallelogramAreaInput == parallelogramArea) {
                System.out.println("Nice job! +1\n");
                scoreMath = scoreMath + 1;
            } else {
                System.out.println("Fail.\n");
            }

            int firstBase = randNum.nextInt(20) + 1;
            int secondBase = randNum.nextInt(20) + 1;
            int height4 = randNum.nextInt(20) + 1;
            double trapezoidArea = ((firstBase + secondBase)/1.0/2)*height4;
            System.out.print("8. What is the area of a trapezoid with a height of " + height4 + " a first base of " + firstBase + " and a second base of " + secondBase + "? ");
            double trapezoidAreaInput = keyboard.nextDouble();
            if (trapezoidAreaInput == trapezoidArea) {
                System.out.println("Nice job! +1\n");
                scoreMath = scoreMath + 1;
            } else {
                System.out.println("Fail.\n");
                System.out.println(trapezoidArea);
            }

            int sideLength2 = randNum.nextInt(20) + 1;
            int height5 = randNum.nextInt(20) + 1;
            double pyramidVolume = (sideLength2*sideLength2*height5)/3.0;
            double pyramidVolumeRounded = Math.round(pyramidVolume * 100.0) / 100.0;
            System.out.print("9. What is the volume of a pyramid with a height of " + height5 + " and a side length of " + sideLength2 + "? ");
            double pyramidVolumeInput = keyboard.nextDouble();
            if (pyramidVolumeInput == pyramidVolumeRounded) {
                System.out.println("Nice job! +1\n");
                scoreMath = scoreMath + 1;
            } else {
                System.out.println("Fail.\n");
                System.out.println(pyramidVolumeRounded);
            }

            int radius4 = randNum.nextInt(20) + 1;
            double sphereVolume = (4*(3.14*radius4*radius4*radius4))/3.0;
            double sphereVolumeRounded = Math.round(sphereVolume * 100.0) / 100.0;
            System.out.print("FINAL Q. What is the volume of a sphere with a radius of " + radius4 + "? ");
            double sphereVolumeInput = keyboard.nextDouble();
            if (sphereVolumeInput == sphereVolumeRounded) {
                System.out.println("Nice job! +1\n");
                scoreMath = scoreMath + 1;
            } else {
                System.out.println("Fail.\n");
                System.out.println(sphereVolumeRounded);
            }

            System.out.println("Congrats you scored " + scoreMath + "/10");
        }
    }
}