package com.ex_auto.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                  "html:target/default-html-report.html",
                  "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/ex_auto/stepDefs",
        dryRun = false,
        tags = "@ready"
)
public class CukesRunner {
}