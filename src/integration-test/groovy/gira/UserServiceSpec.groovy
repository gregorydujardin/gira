package gira


import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class UserServiceSpec extends Specification {

    UserService userService

    def setup() {
    }

    def cleanup() {
    }

    void "test get method"() {
        when:
            User user = userService.get([id: 1])

        then:
            user.id == 1
    }
}
