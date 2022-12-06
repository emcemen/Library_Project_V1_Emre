package com.cydeo.library.pages;

import com.cydeo.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage {


    @FindBy(id = "borrowed_books")
    public WebElement borrowedBooksNumber;
    // it is used for US2_stepDefs ---->   //*[@id="borrowed_books"]

    @FindBy(id = "user_count")
    public WebElement usersNumber;

    @FindBy(id = "book_count")
    public WebElement booksNumber;



    public String getModuleCount(String module){
        //h6[normalize-space(.)='Users']//..//h2

        String locator="//h6[normalize-space(.)='"+module+"']//..//h2";

        WebElement elementOfModule = Driver.getDriver().findElement(By.xpath(locator));

        return elementOfModule.getText();

        // it is used for US3_stepDefs ---->
    }



}
