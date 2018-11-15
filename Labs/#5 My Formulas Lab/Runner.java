import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Formulas fm = new Formulas();
        Scanner kb = new Scanner(System.in);

        while (1 > 0) {
            fm.selectFormula();
            System.out.println("\nSelect a formula from this list.");
            int formulaChoice = kb.nextInt();

            if (formulaChoice == 0) {
                break;
            }
            if (formulaChoice == 1) {
                fm.circleArea1();
            }
            if (formulaChoice == 2) {
                fm.circleCircumference2();
            }
            if (formulaChoice == 3) {
                fm.squareArea3();
            }
            if (formulaChoice == 4) {
                fm.squarePerimeter4();
            }
            if (formulaChoice == 5) {
                fm.triangleArea5();
            }
            if (formulaChoice == 6) {
                fm.trianglePerimeter6();
            }
            if (formulaChoice == 7) {
                fm.parallelogramArea7();
            }
            if (formulaChoice == 8) {
                fm.trapezoidArea8();
            }
            if (formulaChoice == 9) {
                fm.cubeVolume9();
            }
            if (formulaChoice == 10) {
                fm.cylinderVolume10();
            }
            if (formulaChoice == 11) {
                fm.finalVelocitySS11();
            }
            if (formulaChoice == 12) {
                fm.timeSS12();
            }
            if (formulaChoice == 13) {
                fm.finalPositionSS13();
            }
            if (formulaChoice == 14) {
                fm.position14();
            }
            if (formulaChoice == 15) {
                fm.displacement15();
            }
        }
    }
}