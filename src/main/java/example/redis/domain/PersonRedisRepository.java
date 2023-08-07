package example.redis.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRedisRepository extends CrudRepository<Person, String> {
}
