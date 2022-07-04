package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    SelenideElement firstNameInput = $("#firstName"),
    lastNameInput =  $("#lastName");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this; //те возвращаает объект типа RegistrationFormPage (сам сабя)
    }
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage clearFirstName() {
        firstNameInput.clear();
        return this;
    }
    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setFullName(String firstName, String lastName) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        return this;
    }
    public RegistrationFormPage setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }
    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setDateOfBirthWhithKeys (String day, String month, String year) {
        $("#dateOfBirthInput").sendKeys(day + " " + month + " " + year);
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);
        return this;
    }



}
