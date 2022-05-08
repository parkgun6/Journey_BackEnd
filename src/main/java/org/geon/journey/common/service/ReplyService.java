package org.geon.journey.common.service;

import org.geon.journey.common.dto.ReplyDTO;
import org.geon.journey.common.entity.Reply;

import java.util.List;

public interface ReplyService {

    void insertReply(Reply reply);

    List<ReplyDTO> getReplys(int page);

    default ReplyDTO entityToDTO(Reply reply){
        ReplyDTO replyDTO = ReplyDTO.builder()
                .rno(reply.getRno())
                .bno(reply.getBno())
                .email(reply.getEmail())
                .reply(reply.getReply())
                .regDate(reply.getRegDate())
                .build();

        return replyDTO;
    }
}
