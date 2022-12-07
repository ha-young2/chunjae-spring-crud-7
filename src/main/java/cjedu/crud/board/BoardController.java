package cjedu.crud.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    
    @Autowired
    BoardRepository repos;

    @GetMapping("board")
    List<Board> index() {
        return repos.findAll();
    }

    //hi
    @RequestMapping("board/save")
    Board save(Board board) {
        return repos.save(board);
    }
}
