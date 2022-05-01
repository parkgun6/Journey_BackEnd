package org.geon.journey.service;

import lombok.extern.log4j.Log4j2;
import org.geon.journey.board.entity.Board;
import org.geon.journey.board.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    BoardService service;

    @Test
    public void getOne() {
        log.info(service.readTextWithImg(498L));
    }

    @Test
    public void getList() {
        service.getListPage(0).forEach(res -> log.info(res));
    }


    @Test
    public void update() {
        Board board = Board.builder()
                .bno(2L)
                .text("HelloWorld...수정됨")
                .build();
    }

    @Test
    public void delete(){
        Long bno = 1L;
        service.deleteText(bno);
    }
}
