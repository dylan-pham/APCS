public class Career {
    private String name;
    private int age;
    private String subject;
    private String hobby;
    private String food;

    public Career(String name, int age, String subject, String hobby, String food) {
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.hobby = hobby;
        this.food = food;
    }

    public void printInfo() {
        System.out.println("\n" + name + ", " + age + ", " + subject + ", " + hobby + ", " + food);
        printCareer();
    }

    private void printCareer() {
        if ( subject.equals("math") && hobby.equals("soccer") && food.equals("pasta") ) {
            System.out.println("Career: programmer");
        }
        if ( subject.equals("math") && hobby.equals("soccer") && food.equals("burgers") ) {
            System.out.println("Career: teacher");
        }
        if ( subject.equals("math") && hobby.equals("music") && food.equals("pasta") ) {
            System.out.println("Career: businessman");
        }
        if ( subject.equals("math") && hobby.equals("music") && food.equals("burgers") ) {
            System.out.println("Career: real estate agent");
        }
        if ( subject.equals("history") && hobby.equals("soccer") && food.equals("pasta") ) {
            System.out.println("Career: model");
        }
        if ( subject.equals("history") && hobby.equals("soccer") && food.equals("burgers") ) {
            System.out.println("Career: athlete");
        }
        if ( subject.equals("history") && hobby.equals("music") && food.equals("pasta") ) {
            System.out.println("Career: architect");
        }
        if ( subject.equals("history") && hobby.equals("music") && food.equals("burgers") ) {
            System.out.println("Career: photographer");
        }
        if ( subject.equals("english") && hobby.equals("soccer") && food.equals("pasta") ) {
            System.out.println("Career: electrician");
        }
        if ( subject.equals("english") && hobby.equals("soccer") && food.equals("burgers") ) {
            System.out.println("Career: mechanical engineer");
        }
        if ( subject.equals("english") && hobby.equals("music") && food.equals("pasta") ) {
            System.out.println("Career: musician");
        }
        if ( subject.equals("english") && hobby.equals("music") && food.equals("burgers") ) {
            System.out.println("Career: actor");
        }
    }

    public void updateProfile(String name, int age, String subject, String hobby, String food) {
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.hobby = hobby;
        this.food = food;
    }
}