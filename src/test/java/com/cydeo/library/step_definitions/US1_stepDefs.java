package com.cydeo.library.step_definitions;

import com.cydeo.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.HashSet;
import java.util.List;



public class US1_stepDefs {

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        DB_Util.createConnection();
    }
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        String query ="select id  from users";
        DB_Util.runQuery(query);

    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        List<String> expectedIDList = DB_Util.getColumnDataAsList(1);
        HashSet<String> actualIDList = new HashSet<>(expectedIDList);
        //for remove the duplicates

        Assert.assertEquals(expectedIDList.size(), actualIDList.size());
        System.out.println(expectedIDList.size());
        System.out.println(actualIDList.size());
    }
    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        String query ="SELECT * FROM users WHERE 1=0";
        DB_Util.runQuery(query);
    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(io.cucumber.datatable.DataTable expected) {
        List<String> actual = DB_Util.getAllColumnNamesAsList();

        Assert.assertEquals(expected.asList(),actual);
        System.out.println(expected.asList());
        System.out.println(actual);

    }


}