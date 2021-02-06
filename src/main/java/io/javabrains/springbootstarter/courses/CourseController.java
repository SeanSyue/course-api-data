package io.javabrains.springbootstarter.courses;

import io.javabrains.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourses(id);
    }

    // `id` is the primary key, so we dont' care about `topicId`
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @PostMapping(value = "/topics/{topicId}/courses")
    public Course addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
        return course;
    }

    @PutMapping(value = "topics/{topicId}/courses/{id}")
    public Course updateCourse(@PathVariable String id, @RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
        return course;
    }

    @DeleteMapping(value = "/topics/{topicId}/courses/{id}")
    public String deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
        return id;
    }


}