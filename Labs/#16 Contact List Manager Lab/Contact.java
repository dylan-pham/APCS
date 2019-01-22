public class Contact {
    private String firstName;
    private String lastName;
    private String email;

    public Contact(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Contact() {
        firstName = "";
        lastName = "";
        email = "";
    }

    public String toString() {
        return firstName + " " + lastName + " " + "      " + email + "\n";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailUsername() {
        try {
            return email.substring(0, email.indexOf("@"));
        } catch (Exception e) {
            return "";
        }
    }

    public String getEmailDomainName() {
        try {
            return email.substring(email.indexOf("@") + 1, email.lastIndexOf("."));
        } catch (Exception e) {
            return "";
        }
    }

    public String getEmailDomainExtension() {
        try {
            return email.substring(email.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
}