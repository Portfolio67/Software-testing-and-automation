package Contact;
public class ContactClass {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String homeAddress;
    private String id;

// on constructor to keep from over riding data  https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html
    public ContactClass(String firstName, String lastName, String phoneNumber, String homeAddress, String id) {
// Checks if null and less than 10
        //.length() method on string
        if(firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
// Checks if null and less than 10
        if(lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
// Checks if null and if not 10
        if(phoneNumber == null || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid Phone number");
        }
// Checks if null and if not 30
        if(homeAddress == null || homeAddress.length() != 30) {
            throw new IllegalArgumentException("Invalid Address number");
        }
// Checks if null and if less than 11
        if ( id == null || id.length() < 11) {
            throw new IllegalArgumentException("Invalid, duplicate or number");
        }

// From within a constructor, you can also use the this keyword to call another constructor in the same class.
// Doing so is called an explicit constructor invocation.
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.id = id;

    }


//  setters and getters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getHomeAddress() { return homeAddress; }

    public void setHomeAddress(String homeAddress) { this.homeAddress = homeAddress; }

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }
}
