package org.geon.journey.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.journey.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@CrossOrigin
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public ResponseEntity<String> herokuTest(){
        return new ResponseEntity<>("HelloWorld",HttpStatus.OK);
    }

//    @PostMapping("todo")
//    public ResponseEntity<List<ImageDTO>> saveTodo(@RequestBody BoardDTO dto){
//        log.info(dto.toString());
//        String uuid = UUID.randomUUID().toString();
//        dto.getImgDTOList().forEach(res -> {
//            String resImgName = res.getImgName();
//            int findDot = resImgName.indexOf(".");
//            int imgNameLength = resImgName.length();
//            String imgType = resImgName.substring(findDot+1, imgNameLength);
//            int imgTypeLength = imgType.length();
//            String imgName = resImgName.substring(0, imgNameLength - imgTypeLength - 1);
//            String imgNameWithTime = imgName + "-" + LocalDateTime.now() + "." + imgType;
//            res.setImgName(imgNameWithTime);
//            res.setUuid(uuid);
//            res.setPath("https://firebasestorage.googleapis.com/v0/b/journey-study.appspot.com/o/"+imgNameWithTime+"?alt=media");
//        });
//        List<ImageDTO> result = boardService.saveText(dto);
//        return new ResponseEntity<>(result,HttpStatus.OK);
//    }
//
//    @PutMapping("/{sno}")
//    public ResponseEntity<String> modifyTodo(@RequestBody TestDTO dto, @PathVariable("sno") String sno){
//        boardService.modifyText(dto);
//        log.info(sno);
//        return new ResponseEntity<>(sno + "번째 글이 수정되었습니다..",HttpStatus.OK);
//    }

    @DeleteMapping("/{sno}")
    public ResponseEntity<String> deleteTodo(@PathVariable("sno") Long sno){
        log.info(sno);
        boardService.deleteText(sno);
        return new ResponseEntity<>(sno+"번째 글이 삭제되었습니다.",HttpStatus.OK);
    }

    @GetMapping("/list/{page}")
    public ResponseEntity<List<Map<String,Object>>> getPageList(@PathVariable("page") int page){
        int pageNum = (page - 1) * 10;
        log.info(pageNum);
        return new ResponseEntity<>(boardService.getListPage(pageNum),HttpStatus.OK);
    }

}
