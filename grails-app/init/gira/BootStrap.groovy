package gira

import grails.util.Environment
import io.codearte.jfairy.Fairy
import io.codearte.jfairy.producer.person.Person

class BootStrap {

    Fairy fairy

    def init = { servletContext ->

        if (Environment.current == Environment.DEVELOPMENT || Environment.current == Environment.TEST) {
            for (int i = 0; i < 20; i++) {
                Person person = fairy.person()
                User user = new User(
                        login: person.username,
                        fullname: "${person.firstName} ${person.lastName}",
                        email: person.email
                )
                user.save()
            }
        }
    }
    def destroy = {
    }
}
