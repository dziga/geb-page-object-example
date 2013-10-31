package tests

import geb.spock.GebReportingSpec
import pages.GoogleHomePage
import pages.GoogleResultsPage
import pages.WikipediaPage
import spock.lang.Stepwise

@Stepwise
class GoogleWikipediaSpec extends GebReportingSpec {
    
    def "go to google"() {
        when:
        to GoogleHomePage
        
        then:
        at GoogleHomePage
    }
    
    def "search for wikipedia"() {
        when:
        search "wikipedia"
        
        then:
        at GoogleResultsPage
    }
    
    def "the first result should be wikipedia"() {
        given:
        at GoogleResultsPage
        
        expect:
        resultLink(0).text() == "Wikipedia"
        
        when:
        resultLink(0).click()
        
        then:
        at WikipediaPage
    }
    
}