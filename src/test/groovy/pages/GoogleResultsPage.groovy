package pages

import geb.Page

class GoogleResultsPage extends Page {
	static at = { waitFor { title.endsWith("Google Search") } }
	static content = {
		results(wait: true) { $("li.g") }
		result { index -> results[index] }
		resultLink { index -> result(index).find("a.l") }
	}
}
