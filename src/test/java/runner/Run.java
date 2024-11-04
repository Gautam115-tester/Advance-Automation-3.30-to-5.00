package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/home/lab-01-09/Workspace/Advance Demo/Automation3.30to5.00/Features",
glue = "/home/lab-01-09/Workspace/Advance Demo/Automation3.30to5.00/src/test/java/cucumberExecutionCode",
dryRun = true , monochrome = true

		)

public class Run {

}
