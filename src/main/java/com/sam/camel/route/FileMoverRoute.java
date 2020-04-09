package com.sam.camel.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileMoverRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("{{fromRoute}}")
                .routeId("FileMoverRoute")
//                .log(LoggingLevel.INFO, "${body}")
                .process(new FileProcessor())

                .log("Count" + "${header.Count}++")
                .to("mock:end")
                .end()
                .log("Count " +"${header.Count}++")
            ;
    }
}
