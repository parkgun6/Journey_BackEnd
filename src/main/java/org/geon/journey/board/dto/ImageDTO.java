package org.geon.journey.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {

    private Long ino;

    private String uuid;

    private String imgName;

    private String path;

    private Date regDate;

    private Date modDate;

}
