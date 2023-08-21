package example.redis.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRedisRepository extends CrudRepository<Person, String> {
    List<Person> findByFirstName(String firstName);
    List<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
