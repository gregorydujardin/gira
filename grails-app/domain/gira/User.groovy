package gira

class User {

    String login

    String fullname

    String email

    static mapping = {
        version     false
    }

    static constraints = {
        id          name: 'login', generator: 'assigned'
        login       nullable: false, blank: false, unique: true
        fullname    nullable: false, blank: false
        email       nullable: false, email: true
    }
}
