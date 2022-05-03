package org.geon.journey.common.mapper;

import lombok.extern.log4j.Log4j2;
import org.geon.journey.common.entity.Member;
import org.geon.journey.common.entity.MemberRole;
import org.geon.journey.common.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

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
        IntStream.rangeClosed(1,5).forEach(i -> {
            Member member = Member.builder()
                    .email("user"+i+"@journey.com")
                    .name("user"+i)
                    .password(passwordEncoder.encode("1234"))
                    .build();
            member.addMemberRole(MemberRole.USER);

            if(i > 80){
                member.addMemberRole(MemberRole.MEMBER);
            }

            if(i > 90){
                member.addMemberRole(MemberRole.ADMIN);
            }
            log.info(member.getRoleSet());
            log.info(member.getRoleSet());
            log.info(member.getRoleSet());
            mapper.registMember(member);
//            mapper.registMemberRole(member);
        });
    }

    @Test
    public void selectMember() {
        Optional<Member> result = mapper.findByEmail("user1@journey.com",false);

        log.info(result.get().getEmail());
        log.info(result.get().getRoleSet());
    }
}