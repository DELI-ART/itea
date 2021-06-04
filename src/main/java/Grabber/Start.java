package Grabber;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import Grabber.Service.RequestService;

@ComponentScan
public class Start {
    public static void main(String[] args) throws IOException, InterruptedException {
        ApplicationContext context = SpringApplication.run(Start.class, args);
        context.getBean(RequestService.class).collectData();
    }
}
