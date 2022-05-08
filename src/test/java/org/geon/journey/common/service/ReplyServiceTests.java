package org.geon.journey.common.service;

import lombok.extern.log4j.Log4j2;
import org.geon.journey.common.dto.ReplyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class ReplyServiceTests {

    @Autowired
    ReplyService service;

    @Test
    public void getReplys() {
        List<ReplyDTO> replys = service.getReplys(1);
        replys.forEach(res -> log.info(res));
    }
}
