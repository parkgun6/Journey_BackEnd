package org.geon.journey.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.geon.journey.common.entity.Reply;

@Mapper
public interface ReplyMapper {

    void insertReply(Reply reply);
}
