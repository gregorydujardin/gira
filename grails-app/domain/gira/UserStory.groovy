package gira

class UserStory {

    String title

    String description

    User assignedTo

    User createdBy

    int storyPoints = 0

    WorkflowState workflowState = WorkflowState.NEW

    SortedSet<Comment> comments

    static hasMany = [
            followers: User,
            comments: Comment
    ]
    static constraints = {
        title           nullable: false, blank: false
        description     nullable: false, blank: false
        assignedTo      nullable: true
        createdBy       nullable: false
        storyPoints     nullable: false
        workflowState   nullable: false
    }

    static mapping = {
        followers joinTable: [name: 'USER_STORY_FOLLOWERS']
    }
}
