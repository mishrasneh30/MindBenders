package TaskTest.TaskTest;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.testng.annotations.Test;

public class ReadTestCase {

	@Test
	public void readData() {
		Path currentRelativePath = Paths.get("");
		String basePath = currentRelativePath.toAbsolutePath().toString();
		String testDataFile = basePath + File.separator + "TestCaseData" + File.separator;

		DriverClass.launchDriver("chrome", "https://seller.fedevyespls.in/en/login");

		List<String> steps=ParseExcelRequirement.readColumnDataFromExcel(testDataFile, "TestCases.xlsx", "LoginflowTest", "Steps");
		for (int i = 0; i < steps.size(); i++) {
			System.out.println(steps.get(i).toString());
			
		}
	}
}
