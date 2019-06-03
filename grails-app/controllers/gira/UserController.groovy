package gira


import grails.rest.*
import grails.converters.*

class UserController extends RestfulController {

    UserService userService

    static responseFormats = ['json', 'xml']
    UserController() {
        super(User)
    }

    def hello() {
        User user = userService.get(params)
        render "Hello ${user.fullname}"
    }
}
