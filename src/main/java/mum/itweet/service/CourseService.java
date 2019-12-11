package mum.itweet.service;

import java.util.List;

import mum.itweet.model.Course;

public interface CourseService {

	public Course create(Course course);

	public Course get(long id);

	public Course update(Course course);

	public void delete(long id);

	public List<Course> findAllByName(String name);

	public List<Course> getAll();
}
