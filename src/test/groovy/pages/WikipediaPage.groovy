package pages

import geb.Page

class WikipediaPage extends Page {
	static url = "http://www.wikipedia.org"
	static at = { waitFor { title == "Wikipedia, the free encyclopedia" } }
}
