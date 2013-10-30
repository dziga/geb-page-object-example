package pages

import geb.Page

class WikipediaPage extends Page {
	static at = { waitFor { title == "Wikipedia, the free encyclopedia" } }
}
