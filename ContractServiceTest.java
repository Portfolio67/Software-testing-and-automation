package Test;
import Contact.ContactService;
import Contact.ContactClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

class ContractServiceTest {

    private ContactService contractService;

    @BeforeEach  //  before each test is run the creation of a new contractService of ContactService() class that makes a new list contacts when envoked
    void initContract() {
        contractService = new ContactService();
    }

    @Test
    void testAddContact() {
// 1st makes an object called  contactClass that object sits in the list contacts that was made in the @BeforeEach
        ContactClass contactClass = new ContactClass("Cornelious", "Alessandro", "0123456789", "987654321098765432109876543210", "341234567891");
        assertTrue(contractService.size() == 0);// tests that one object is in the lists contacts
        contractService.addContact(contactClass);  //  creates the object for the list
        assertTrue(contractService.size() == 1); //  tests 2 objects are now in the list

        //test a method which throws an exception https://howtodoinjava.com/junit5/expected-exception-example/
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contractService.addContact(contactClass);
        });
        assertTrue(contractService.size() == 1);

        ContactClass contactClass2 = new ContactClass("Cornelious", "Alessandro", "0123456789", "987654321098765432109876543210", "99234567891");
        contractService.addContact(contactClass2);
        assertTrue(contractService.size() == 2); //  tests 3 objects are now in the list
    }

    @Test
    void testRemoveContact() {
// 1st makes an object called  contactClass  then it isput into a list
        ContactClass contactClass = new ContactClass("Cornelious", "Alessandro", "0123456789", "987654321098765432109876543210", "341234567891");
        assertTrue(contractService.size() == 0); // test 1 object there
        contractService.addContact(contactClass); // adds contact bject
        assertTrue(contractService.size() == 1); // // test 2 objects there

        contractService.removeContact("-3werewr"); //  trys to remove a non existant iD
        assertTrue(contractService.size() == 1);//  tests that the id is not found or removed

        contractService.removeContact(contactClass.getId());  // the contractService has a method called removeContact that removes object after calling a getter for an id,  the parameter can be empty for getId
        assertTrue(contractService.size() == 0);       // test 1 object there
    }

    @Test
    void testUpdateContact() {
//1st line; makes a contact object. 2nd line puts object into list.  3rd line updated contact info for that object after finding it with the iD,
        ContactClass contactClass = new ContactClass("Cornelious", "Alessandro", "0123456789", "987654321098765432109876543210", "341234567891");
        contractService.addContact(contactClass);
        contractService.updateContact(contactClass.getId(), "Bob", "Bill", "1232134234", "Street X12345");
        ContactClass updatedContact = contractService.getContact(contactClass.getId()); // creates a variable updatedContact of ContactClass, from the contractService list placed with an iD number, which can be empty or a particular id
        // test that the variable updatedContact has been updated.
        assertTrue(updatedContact.getFirstName() == "Bob");
        assertTrue(updatedContact.getLastName() == "Bill");
        assertTrue(updatedContact.getPhoneNumber() == "1232134234");
        assertTrue(updatedContact.getHomeAddress() == "Street X12345");
    }
}