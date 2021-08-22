package Test;

import Contact.ContactClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactClassTest {
    // Test contact format is right in length
    @Test
    void testContactClass() {
        ContactClass contactClass = new ContactClass("Cornelious","Alessandro", "0123456789", "987654321098765432109876543210", "0123456789888");
        assertTrue(contactClass.getFirstName().equals("Cornelious"));
        assertTrue(contactClass.getLastName().equals("Alessandro"));
        assertTrue(contactClass.getPhoneNumber().equals("0123456789"));
        assertTrue(contactClass.getHomeAddress().equals("987654321098765432109876543210"));
        assertTrue(contactClass.getId().equals("0123456789888"));

    }
    /* Too long First name*/
    @Test
    void testFirstNameIsTooLongClass() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  {
            new ContactClass("jim 123456789","Alessandro", "0123456789", "987654321098765432109876543210" , "1234567891");
        });
    }
    /* Too long Last name*/
    @Test
    void testLastNameIsTooLongClass() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  {
            new ContactClass("Cornelious","Alessandro888", "0123456789", "987654321098765432109876543210", "1234567891");
        });
    }
    /* Too long phone*/
    @Test
    void testPhoneNumberIsTooLongClass() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  {
            new ContactClass("Cornelious","Alessandro", "0123456789888", "987654321098765432109876543210", "1234567891");
        });
    }
    /* Too long adress*/
    @Test
    void testAddressNumberIsTooLongClass() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  {
            new ContactClass("Cornelious","Alessandro", "0123456789", "987654321098765432109876543210888", "1234567891");
        });
    }

    /* Too long id*/
    @Test
    void testIdNumberIsTooLongClass() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  {
            new ContactClass("Cornelious","Alessandro", "0123456789", "987654321098765432109876543210888", "1234567891888");
        });
    }
    //contact Null
    //First name is null
    @Test
    void testFirstNameIsNullClass() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ContactClass(null,"Alessandro", "0123456789", "987654321098765432109876543210", "1234567891"));
    }

    //Last name is null
    @Test
    void testLastNameIsNullClass() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  {
            new ContactClass("Cornelious",null, "0123456789", "987654321098765432109876543210", "1234567891");
        });
    }

    //Phone number is null
    @Test
    void testPhoneNumberIsNullClass() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  {
            new ContactClass("Cornelious","Alessandro", null, "987654321098765432109876543210", "1234567891");
        });
    }

    //Address is null
    @Test
    void testAddressNumberIsNullClass() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  {
            new ContactClass("Cornelious","Alessandro", "0123456789", null, "1234567891");
        });
    }

    //iD is null
    @Test
    void testIdNumberIsNullClass() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  {
            new ContactClass("Cornelious","Alessandro", "0123456789", "987654321098765432109876543210", null);
        });
    }

}
