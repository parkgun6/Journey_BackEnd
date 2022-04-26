package org.geon.journey.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.geon.journey.board.entity.Board;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    @Select("SELECT now()")
    String getTime();

    Board read(Long bno);

    List<Map<String,Object>> getList(@Param("page") int page);

    Long insertBoard(Board board);

    Long update(Board board);

    Long delete(Long bno);
}
