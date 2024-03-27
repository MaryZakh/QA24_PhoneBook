package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {

    @BeforeClass
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser()
                    .login(new User().withEmail("mara@gmail.com").withPassword("Mmar123456$"));
        }

    }

    @Test
    public void addContactSuccessAllFields() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("NY")
                .email("stark"+ i + "@gmail.com")
                .phone("12365333" + i)
                .description("The best")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addContactSuccessRequiredFields() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Contact contact = Contact.builder()
                .name("Tony"+i)
                .lastName("Stark")
                .address("NY")
                .email("stark"+ i + "@gmail.com")
                .phone("12365333" + i)
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addNewContactWrongName(){

    }

    @Test
    public void addNewContactWrongAddress(){

    }

    @Test
    public void addNewContactWrongLastName(){

    }

    @Test
    public void addNewContactWrongPhone(){

    }

    @Test
    public void addNewContactWrongEmail(){

    }

}
