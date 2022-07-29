package pl.fis.sqsqueue.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fis.sqsqueue.enums.ArticleMessage;

@RestController
@RequestMapping(path = "/article")
@RequiredArgsConstructor
public class ArticleController {

    private final StreamBridge streamBridge;
    @PostMapping
    public ResponseEntity<String> createArticle() {
        streamBridge.send("articleCreated-out-0", ArticleMessage.ARTICLE_CREATED);
        return ResponseEntity.ok().body(ArticleMessage.ARTICLE_CREATED.name());
    }

    @PutMapping
    public ResponseEntity<String> updateArticle() {
        streamBridge.send("articleUpdated-out-0", ArticleMessage.ARTICLE_UPDATED);
        return ResponseEntity.ok().body(ArticleMessage.ARTICLE_UPDATED.name());
    }
}
