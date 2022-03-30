package steps;

import base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.PropertyInitialization;


public class Hooks {


    @BeforeAll
    public static void before_all(){
        PropertyInitialization.initProperties();
    }


    @After
    public void afterStepActions(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] buffer = BasePage.getPage().screenshot();
            scenario.attach(buffer,"image/png", scenario.getName());

        }
    }




    }
