package gira

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class UserControllerSpec extends Specification implements ControllerUnitTest<UserController> {

    def setup() {
        Fixtures.buildUser()
    }

    def cleanup() {
    }

    void "test something"() {
        when:
            controller.params.id = 1
            controller.hello()
        then:
            response.text.contains('Hello')
    }
}