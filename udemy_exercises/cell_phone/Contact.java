package cell_phone;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact saveContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
}

/*
    - **Contact Class:**
        - Name
        - Phone number
        - saveContact()
        - modifyContact()
        - searchContact()
        - removeContact()
*/
