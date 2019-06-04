package gira


import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class UserStorySpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test Comments ordered"() {
        when:
        User user = Fixtures.buildUser([login: 'testcomment'])
        UserStory userStory = Fixtures.buildUserStory([createdBy: user, assignedTo: user])
        Comment comment1 = Fixtures.buildComment([description: 'Comment1', userStory: userStory, createdBy: user])
        Thread.sleep(3000)
        Comment comment2 = Fixtures.buildComment([description: 'Comment2', userStory: userStory, createdBy: user])
        userStory.addToComments(comment1)
        userStory.addToComments(comment2)
        userStory.save()
        then:
        userStory.comments[0].description == 'Comment2'
        userStory.comments[1].description == 'Comment1'
    }
}
