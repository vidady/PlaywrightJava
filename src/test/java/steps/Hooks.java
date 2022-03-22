package steps;

import BasePage.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;


public class Hooks {




    @After
    public void afterStepActions(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] buffer = BasePage.getPage().screenshot();
            scenario.attach(buffer,"image/png", scenario.getName());

        }
    }


    }
