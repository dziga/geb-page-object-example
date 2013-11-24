package tests

import pages.TomTomCreateAccountPage;
import geb.spock.GebSpec

class TomTomCreateAccountValidationSpec extends GebSpec {
	def "email must be valid" () {
		when:
			to TomTomCreateAccountPage
		and:
			fill_in_form_with(email, password, passwordConfirm, firstName, lastName, country)
			submit_the_form()
		then:
			email_field_is_red()
		
		where:
			email << ["jidai@", "dawd@@da"]
			password << ["password", "password"]
			passwordConfirm << ["password", "password"]
			firstName << ["name", "name"]
			lastName << ["surname", "surname"]
			country << ["Angola", "Angola"]
	}
	
	def "passwords should match" () {
		when:
			to TomTomCreateAccountPage
		and:
			fill_in_form_with(email, password, passwordConfirm, firstName, lastName, country)
		then:
			password_field_is_red() || confirm_password_field_is_red()
		
		where:
			email << ["right@right.com", "right@right.com", "right@right.com"]
			password << ["password", "password", ""]
			passwordConfirm << ["password1", "", "password"]
			firstName << ["name", "name", "name"]
			lastName << ["surname", "surname", "surname"]
			country << ["Angola", "Angola", "Angola"]
	}
	
	def "fields should not be empty" () {
		when:
			to TomTomCreateAccountPage
		and:
			fill_in_form_with(email, password, passwordConfirm, firstName, lastName, country)
		then:
			email_field_is_red() || password_field_is_red() || 
			confirm_password_field_is_red() || first_name_field_is_red() ||
			last_name_field_is_red() || country_field_is_red()
		
		where:
			email << ["", "right@right.com", "right@right.com","right@right.com", "right@right.com", "right@right.com"]
			password << ["password", "", "password", "password", "password", "password"]
			passwordConfirm << ["password", "password", "", "password", "password", "password"]
			firstName << ["name", "name", "name", "", "name", "name"]
			lastName << ["surname", "surname", "surname", "surname", "", "surname"]
			country << ["Angola", "Angola", "Angola", "Angola", "Angola", -1]
	}
}
