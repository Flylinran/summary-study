package me.demo;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

/**
 * author: Flyli
 * date: 2017/7/24
 * description:
 */
@Slf4j
public class Main {
    public static void main(String[] args) throws IOException {
        User u1 = User.instance("huzunrong", "123456", 22);
        log.info("u1 -> {}", u1);

        User u2 = User.instance();
        u2.setAge(20);
        String salt = "1";
        u2.salt(salt);
        log.info("u2 -> {}", u2);

        User.UserBuilder u3 = User.builder()
                .age(12)
                .name("aaa")
                .password("12312");
        log.info("u3 -> {}", u3);

        @Cleanup InputStream is = new ByteInputStream("hello".getBytes(), 5);
        log.info("is.available -> {}", is.available());

        log.trace("This is trace message.");
        log.debug("This is debug message.");
        log.info("This is info message.");
        log.error("This is error message.");

    }
}
