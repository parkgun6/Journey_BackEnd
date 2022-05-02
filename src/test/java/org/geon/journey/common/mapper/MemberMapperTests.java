package org.geon.journey.common.mapper;

import lombok.extern.log4j.Log4j2;
import org.geon.journey.common.entity.Member;
import org.geon.journey.common.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MemberMapperTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MemberMapper mapper;

    @Test
    public void insertMembers() {
        IntStream.rangeClosed(1,100).forEach(i -> {
            Member member = Member.builder()
                    .email("user"+i+"@journey.com")
                    .name("user"+i)
                    .password(passwordEncoder.encode("1234"))
                    .build();
            mapper.registMember(member);
        });
    }

    @Test
    public void selectMember() {
        Optional<Member> result = mapper.findByEmail("user100@journey.com",false);

        Member member = result.get();
        log.info(member.getRoleSet());
        log.info(member.getRole());
    }
}