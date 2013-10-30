package tests

import static org.junit.Assert.*
import geb.spock.GebSpec
import pages.EmailValidationPage
import spock.lang.*

@Stepwise
class EmailValidationSpec extends GebSpec {
	
	def "go to email validation page"() {
		when:
		to EmailValidationPage
		
		then:
		at EmailValidationPage
	}
	
	def "validate '#email'" () {
		when:
		email_field = email
		
		then:
		error_message_is "Must be a valid email address!"
		
		where:
		 email  << ["dawda@.", "dada@"]
	}
}