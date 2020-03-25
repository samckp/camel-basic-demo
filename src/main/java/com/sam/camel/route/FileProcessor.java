package com.sam.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.io.File;

public class FileProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        String file = exchange.getIn().getBody(String.class);
//        byte[] bytes =exchange.getIn().getBody(byte[].class);
        System.out.println(file);   // print the contents of file.
    }
}
