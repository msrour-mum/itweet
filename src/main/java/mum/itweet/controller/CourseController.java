package mum.itweet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mum.itweet.model.Course;
import mum.itweet.service.CourseService;

@RestController
@RequestMapping(value = "/api/course")
public class CourseController {

	@Autowired
	CourseService courseService;

	@PostMapping(value = "/add")
	public Course postCourse(@RequestBody Course course) {
		try {
			return courseService.create(course);
		} catch (DataIntegrityViolationException e) {
			System.out.println("Course already exist!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@PutMapping(value = "/update")
	public Course updateCourse(@RequestBody Course course) {
		try {
			return courseService.create(course);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@GetMapping(value = "/get")
	public List<Course> getAllCourses() {
		try {
			return courseService.getAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@GetMapping(value = "/get/{id}")
	public Course getCourse(@PathVariable("id") long id) {
		try {
			return courseService.get(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteCourse(@PathVariable("id") long id) {
		try {
			courseService.delete(id);
			return "success";
		} catch (Exception e) {
			return "failed";
		}
	}

	@GetMapping(value = "/search/{name}")
	public List<Course> getCoursesByName(@PathVariable("name") String name) {
		try {
			return courseService.findAllByName(name);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
