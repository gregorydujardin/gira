package gira

class Comment implements Comparable<Comment> {

    String description

    User createdBy

    Date dateCreated

    static belongsTo = [
            userStory: UserStory
    ]

    static constraints = {
        description         nullable: false
        createdBy           nullable: false
        dateCreated         nullable: false
    }

    @Override
    int compareTo(Comment o) {
        return o.dateCreated.compareTo(this.dateCreated)
    }
}
