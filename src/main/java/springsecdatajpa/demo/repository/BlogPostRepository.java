package springsecdatajpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springsecdatajpa.demo.entity.BlogPost;
import springsecdatajpa.demo.entity.DTO.CreateBlogPostDTO;


public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {


    BlogPost findByTopic(String topic);

}
