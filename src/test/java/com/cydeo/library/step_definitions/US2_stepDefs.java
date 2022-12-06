package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.DashBoardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class US2_stepDefs {

    String actualBorrowedBooksNumber;
    LoginPage loginPage =new LoginPage();
    DashBoardPage dashBoardPage =new DashBoardPage();

    @Given("user login as a librarian")
    public void user_login_as_a_librarian() {
     loginPage.login("librarian");
     //I created login with if case and also parameterized
    }

    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
        actualBorrowedBooksNumber = dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBooksNumber = " + actualBorrowedBooksNumber);
    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        //Run Query
        DB_Util.runQuery("select count(*) from book_borrow\n" +
                " where is_returned=0");

        //Store Data
        String expectedBorrowedBooksNumber = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedBorrowedBooksNumber = " + expectedBorrowedBooksNumber);

        //Compare
        Assert.assertEquals(expectedBorrowedBooksNumber,actualBorrowedBooksNumber);

    }

}
