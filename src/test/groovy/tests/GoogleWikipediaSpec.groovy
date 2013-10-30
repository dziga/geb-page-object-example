package tests
/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import geb.spock.GebReportingSpec
import pages.GoogleHomePage
import pages.GoogleResultsPage
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
        given:
        searchField = "wikipedia"
        
        and:
        waitFor { searchButton.displayed }
        
        when:
        searchButton.click()
        
        then:
        at GoogleResultsPage
    }
    
    def "the first result should be wikipedia"() {
        given:
        def firstLink = $("li.g", 0).find("a.l")
        
        expect:
        firstLink.text() == "Wikipedia"
        
        when:
        firstLink.click()
        
        then:
        waitFor { title == "Wikipedia, the free encyclopedia" }
    }
    
}