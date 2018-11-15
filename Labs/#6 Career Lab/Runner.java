import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        while ( 1 > 0 ) {
            Career p1 = new Career("Tim", 17, "math", "music", "burgers");
            Career p2 = new Career("Joe", 52, "history", "soccer", "pasta");
            Career p3 = new Career("Sam", 32, "english", "music", "pasta");

            p1.printInfo();
            p2.printInfo();
            p3.printInfo();

            System.out.println("\nSubjects: math, history, english");
            System.out.println("Hobbies: music, soccer");
            System.out.println("Foods: burgers, pasta\n");

            Scanner kb = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = kb.nextLine();
            System.out.print("Enter your age: ");
            int age = kb.nextInt();
            System.out.print("Enter your favorite subject from the list: ");
            String irrelevant = kb.nextLine(); //white space issue
            String subject = kb.nextLine();
            System.out.print("Enter your favorite hobby from the list: ");
            String hobby = kb.nextLine();
            System.out.print("Enter your favorite food from the list: ");
            String food = kb.nextLine();

            p3.updateProfile(name, age, subject, hobby, food);
            p3.printInfo();

            System.out.print("\nWould you like to find another career? Y or N. ");
            String response = kb.nextLine();
            if ( response.equals("N")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }
    }
}