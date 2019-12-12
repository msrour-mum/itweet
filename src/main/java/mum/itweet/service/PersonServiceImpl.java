package mum.itweet.service;

import mum.itweet.model.Person;
import mum.itweet.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public Person add(Person person) {
        return personRepository.save(person);
    }

}
