package PageObject;

import base_class.*;

public class HomePage extends Test_class {
	public void clickOnViewTimesheetLink() {

		getlocator("viewtimesheet").click();
	}

	public String validateViewTimeSheetpage() {
		String Currenturl = driver.getCurrentUrl();
		return Currenturl;

	}

}