package tech.jhipster.sampleapp.cucumber;

import static io.cucumber.junit.platform.engine.Constants.*;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;
import tech.jhipster.sampleapp.ComponentTest;

@Suite(failIfNoTests = false)
@ComponentTest
@IncludeEngines("cucumber")
@SuppressWarnings("java:S2187")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "tech.jhipster.sampleapp")
@ConfigurationParameter(
  key = PLUGIN_PROPERTY_NAME,
  value = "pretty, json:target/cucumber/cucumber.json, html:target/cucumber/cucumber.htm, junit:target/cucumber/TEST-cucumber.xml"
)
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/features")
public class CucumberTest {}
