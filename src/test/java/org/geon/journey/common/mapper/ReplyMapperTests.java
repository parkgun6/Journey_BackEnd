package org.geon.journey.common.mapper;

import lombok.extern.log4j.Log4j2;
import org.geon.journey.common.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.LongStream;

@SpringBootTest
@Log4j2
public class ReplyMapperTests {

    @Autowired
    ReplyMapper mapper;

    @Test
    public void insertReply() {
        LongStream.rangeClosed(1,10).forEach(i -> {
            Reply reply = Reply.builder()
                    .bno(498L)
                    .email("user1@journey.com")
                    .reply("test..." + i)
                    .build();
            mapper.insertReply(reply);
        });
    }
}