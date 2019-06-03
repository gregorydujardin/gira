package gira

import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class UserServiceUnitSpec extends Specification implements ServiceUnitTest<UserService>, DomainUnitTest<User> {

    def setup() {
        Fixtures.buildUser([login: 'test.login'])
    }

    def cleanup() {
    }

    void "test get method"() {
        when:
            User user = service.get([id: 1])

        then:
            user.id == 1
            user.login == 'test.login'
    }
}
