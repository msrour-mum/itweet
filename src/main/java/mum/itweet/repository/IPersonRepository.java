package mum.itweet.repository;

import mum.itweet.model.Person;
import org.springframework.data.repository.CrudRepository;

public  interface IPersonRepository extends CrudRepository<Person, Long> {

}
