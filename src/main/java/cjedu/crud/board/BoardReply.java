package cjedu.crud.board;
import java.time.LocalDateTime;    
import javax.persistence.*;
import lombok.Data;

  
@Entity
@Data
public class BoardReply {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 원글의 id
    @Column(nullable = false)
    private Long boardId;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String userName;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;
}
    
    