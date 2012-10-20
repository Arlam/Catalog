package test;

import my.catalog.model.ModelFactoryTests;
import my.catalog.service.DataLoaderTests;
import my.catalog.utils.UtilityTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DataLoaderTests.class, UtilityTests.class,
		ModelFactoryTests.class })
public class AllTests {

}
