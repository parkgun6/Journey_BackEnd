package org.geon.journey.common.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.journey.common.dto.ReplyDTO;
import org.geon.journey.common.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@CrossOrigin
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("/replys/{page}")
    public ResponseEntity<List<ReplyDTO>> getReplys(@PathVariable("page") int page) {
        int pageNum = (page - 1) * 2;
        log.info(pageNum);
        return new ResponseEntity<>(replyService.getReplys(pageNum), HttpStatus.OK);
    }
}
