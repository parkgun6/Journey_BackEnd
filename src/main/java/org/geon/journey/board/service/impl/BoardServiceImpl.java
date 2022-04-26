package org.geon.journey.board.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.journey.board.mapper.BoardMapper;
import org.geon.journey.board.mapper.ImageMapper;
import org.geon.journey.board.service.BoardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private final ImageMapper imageMapper;

//    @Override
//    public List<ImageDTO> saveText(BoardDTO dto) {
//        Map<String, Object> entityMap = dtoToEntity(dto);
//        Board entity = (Board) entityMap.get("testEntity");
//        boardMapper.insertBoard(entity);
//
//        List<Image> imgList = (List<Image>) entityMap.get("imgList");
//        imgList.forEach(img -> {
//            imgRepository.save(img);
//        });
//        List<Image> resImgList = imgRepository.getImgList(entity.getSno());
//        List<ImageDTO> dtoList = resImgList.stream().map(img -> {
//                                    return ImageDTO.builder()
//                                            .uuid(img.getUuid())
//                                            .imgName(img.getImgName())
//                                            .path(img.getPath())
//                                            .build();
//                                }).collect(Collectors.toList());
//
//        return dtoList;
//    }
//
//    @Override
//    public void modifyText(BoardDTO dto) {
//        log.info(dto.toString());
//        Long sno = dto.getSno();
////        List<Image> imgDTOList = null;
//        Optional<Board> testResult = testRepository.findById(sno);
////        List<Image> imgResult = imgRepository.getImgList(sno);
////        log.info("2 : " + imgResult);
//        //log.info("2 : " + imgDTOList);
//
//        if(testResult.isPresent()){
//            log.info("1 : " + testResult.get());
//            Board entity = testResult.get();
//            entity.changeText(dto.getText());
//            testRepository.save(entity);
//        }
//    }

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
