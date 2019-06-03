package gira

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class UserSpec extends Specification implements DomainUnitTest<User> {

    def setup() {
    }

    def cleanup() {
    }

    void "creation User"() {
        setup:
            User user = Fixtures.buildUser([login: 'user1', fullname: 'user test1', email: 'user1@psud.nc'])
            user = Fixtures.buildUser([login: 'user2', fullname: 'user test2', email: 'user2@psud.nc'])
        expect:"fix me"
            User.count() == 2
    }

    void "recherche par login"() {
        setup:
            User user = Fixtures.buildUser([login: 'user1', fullname: 'user test1', email: 'user1@psud.nc'])
        when:
            user = User.findByLogin('user1')
        then:
            user.fullname == 'user test1'
            user.email == 'user1@psud.nc'
    }

    void "controle email"() {
        setup:
            User user = Fixtures.buildUser([login: 'user1', fullname: 'user test1', email: 'user1@psud.nc'])
        when:
            user.email = email
        then:
            user.validate(['email']) == valid
            user.errors.getFieldError()?.code == errorCode

        where:
            email           | valid     | errorCode
            null            | false     | "nullable"
            'user1@psud.nc' | true      | null
            'user1'         | false     | "email.invalid"
    }
}
