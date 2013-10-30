package pages

import geb.Page

class GoogleHomePage extends Page {
	static url = "http://google.com/ncr"
    static at = { title == "Google" }
    static content = {
        searchField { $("input[name=q]") }
        searchButton { btnG() }
    }
	
	void search(String searchTerm) {
		searchField = searchTerm
		waitFor { searchButton.displayed }
		searchButton.click()
	}
}