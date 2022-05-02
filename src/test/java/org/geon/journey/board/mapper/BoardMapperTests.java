package org.geon.journey.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.geon.journey.board.entity.Board;
import org.geon.journey.board.mapper.BoardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardMapperTests {

    @Autowired
    BoardMapper mapper;

    @Test
    public void timeNow() {
        log.info(mapper.getTime());
    }

    @Test
    public void getOne() {
        log.info(mapper.getTextWithImg(498L));
    }

    @Test
    public void getList() {
        mapper.getList(0).forEach(res -> log.info(res));
    }

    @Test
    public void insertBoard() {
        IntStream.rangeClosed(1, 200).forEach(i -> {
            Board board = Board.builder()
                    .text("HelloWorld" + i)
                    .build();
            mapper.insertBoard(board);
        });
    }

    @Test
    public void update() {
        Board board = Board.builder()
                .bno(2L)
                .text("HelloWorld...수정됨")
                .build();
        mapper.modifyText(board);
    }

    @Test
    public void delete(){
        Long bno = 1L;
        log.info(mapper.delete(bno));
    }
}
