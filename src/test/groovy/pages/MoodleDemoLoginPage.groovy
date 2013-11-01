package pages

import geb.Page

class MoodleDemoLoginPage extends Page{
	static url = "http://demo.moodle.net/login/index.php"
	static at = {title == "Moodle sandbox: Login to the site"}
	static content = {
		firstname {$("#username")}
		lastname {$("#password")}
		button(to:MoodleDemoPage) {$("#loginbtn")}
	}
	
	void login_with(String username, String password) {
		firstname.value("student")
		lastname.value("sandbox")
		button.click()
	}
}
