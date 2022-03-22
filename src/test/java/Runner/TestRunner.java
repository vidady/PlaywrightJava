package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features"
        ,glue={"steps"}
        ,plugin ={"pretty","junit:target/report/Cucumber.xml","json:target/report/cucumber.json","html:target/report/report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class TestRunner {

}
