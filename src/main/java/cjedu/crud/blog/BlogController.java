package cjedu.crud.blog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BlogController {
    @Autowired
    BlogRepository repos;

    @GetMapping("blog")
    List<Blog> index() {
        return repos.findAll();
    }

    @GetMapping("blog/page")
    List<Blog> page() {
        return repos.findAllByTitle("test");
    }

    @GetMapping("blog/findByTitle")
    Page<Blog> findByTitle(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        if( page < 1 ) {
            page = 1;
        }
        if( page > 1 ) {
            page = page - 1;
        }
        return repos.findByTitle("이걸로 계속 저장하면 되겠네.", PageRequest.of(page,size));
    }

    @GetMapping("blog/findTop2ByTitle")
    List<Blog> findTop2ByTitle() {
        return repos.findTop2ByTitle("이걸로 계속 저장하면 되겠네.");
    }

    @GetMapping("blog/echo")
    Blog echo(Blog blog) {
        return blog;
    }

    @GetMapping("blog/fetch")
    Optional<Blog> fetch(Long id) {
        return repos.findById(id);
    }

    @RequestMapping("blog/save")
    Blog save(Blog blog) {
        return repos.save(blog);
    }

    @GetMapping("blog/delete")
    void delete(Long id) {
        repos.deleteById(id);
    }

}