package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    // See https://spring.io/guides/gs/accessing-data-mysql/
    public Iterable<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    // see comments in https://youtu.be/lpcOSXWPXTk
    public Topic getTopic(String id) {
        return topicRepository.findById(id).orElse(null);
    }
//    public Optional<Topic> getTopic(String id) {
//        return topicRepository.findById(id);
//    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}