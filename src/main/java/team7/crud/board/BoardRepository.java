package team7.crud.board;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;



public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select p from board p where title=:title")
    List<Board> findAllByTitle(@Param("title") String title);
    
}