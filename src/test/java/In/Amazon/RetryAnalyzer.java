package In.Amazon;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryAnalyzer implements IRetryAnalyzer {

	public boolean retry(ITestResult result) {
		System.out.println(result.getTestName());
	int	i = 1, j = 3;
		if (i<j) {
			i++;
			return true;
			
		}
		return false;
	}

}
