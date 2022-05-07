package org.geon.journey.board.service;

import org.geon.journey.board.dto.BoardDTO;
import org.geon.journey.board.dto.ImageDTO;
import org.geon.journey.board.entity.Board;
import org.geon.journey.board.entity.Image;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface BoardService {

    List<ImageDTO> saveText(BoardDTO dto);

    List<Map<String,Object>> readTextWithImg(Long bno);

    void modifyText(BoardDTO dto);

    void deleteText(Long bno);

    List<Map<String,Object>> getListPage(int page);

    default Map<String, Object> dtoToEntity(BoardDTO dto){

        Map<String, Object> entityMap = new HashMap<>();

        Board boardEntity = Board.builder()
                .bno(dto.getBno())
                .text(dto.getText())
                .email(dto.getEmail())
                .build();

        entityMap.put("boardEntity", boardEntity);

        List<ImageDTO> imgDTOList = dto.getImgDTOList();

        if(imgDTOList != null && imgDTOList.size() > 0) {
            List<Image> imgList = imgDTOList.stream().map(imgDTO -> {
                Image imgEntity = Image.builder()
                        .uuid(imgDTO.getUuid())
                        .imgName(imgDTO.getImgName())
                        .path(imgDTO.getPath())
                        .build();
                return imgEntity;
            }).collect(Collectors.toList());

            entityMap.put("imgList", imgList);
        }

        return entityMap;
    }

    default BoardDTO entityToDTO(Board entity, List<Image> imgEntitys){
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(entity.getBno())
                .text(entity.getText())
                .email(entity.getEmail())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        List<ImageDTO> imgDTOList = imgEntitys.stream().map(img -> {
            return ImageDTO.builder()
                    .uuid(img.getUuid())
                    .imgName(img.getImgName())
                    .path(img.getPath())
                    .build();
        }).collect(Collectors.toList());

        boardDTO.setImgDTOList(imgDTOList);

        return boardDTO;
    }
}
