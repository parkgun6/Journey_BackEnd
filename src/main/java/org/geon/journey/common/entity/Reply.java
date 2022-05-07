package org.geon.journey.common.entity;

import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Reply {

    private Long rno;

    private Long bno;

    private String email;

    private String reply;

    private boolean deleteFlag;

    private Date regDate;

    private Date modDate;
}
