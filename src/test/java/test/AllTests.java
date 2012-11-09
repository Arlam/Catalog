package test;

import my.catalog.comparators.NameComparatorTests;
import my.catalog.comparators.YearComparatorTests;
import my.catalog.model.ModelFactoryTests;
import my.catalog.utils.UtilityTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UtilityTests.class, ModelFactoryTests.class,
		NameComparatorTests.class, YearComparatorTests.class })
public class AllTests {

}
