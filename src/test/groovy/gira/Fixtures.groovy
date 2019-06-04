package gira

class Fixtures {

    static User buildUser(Map params = [:], boolean toSave = true) {
        User user = new User(
                login: params.login ?: "userLogin",
                fullname: params.fullname ?: "userFullname",
                email: params.email ?: "userEmail@psud.nc"
        )

        if (toSave)
            user.save()

        return user
    }

    static UserStory buildUserStory(Map params = [:], boolean toSave = true) {
        User createdBy = params.createdBy ?: buildUser()
        User assignedTo = params.assignedTo ?: buildUser()
        UserStory userStory = new UserStory(
                title: params.title ?: "title",
                description: params.description ?: "Description de la User Story",
                createdBy: createdBy,
                assignedTo: assignedTo,
                storyPoints: params.storyPoints ?: 1,
                workflowState: params.workflowState ?: WorkflowState.NEW
        )

        if (toSave)
            userStory.save()

        return userStory
    }

    static Comment buildComment(Map params = [:], boolean toSave = true) {
        User createdBy = params.createdBy ?: buildUser()
        UserStory userStory = params.userStory ?: buildUserStory()
        Comment comment = new Comment(
                userStory: userStory,
                description: params.description ?: "Description de la User Story",
                createdBy: createdBy,
                dateCreated: params.dateCreated ?: new Date()
        )
        comment.dateCreated = new Date()

        if (toSave)
            comment.save()

        return comment
    }
}
