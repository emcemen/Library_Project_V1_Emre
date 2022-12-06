package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BookPage;
import com.cydeo.library.pages.DashBoardPage;
import com.cydeo.library.utility.BrowserUtil;
import com.cydeo.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US3_stepDefs {


    BookPage bookPage =new BookPage();
    List<String> UICategoryList;
    List<String> DBCategoryList;

    @When("user navigate to {string} page")
    public void user_navigate_to_page(String module) {
     new DashBoardPage().navigateModule(module);
    }
    @When("user take all book categories in UI")
    public void user_take_all_book_categories_in_ui() {
        UICategoryList = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        UICategoryList.remove(0);
        System.out.println("actualCategoryList--->use for assert = " + UICategoryList);
    }
    @When("user execute query to get book categories")
    public void user_execute_query_to_get_book_categories() {
        String query = "select name from book_categories";
        DB_Util.runQuery(query);
        List<String> DBCategoryList= DB_Util.getColumnDataAsList(1);
        System.out.println("expectedCategoryList--->use for assert  = " + DBCategoryList);

    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
       Assert.assertEquals(DBCategoryList,UICategoryList);
       //VERIFICATION PART FAILING  CHECK IT!!!!
    }

}
