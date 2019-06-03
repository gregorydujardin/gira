package gira

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import io.codearte.jfairy.Fairy
import org.springframework.context.annotation.Bean

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    @Bean
    Fairy fairy() {
        Fairy fairy = Fairy.create()
    }
}