package gira

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def get(Map params) {
        User user = User.findById(params.id)
        return user
    }
}
