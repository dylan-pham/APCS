public class Bank {
    private String nameArray[] = new String[3];
    private double balanceArray[] = new double[3];
    private int pinArray[] = new int[3];
    private boolean access[] = new boolean[3];
    private int identifier;

    public Bank(String name, double balance, int pin, int identifier) {
        nameArray[identifier] = name;
        balanceArray[identifier] = balance;
        pinArray[identifier] = pin;
        this.identifier = identifier;
        access[identifier] = false;
    }

    public String getName() {
        if ( access[identifier] == true ) {
            return nameArray[identifier];
        } else {
            return "No access";
        }
    }

    public double getBalance() {
        if ( access[identifier] == true ) {
            return balanceArray[identifier];
        } else {
            return 0.0;
        }
    }

    public void disableAccess() {
        access[identifier] = false;
    }

    public boolean getAccess() {
        return access[identifier];
    }

    public void checkPin(int pinArrayInput) {
        if ( pinArrayInput == pinArray[identifier] ) {
            access[identifier] = true;
        } else {
            access[identifier] = false;
        }
    }

    public void deposit(double deposit) {
        if ( access[identifier] == true ) {
            balanceArray[identifier] += deposit;
        }
    }

    public void withdraw(double withdraw) {
        if ( access[identifier] == true && balanceArray[identifier] >= withdraw ) {
            balanceArray[identifier] -= withdraw;
        }
    }

    public void updateName(String nameArray) {
        if ( access[identifier] == true ) {
            this.nameArray[identifier] = nameArray;
        }
    }
}