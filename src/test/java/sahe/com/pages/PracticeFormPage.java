package sahe.com.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PracticeFormPage extends PageObject {

    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By emailInput = By.id("userEmail");
    private By mobileNumberInput = By.id("userNumber");
    private By currentAddressTextarea = By.id("currentAddress");
    private By submitButton = By.id("submit");
    private By maleGenderLabel = By.cssSelector("label[for='gender-radio-1']");
    private By femaleGenderLabel = By.cssSelector("label[for='gender-radio-2']");
    private By otherGenderLabel = By.cssSelector("label[for='gender-radio-3']");
    private By sportsHobbyLabel = By.cssSelector("label[for='hobbies-checkbox-1']");
    private By readingHobbyLabel = By.cssSelector("label[for='hobbies-checkbox-2']");
    private By musicHobbyLabel = By.cssSelector("label[for='hobbies-checkbox-3']");
    private By modalTitle = By.id("example-modal-sizes-title-lg");
    private By modalBody = By.className("modal-body");

    public void openForm() {
        getDriver().get("https://demoqa.com/automation-practice-form");
        evaluateJavascript("window.scrollBy(0, 300)");
    }

    public void enterFirstName(String firstName) {
        $(firstNameInput).clear();
        $(firstNameInput).type(firstName);
    }

    public void enterLastName(String lastName) {
        $(lastNameInput).clear();
        $(lastNameInput).type(lastName);
    }

    public void enterEmail(String email) {
        $(emailInput).clear();
        $(emailInput).type(email);
    }

    public void enterMobileNumber(String mobileNumber) {
        $(mobileNumberInput).clear();
        $(mobileNumberInput).type(mobileNumber);
    }

    public void enterAddress(String address) {
        $(currentAddressTextarea).clear();
        $(currentAddressTextarea).type(address);
    }

}
