package cjedu.crud.blog;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query("select p from blog p where title=:title")
    List<Blog> findAllByTitle(@Param("title") String title);
    List<Blog> findTop2ByTitle(String title);
    List<Blog> findByTitle(String title, Sort sort);
    Page<Blog> findByTitle(String title, Pageable pageable);
}