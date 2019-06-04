package gira

import grails.util.Environment
import io.codearte.jfairy.Fairy
import io.codearte.jfairy.producer.DateProducer
import io.codearte.jfairy.producer.person.Person
import org.joda.time.DateTime

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

                for (int j = 0; j < 3; j++) {
                    UserStory userStory = new UserStory(
                            title: "User Story ${i*100+j}",
                            description: fairy.textProducer().sentence(),
                            createdBy: user
                    )
                    userStory.save()

                }
            }

            List<UserStory> listeUserStory = UserStory.list()
            int nbUser = User.count()
            int offset = 0
            listeUserStory.each { UserStory userStory ->
                Collection<User> listeUser = User.list(max: 3, offset: offset)
                listeUser.each { User user ->
                    userStory.addToFollowers(user)
                }
                userStory.save()
                offset += 3
                offset = (offset > nbUser ? 0 : offset)
            }

            listeUserStory = UserStory.list()
            nbUser = User.count()
            offset = 0

            DateProducer dateProducer = fairy.dateProducer()

            listeUserStory.eachWithIndex { UserStory userStory, int i->
                Collection<User> listeUser = User.list(max: 5, offset: offset)
                listeUser.eachWithIndex { User user, int j ->
                    DateTime dateTime = dateProducer.randomDateBetweenYears(1990, 2019)
                    Date date = dateTime.toDate()
                    Comment comment = new Comment(
                            description: fairy.textProducer().sentence(),
                            createdBy: user
                    )
                    comment.dateCreated = date
                    userStory.addToComments(comment)
                }
                userStory.save()
                offset += 5
                offset = (offset > nbUser ? 0 : offset)
            }
        }
    }
    def destroy = {
    }
}
