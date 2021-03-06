package org.geon.journey.security;

import lombok.extern.log4j.Log4j2;
import org.geon.journey.common.entity.Member;
import org.geon.journey.common.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class PasswordTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void testEncode() {
        String password = "1111";
        String enPw = passwordEncoder.encode(password);

        log.info("enPw: " + enPw);

        boolean matchResult = passwordEncoder.matches(password, enPw);

        log.info("matchResult: " + matchResult);
    }
}