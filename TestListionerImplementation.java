package GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListionerImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String MethodName= result.getMethod().getMethodName();
		test=report.createTest(MethodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName= result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"------>passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String path ="";
		String MethodName = result.getMethod().getMethodName()+"-";
		Reporter.log(MethodName+ "---TestScript Failed---",true);
		
		//Step 1: Configure screenshot name
		String screenshotName = MethodName+new JavaUtility().getSystemDateInFormate();
		System.out.println(screenshotName);
		
		//Step 2 : using screenshot method from webdriver utility
		try {
			path= new WebDriverUtility().getScreenshot(BaseClass.sdriver, screenshotName);
		}catch (Throwable e) {
			//ToDo Auto Generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL,MethodName+"---->Failed");
		//it will capture the exception and log it in the report
		test.addScreenCaptureFromPath(path);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,MethodName+"------>Skiped");
		//it will capture the exception and log it in the report
		test.log(Status.SKIP,result.getThrowable());
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {


	}

	@Override
	public void onStart(ITestContext context) {
		//Execution will start here
		//Configure the report
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/Reports"+new JavaUtility().getSystemDateInFormate()+".html");
				htmlReport.config().setDocumentTitle("Execution Report");
				htmlReport.config().setTheme(Theme.DARK);
				htmlReport.config().setReportName("Selenium Execution Report");
				
				report=new ExtentReports();
				report.attachReporter(htmlReport);
				report.setSystemInfo("Base-Browser", "chrome");
				report.setSystemInfo("OS", "windows");
				report.setSystemInfo("base-url","https://www.amazon.in/");
				report.setSystemInfo("ReportName", "Raghuveer");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		//consolidate all the parameter and generate the report
		report.flush();
	}
	
}

