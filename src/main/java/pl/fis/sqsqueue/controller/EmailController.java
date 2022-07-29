package pl.fis.sqsqueue.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fis.sqsqueue.enums.EmailMessage;

@RestController
@RequestMapping(path = "/emailToUser")
@RequiredArgsConstructor
public class EmailController {
    private final StreamBridge streamBridge;
    @PostMapping
    public ResponseEntity<String> sendEmailToUser() {
        streamBridge.send("sendEmailToUser-out-0", EmailMessage.SEND_EMAIL_TO_USER);
        return ResponseEntity.ok().body(EmailMessage.SEND_EMAIL_TO_USER.name());
    }
}
