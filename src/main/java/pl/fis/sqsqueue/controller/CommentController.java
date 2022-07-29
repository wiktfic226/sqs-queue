package pl.fis.sqsqueue.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fis.sqsqueue.enums.CommentMessage;

@RestController
@RequestMapping(path = "/comment")
@RequiredArgsConstructor
public class CommentController {

    private final StreamBridge streamBridge;

    @PostMapping
    public ResponseEntity<String> createComment() {
        streamBridge.send("commentCreated-out-0", CommentMessage.COMMENT_CREATED);
        return ResponseEntity.ok().body(CommentMessage.COMMENT_CREATED.name());
    }

    @PutMapping
    public ResponseEntity<String> updateComment() {
        streamBridge.send("commentUpdated-out-0", CommentMessage.COMMENT_UPDATED);
        return ResponseEntity.ok().body(CommentMessage.COMMENT_UPDATED.name());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteComment() {
        streamBridge.send("commentDeleted-out-0", CommentMessage.COMMENT_DELETED);
        return ResponseEntity.ok().body(CommentMessage.COMMENT_DELETED.name());
    }
}
