package gira

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class UserControllerSpec extends Specification implements ControllerUnitTest<UserController>, DomainUnitTest<User> {

    def setup() {
//        Fixtures.buildUser()
    }

    def cleanup() {
    }

    void "test something"() {
        when:
            UserService userService = Mock(UserService)
            userService.get(_ as Map) >> Fixtures.buildUser([:], false)
            controller.userService = userService
            controller.params.id = 1
            controller.hello()
        then:
            response.text.contains('Hello')
    }
}