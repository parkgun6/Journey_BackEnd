package org.geon.journey.board.entity;


import lombok.*;

import java.util.Date;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Board {

    private Long bno;

    private String text;

    private boolean deleteFlag;

    private Date regDate;

    private Date modDate;

    public void changeText(String text){
        this.text = text;
    }
}
