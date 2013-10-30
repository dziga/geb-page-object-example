package pages

import geb.Page

class EmailValidationPage extends Page {
	static url = "http://livevalidation.com/examples"
	static at = {title.contains("LiveValidation")}
	static content = {
		email_field {$("#f20")}
		validation_message {$("span[class*='LV_validation_message']").text()}
	}
	
	boolean error_message_is(String message) {
		validation_message == message
	}
	
}
