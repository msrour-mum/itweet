package mum.itweet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.itweet.model.Course;
import mum.itweet.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public Course create(Course course) {
		return courseRepo.save(course);
	}

	@Override
	public Course get(long id) {
		return courseRepo.findById(id).get();
	}

	@Override
	public Course update(Course course) {
		return courseRepo.save(course);
	}

	@Override
	public void delete(long id) {
		courseRepo.deleteById(id);
	}

	@Override
	public List<Course> findAllByName(String name) {
		return courseRepo.findByNameContaining(name);
	}

	@Override
	public List<Course> getAll() {
		return (List<Course>) courseRepo.findAll();
	}

}
