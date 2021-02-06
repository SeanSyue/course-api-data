package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    // See https://spring.io/guides/gs/accessing-data-mysql/
    @RequestMapping("/topics")
    public Iterable<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }
//    public Optional<Topic> getTopic(@PathVariable String id) {
//        return topicService.getTopic(id);
//    }

    @PostMapping(value = "/topics")
    public Topic addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
        return topic;
    }

    @PutMapping(value = "topics/{id}")
    public Topic updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        topicService.updateTopic(topic);
        return topic;
    }

    @DeleteMapping(value = "/topics/{id}")
    public String deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
        return id;
    }


}