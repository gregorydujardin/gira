package gira


import grails.testing.mixin.integration.Integration
import grails.transaction.*
import org.springframework.dao.DuplicateKeyException
import spock.lang.*

@Integration
@Rollback
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test unique login"() {

        when:
            User user1 = Fixtures.buildUser([login: 'test'])
            boolean duplicate = false
            try {
                User user2 = Fixtures.buildUser([login: 'test'])
            } catch (DuplicateKeyException e) {
                duplicate = true
            }

        then:
            duplicate == true
    }
}
