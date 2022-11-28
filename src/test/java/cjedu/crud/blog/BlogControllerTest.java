package cjedu.crud.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BlogControllerTest {
    @Autowired
    BlogRepository repos;

    @Test
    void testPage() {
    }
}
