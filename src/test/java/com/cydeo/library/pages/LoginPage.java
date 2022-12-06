package com.cydeo.library.pages;

import com.cydeo.library.utility.ConfigurationReader;
import com.cydeo.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "inputEmail")
    public WebElement emailBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(tagName = "button")
    public WebElement loginButton;

    public void login(String userType) {
        if(userType.equalsIgnoreCase("librarian")) {
            String username = ConfigurationReader.getProperty(userType+"_Username");
            String password = ConfigurationReader.getProperty(userType+"_Password");
            System.out.println( userType + "_Username");

            emailBox.sendKeys(username);
            passwordBox.sendKeys(password);
            loginButton.click();
        }
        if(userType.equalsIgnoreCase("student")) {
            String username = ConfigurationReader.getProperty(userType+"_Username");
            String password = ConfigurationReader.getProperty(userType+"_Password");
            System.out.println( userType + "_Username");

            emailBox.sendKeys(username);
            passwordBox.sendKeys(password);
            loginButton.click();
        }

    }


    public void login(String email, String password) {

        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

}

