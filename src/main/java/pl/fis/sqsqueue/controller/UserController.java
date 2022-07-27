package pl.fis.sqsqueue.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {

    private final StreamBridge streamBridge;

    @PostMapping
    public String createUser() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        streamBridge.send("userCreated-out-0", "USER_CREATED");
        return "User created!";
    }
}
