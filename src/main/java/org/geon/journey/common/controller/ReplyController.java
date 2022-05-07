package org.geon.journey.common.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.journey.common.service.ReplyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@CrossOrigin
public class ReplyController {

    private final ReplyService replyService;
}
