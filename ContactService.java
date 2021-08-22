package Contact;
import java.util.ArrayList;
import java.util.List;


public class ContactService {
 //List of ContactClass called contacts
    private List<ContactClass> contacts;
// constructor
    public ContactService() {
        contacts = new ArrayList<>();
    }
// re-usable loop to search  the contacts list
    private int searchContact(String contactId) {

        for(int i=0; i<contacts.size(); i++) {
            if(contacts.get(i).getId() == contactId) {
                return i; // returns the index  number
            }
        }
        return -1;  //  if nothing in list returns -1
    }

    public void addContact(ContactClass newContact) {
//  Checks to see if the contact is null
        if(newContact == null) {
            throw new IllegalArgumentException("Contact can't be null!");
        }
// Checks to see if the contact is in the list with an index number already
        if(searchContact(newContact.getId()) != -1) {    // re-usable function loop to search  the contacts list
            throw new IllegalArgumentException("Duplicated id");
        }
//  if its not null and the id number does not exist it creates a new contact
        contacts.add(newContact);
    }
//  contact size checks the list size, later used to check if something was added or deleted from the list
    public int size() {
        return contacts.size();
    }
// when final keyword is used with a variable int, value of the variable cannot be changed.
    public ContactClass getContact(String contactId) {

//  gets the contact index number with the contact iD and assigns it to a variable
        final int contactIndex = searchContact(contactId); // re-usable function searchContact() loop to search  the contacts list
        if (contactIndex == -1) {
            return null;
        }
        // .get a list method
        return contacts.get(contactIndex);
    }

    public void removeContact(String contactId) {

        int contactIndex = searchContact(contactId);   // re-usable function searchContact() loop to search  the contacts list

        if (contactIndex != -1) {
            // .remove a list method
            contacts.remove(searchContact(contactId));  // re-usable function searchContact() loop to search  the contacts list
        }
    }

    public void updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {

        int contactIndex = searchContact(contactId);  // re-usable function loop to search  the contacts list

        if(contactIndex == -1) {
            throw new IllegalArgumentException("There is no contact with this id!");
        } //. get method of a list type will get the index number of the list called contacts then a setter method called to replace the varible with a new one.
        contacts.get(contactIndex).setFirstName(firstName);
        contacts.get(contactIndex).setLastName(lastName);
        contacts.get(contactIndex).setPhoneNumber(phoneNumber);
        contacts.get(contactIndex).setHomeAddress(address);
    }
}



