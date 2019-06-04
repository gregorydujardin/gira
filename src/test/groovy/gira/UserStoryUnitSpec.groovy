package gira

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserStoryUnitSpec extends Specification implements DomainUnitTest<UserStory> {

    def setup() {
    }

    def cleanup() {
    }

    void "test creation UserStory"() {
        when :
            UserStory userStory = Fixtures.buildUserStory([title: "Test"])
            userStory = UserStory.findById(1)
        then:
            userStory.title == "Test"
    }

    void "test update storyPoint"() {
        when:
            UserStory userStory = Fixtures.buildUserStory([storyPoints: 1])
            userStory.storyPoints += 1
            userStory.save()
            userStory = UserStory.findById(1)
        then:
            userStory.storyPoints == 2
    }
}
