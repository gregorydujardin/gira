package gira

import org.springframework.beans.factory.annotation.Value


class UserInterceptor {

    @Value('${gira.user.time.enabled:false}')
    boolean userTimeEnabled

    boolean before() {
        if (userTimeEnabled)
            request.start = System.currentTimeMillis()
        true
    }

    boolean after() {
        true
    }

    void afterView() {
        if (userTimeEnabled)
            log.info("Total time of User action '${actionName}' : ${System.currentTimeMillis() - request.start} ms")
    }
}
