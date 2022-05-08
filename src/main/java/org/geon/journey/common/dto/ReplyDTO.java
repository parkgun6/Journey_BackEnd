package org.geon.journey.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {

    private String rno;

    private Long bno;

    private String email;

    private String reply;

    private boolean deleteFlag;

    private String regDate;

    private String modDate;
}
