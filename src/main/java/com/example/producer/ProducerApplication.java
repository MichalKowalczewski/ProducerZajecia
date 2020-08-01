package com.example.producer;

import com.example.producer.model.Task;
import com.example.producer.model.User;
import com.example.producer.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Component
    @Order(0)
    class MyApplicationListener implements ApplicationListener<ApplicationReadyEvent>{

        @Autowired
        TaskRepository repository;

        @Override
        public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
            repository.save(new Task("test", true, null, null));
            repository.save(new Task("test2", false, 20, new User("Jan", "Kowalski", "jk@wp.pl")));
        }
    }
}
