package org.geon.journey.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.geon.journey.board.entity.Image;

@Mapper
public interface ImageMapper {

    Image insertImage(Image image);

    Long deleteImageByBno(Long bno);

    Long deleteImage(Long ino);
}
