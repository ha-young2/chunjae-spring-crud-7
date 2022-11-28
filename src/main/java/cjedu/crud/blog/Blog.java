package cjedu.crud.blog;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Blog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;
}
