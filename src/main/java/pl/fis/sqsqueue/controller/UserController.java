package pl.fis.sqsqueue.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fis.sqsqueue.enums.UserMessage;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final StreamBridge streamBridge;

    @PostMapping
    public ResponseEntity<String> createUser() {
        streamBridge.send("userCreated-out-0", UserMessage.USER_CREATED);
        return ResponseEntity.ok().body(UserMessage.USER_CREATED.name());
    }
}
