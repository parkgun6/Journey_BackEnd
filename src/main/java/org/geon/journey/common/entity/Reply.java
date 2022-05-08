package org.geon.journey.common.entity;

import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Reply {

    private String rno;

    private Long bno;

    private String email;

    private String reply;

    private boolean deleteFlag;

    private String regDate;

    private String modDate;
}
