package org.geon.journey.board.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.journey.board.dto.BoardDTO;
import org.geon.journey.board.dto.ImageDTO;
import org.geon.journey.board.entity.Board;
import org.geon.journey.board.entity.Image;
import org.geon.journey.board.mapper.BoardMapper;
import org.geon.journey.board.mapper.ImageMapper;
import org.geon.journey.board.service.BoardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private final ImageMapper imageMapper;

    @Override
    @Transactional
    public List<ImageDTO> saveText(BoardDTO dto) {
        Map<String, Object> entityMap = dtoToEntity(dto);
        Board entity = (Board) entityMap.get("boardEntity");
        boardMapper.insertBoard(entity);
        List<Image> imgList = (List<Image>) entityMap.get("imgList");
        imgList.forEach(img -> {
            img.setBno(entity.getBno());
            imageMapper.insertImage(img);
        });
        List<Image> resImgList = imageMapper.getImageList(entity.getBno());
        List<ImageDTO> dtoList = resImgList.stream().map(img -> {
                                    return ImageDTO.builder()
                                            .uuid(img.getUuid())
                                            .imgName(img.getImgName())
                                            .path(img.getPath())
                                            .build();
                                }).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public List<Map<String,Object>> readTextWithImg(Long bno) {
        return boardMapper.getTextWithImg(bno);
    }

    @Override
    public void modifyText(BoardDTO dto) {
        log.info(dto.toString());
        Map<String, Object> entityMap = dtoToEntity(dto);
        Board board = (Board) entityMap.get("boardEntity");
        boardMapper.modifyText(board);
    }

    @Override
    @Transactional
    public void deleteText(Long bno) {
        imageMapper.deleteImageByBno(bno);
        boardMapper.delete(bno);
    }

    @Override
    public List<Map<String,Object>> getListPage(int page) {
        return boardMapper.getList(page);
    }
}
