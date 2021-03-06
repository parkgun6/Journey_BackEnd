package org.geon.journey.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long bno;

    private String text;

    private String email;

    private Date regDate;

    private Date modDate;

    public BoardDTO(Long bno){
        this.bno = bno;
    };

    @Builder.Default
    private List<ImageDTO> imgDTOList = new ArrayList<>();
}
