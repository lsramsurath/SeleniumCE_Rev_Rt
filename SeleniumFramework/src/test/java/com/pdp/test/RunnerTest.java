package com.pdp.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"src/test/resources/features/Rit.feature"},
				 plugin = { 
						    "html:target/cucumber-html-report",
						    "json:target/cucumber.json"
						        },
				 glue ={"com/pdp/test"},strict = true,
				 dryRun= false,monochrome = true, snippets= SnippetType.UNDERSCORE,tags="@run")
//,tags="@run"

public class RunnerTest {
		 

}
