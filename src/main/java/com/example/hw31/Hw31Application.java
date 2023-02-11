package com.example.hw31;

import com.example.hw31.dto.UserDto;
import com.example.hw31.model.UserRole;
import com.example.hw31.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class Hw31Application {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Hw31Application.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        if(!userService.hasUserByName("admin@admin")) {
            userService.createUser(
                    new UserDto(null, "admin@admin", "1q2w3e4r", UserRole.ADMIN));
        }
    }
}
