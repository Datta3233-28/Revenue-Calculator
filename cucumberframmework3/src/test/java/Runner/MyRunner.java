package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resourcess/features",
                 glue= {"stepdefinations","hooks"},
                 //tags="@Smoke",
                publish = true,
                 plugin={"pretty","html:target/CucumberReports/CucumberReports.html"}
                 )
public class MyRunner {

}
