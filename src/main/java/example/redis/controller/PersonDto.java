package example.redis.controller;

import example.redis.domain.Person;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Getter
@Setter
public class PersonDto implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String address;

    @Builder
    public PersonDto(String id, String firstName, String lastName, int age, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public static PersonDto of(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .age(person.getAge())
                .address(person.getAddress())
                .build();
    }

    public Person toEntity() {
        return Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .address(address)
                .build();

    }
}
