package example.redis.controller;

import example.redis.domain.PersonRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonRedisRepository personRedisRepository;

    @CacheEvict(cacheNames = "person", key = "'name:' + #personDto.firstName")
    @PostMapping("/person/save")
    public String savePerson(@RequestBody PersonDto personDto) {
        personRedisRepository.save(personDto.toEntity());
        return "OK";
    }

    @Cacheable(key = "'name:' + #firstName", cacheNames = "person")
    @GetMapping("/persons/{firstName}")
    public List<PersonDto> findPerson(@PathVariable String firstName) {
        return personRedisRepository.findByFirstName(firstName)
                .stream().map(p -> PersonDto.of(p))
                .collect(Collectors.toList());
    }

    @Cacheable(key = "'name:' + #firstName + ':' + #lastName", cacheNames = "person")
    @GetMapping("/persons/{firstName}/{lastName}")
    public List<PersonDto> findPersonByFullName(@PathVariable String firstName, @PathVariable String lastName) {
        return personRedisRepository.findByFirstNameAndLastName(firstName, lastName)
                .stream().map(p -> PersonDto.of(p))
                .collect(Collectors.toList());
    }
}
