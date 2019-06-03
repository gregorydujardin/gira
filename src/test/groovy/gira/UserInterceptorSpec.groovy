package gira

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class UserInterceptorSpec extends Specification implements InterceptorUnitTest<UserInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test user interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"user")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }
}
