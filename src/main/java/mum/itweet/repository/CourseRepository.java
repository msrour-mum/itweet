package mum.itweet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mum.itweet.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

	public List<Course> findByNameContaining(String name);
}
