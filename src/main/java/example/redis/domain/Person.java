package example.redis.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;



@Getter
@RedisHash
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Person {

    @Id
    private String id;
    @Indexed
    private String firstName;
    private String lastName;
    private int age;
    private String address;

    @Builder
    public Person(String firstName, String lastName, int age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }
}
