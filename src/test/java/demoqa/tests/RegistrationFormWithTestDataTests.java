package demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static demoqa.utils.RandomUtils.getRandomEmail;
import static demoqa.utils.RandomUtils.getRandomString;

public class RegistrationFormWithTestDataTests extends TestBase {
    String firstName = getRandomString(10);
    String lastName = getRandomString(10);
    String email = getRandomEmail();
    @Test
    void successfulTest() {

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
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
                .checkResult("Student Email", email)
                .checkResult("Date of Birth", "30 July,2008");
    }
}
