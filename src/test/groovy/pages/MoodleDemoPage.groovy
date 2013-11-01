package pages

import geb.Page

class MoodleDemoPage extends Page{
	static url = "http://demo.moodle.net/"
	static at = {title == "Moodle sandbox"}
}
