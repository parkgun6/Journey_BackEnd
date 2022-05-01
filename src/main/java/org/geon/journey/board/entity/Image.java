package org.geon.journey.board.entity;

import lombok.*;

import java.util.Date;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Image {

    private Long ino;

    private Long bno;

    private String uuid;

    private String imgName;

    private String path;

    private boolean deleteFlag;

    private Date regDate;

    private Date modDate;
}
