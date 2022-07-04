package demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    @Test
    void successfulTest() {
        String firstName = "Alex";
        String lastName = "Egorov";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail("alex@egorov.com")
                .setGender("Other");

        $("#userNumber").setValue("1231231230");
        registrationFormPage.setDateOfBirth("30", "July", "2008");


        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/summer.jpeg");
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        registrationFormPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", "alex@egorov.com")
                .checkResult("Date of Birth", "30 July,2008");
  }

    @Test
    void successfulDateWithKeysTest() {
        String firstName = "Alex";
        String lastName = "Egorov";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail("alex@egorov.com")
                .setGender("Other");

        $("#userNumber").setValue("1231231230");
        registrationFormPage.setDateOfBirthWhithKeys("30", "July", "2008");


        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/summer.jpeg");
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        registrationFormPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", "alex@egorov.com")
                .checkResult("Date of Birth", "30 July,2008");
    }

    @Test
    void unSuccessfulTest() {
        String firstName = "Alex";
        String lastName = "Egorov";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail("alex@egorov.com")
                .setGender("Other");

        $("#userNumber").setValue("1231231230");
        registrationFormPage.setDateOfBirth("30", "July", "2008");


        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/summer.jpeg");
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName),
                text("alex@egorov.com"), text("Some street 1"), text("30 July,2008"));
    }
}
