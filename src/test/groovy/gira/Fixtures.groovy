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
}
