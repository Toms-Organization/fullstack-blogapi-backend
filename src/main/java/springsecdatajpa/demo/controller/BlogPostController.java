package springsecdatajpa.demo.controller;

import org.springframework.web.bind.annotation.*;
import springsecdatajpa.demo.entity.BlogPost;
import springsecdatajpa.demo.entity.DTO.BlogPostDTO;
import springsecdatajpa.demo.entity.DTO.CreateBlogPostDTO;
import springsecdatajpa.demo.entity.DTO.UserId;
import springsecdatajpa.demo.service.BlogPostService;

import java.util.List;

@RestController
@RequestMapping("")
public class BlogPostController {
    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @PostMapping("/createblogpost")
    public String createNewBlogPost(@RequestBody CreateBlogPostDTO createBlogPostDTO) {
        blogPostService.saveBlogPost2(createBlogPostDTO);
        return "Blogpost created";
    }

    @PostMapping("/getusersblogposts")
    public List<BlogPostDTO> getAllPostsFromTheUser(@RequestBody UserId userId) {
        return blogPostService.getAllUsersBlogPostFromId(userId.getId());
    }


    // TODO: REMOVE THIS ENDPOINT OR SET "ADMIN" authority to view content.
    @GetMapping("/getallpostsasadmin")
    public List<BlogPost> getAllBlogPostsAsAdmin() {
        // either remove this endpoint or protect it by authority "admin"
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/opentemporary")
    public List<BlogPostDTO> getAllBlogPostsTemporaryEndpoint() {
        System.out.println(blogPostService.getAllBlogPostsDTO());
        return blogPostService.getAllBlogPostsDTO();
    }

}





