package org.geon.journey.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.geon.journey.common.entity.Reply;

import java.util.List;

@Mapper
public interface ReplyMapper {

    void insertReply(Reply reply);

    List<Reply> getReplys(@Param("page") int page);
}
