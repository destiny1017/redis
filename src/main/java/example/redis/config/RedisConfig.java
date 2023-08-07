package example.redis.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;

//@Getter
//@Configuration
//@EnableRedisRepositories
public class RedisConfig {

//    @Value("${spring.cache.redis.host}")
//    private String host;
//
//    @Value("${spring.cache.redis.port}")
//    private int port;
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory(host, port);
//    }
//
//    /**
//     * RedisConnection에서 넘겨준 byte 값 객체 직렬화
//     */
//    @Bean
//    public RedisTemplate<?,?> redisTemplate(){
//        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory());
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        return redisTemplate;
//    }
}
