package com.sam.camel.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("{{fromRoute}}")
                .routeId("fileMoveRouteId")
                .log(LoggingLevel.INFO, "${body}")
            .to("{{toRoute}}")
         ;

        from("{{timeRoute}}")
                .routeId("timerRoute")
                .setBody(simple("this is test msg ! ------{{message}}"))
                .log(LoggingLevel.INFO, "${body}")
                .to("mock:out");
    }
}
