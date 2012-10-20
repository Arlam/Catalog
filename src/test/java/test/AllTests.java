package test;

import my.catalog.model.ModelFactoryTests;
import my.catalog.service.DataLoaderTests;
import my.catalog.swing.adapter.FilmsTableModelTests;
import my.catalog.utils.UtilityTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DataLoaderTests.class, FilmsTableModelTests.class,
		UtilityTests.class, ModelFactoryTests.class })
public class AllTests {

}
