package org.geon.journey.mapper;

import lombok.extern.log4j.Log4j2;
import org.geon.journey.board.entity.Board;
import org.geon.journey.board.mapper.ImageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ImageMapperTests {

    @Autowired
    ImageMapper mapper;

    @Test
    public void getImageList(){
        Long bno = 5L;
        log.info(mapper.getImageList(bno));
    }

    @Test
    public void delete(){
        Long ino = 1L;
        log.info(mapper.deleteImage(ino));
    }

    @Test
    public void deleteByBno(){
        Long bno = 3L;
        log.info(mapper.deleteImageByBno(bno));
    }
}
