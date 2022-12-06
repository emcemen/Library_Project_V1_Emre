package com.cydeo.library.step_definitions;

import com.cydeo.library.utility.ConfigurationReader;
import com.cydeo.library.utility.DB_Util;
import com.cydeo.library.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){

        System.out.println("this is coming from BEFORE");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("libraryApp.url"));

    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("this is coming from AFTER");

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }

    @Before("@db")
    public void setupDB(){
        DB_Util.createConnection();
        System.out.println("Connecting to Database");
    }

    @After("@db")

    public void destroyDB(){
        DB_Util.destroy();
        System.out.println("Closing Connection");
    }
}

