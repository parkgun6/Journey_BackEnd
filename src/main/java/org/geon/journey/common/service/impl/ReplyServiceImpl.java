package org.geon.journey.common.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.journey.common.dto.ReplyDTO;
import org.geon.journey.common.entity.Reply;
import org.geon.journey.common.mapper.ReplyMapper;
import org.geon.journey.common.service.ReplyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper;

    @Override
    public void insertReply(Reply reply) {
        replyMapper.insertReply(reply);
    }

    @Override
    public List<ReplyDTO> getReplys(int page) {
        List<Reply> reply = replyMapper.getReplys(page);
        return reply.stream().map(res -> entityToDTO(res)).collect(Collectors.toList());
    }
}
