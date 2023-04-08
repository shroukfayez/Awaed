package resources;

public class TestDataBuilder {


    public AddUser AddUserPayload(String firstName, String lastName, String email, String active){

        AddUser body = new AddUser();
        body.setFirstName(firstName);
        body.setLastName(lastName);
        body.setEmail(email);
        body.setActive(active);

        return body;
    }
}
