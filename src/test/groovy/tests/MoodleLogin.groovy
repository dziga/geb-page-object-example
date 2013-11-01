package tests

import com.gargoylesoftware.htmlunit.html.SubmittableElement;

import geb.spock.GebSpec
import pages.MoodleDemoLoginPage
import pages.MoodleDemoPage;

class MoodleLogin extends GebSpec {
	def "page chaining"(){
		given:
		to MoodleDemoLoginPage
		at MoodleDemoLoginPage
		
		when:
		login_with("student", "sandbox")
		
		then:
		at MoodleDemoPage
	}
	
}
