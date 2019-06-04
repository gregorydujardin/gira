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

    def requete1() {
        respond UserStory.executeQuery("""
             select u from UserStory us join us.followers u group by u having count(us) > 8 
             """)
    }

    def requete2() {
        respond UserStory.executeQuery("""
             select us.storyPoints from UserStory us join us.assignedTo u where u.login = :login and us.workflowState in (:listeState) 
             """,
                [
                        login: params.id,
                        listeState: [WorkflowState.NEW , WorkflowState.IN_PROGRESS, WorkflowState.TO_TEST]
                ]
            )
    }

    def requete3() {
        respond UserStory.executeQuery("""
             select u from UserStory us join us.followers u group by u having count(us) > 1 
             """)
    }
}
