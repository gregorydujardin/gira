package gira

class User {

    String login

    String fullname

    String email

    static constraints = {
        login       nullable: false, blank: false
        fullname    nullable: false, blank: false
        email       nullable: false, email: true
    }
}
