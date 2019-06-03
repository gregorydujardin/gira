package gira


import grails.rest.*
import grails.converters.*

class UserController extends RestfulController {
    static responseFormats = ['json', 'xml']
    UserController() {
        super(User)
    }

    def hello() {
        User user = User.findById(params.id)
        render "Hello ${user.fullname}"
    }
}
