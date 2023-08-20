package example.redis.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PersonRedisRepositoryTest {

    @Autowired
    PersonRedisRepository personRedisRepository;

    @Autowired
    EntityManager em;

    @AfterEach
    void afterEach() {
        personRedisRepository.deleteAll();
    }

    @Test
    @DisplayName("redis save test")
    void saveTest() throws Exception {
        // given
        Person person = Person.builder()
                .firstName("KIM")
                .lastName("DAEHO")
                .age(32)
                .address("Seoul")
                .build();

        // when
        Person savedPerson = personRedisRepository.save(person);
        System.out.println("savedPerson.getId() = " + savedPerson.getId());

        // then
        em.clear();
        Person findPerson = personRedisRepository.findById(savedPerson.getId()).get();
        Assertions.assertThat(findPerson).isNotNull()
                .extracting("firstName", "lastName", "age", "address")
                .containsExactly("KIM", "DAEHO", 32, "Seoul");

    }

}