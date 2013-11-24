package pages;

import geb.Page;

class TomTomCreateAccountPage extends Page {
	static url = "https://www.tomtom.com/en_us/mytomtom/createaccount/?callback=https://www.tomtom.com/en_us/"
    static at = {title=="My TomTom"}
	static content = {
		email {$("input[tabindex='1']")}
		password {$("input[tabindex='2']")}
		passwordConfirm {$("input[tabindex='3']")}
		firstName {$("input[tabindex='7']")}
		lastName {$("input[tabindex='8']")}
		country {$("select[tabindex='9']")}
		createButton {$("div[tabindex='13']")}
	}
	
	void fill_in_form_with(email, password, passwordConfirm, firstName, lastName, country) {
		this.email = email
		this.password = password
		this.passwordConfirm = passwordConfirm
		this.firstName = firstName
		this.lastName = lastName 
		this.country = country 
	}
	
	void submit_the_form() {
		this.createButton.click()
	}
	
	boolean email_field_is_red() {
		email.hasClass("textBox-editable-fault")
	}
	
	boolean password_field_is_red() {
		password.hasClass("textBox-editable-fault")
	}
	
	boolean confirm_password_field_is_red() {
		passwordConfirm.hasClass("textBox-editable-fault")
	}
	
	boolean first_name_field_is_red() {
		firstName.hasClass("textBox-editable-fault")
	}
	
	boolean last_name_field_is_red() {
		lastName.hasClass("textBox-editable-fault")
	}
	
	boolean country_field_is_red() {
		country.parent().hasClass("gwt-LabeledListBox-wrapper-fault")
	}
}
