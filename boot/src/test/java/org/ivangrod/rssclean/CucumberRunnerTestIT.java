package org.ivangrod.rssclean;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/features"}, glue = {
        "org.ivangrod.rssclean.steps"}, tags = {
        "~@suggester"}, features = "classpath:features", snippets = SnippetType.CAMELCASE)
public class CucumberRunnerTestIT {


}
