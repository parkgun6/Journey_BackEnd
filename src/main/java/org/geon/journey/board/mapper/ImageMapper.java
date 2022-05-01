package org.geon.journey.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.geon.journey.board.entity.Image;

import java.util.List;

@Mapper
public interface ImageMapper {

    Long insertImage(Image image);

    List<Image> getImageList(Long bno);

    Long deleteImageByBno(Long bno);

    Long deleteImage(Long ino);
}
