package springsecdatajpa.demo.controller;

import org.springframework.web.bind.annotation.*;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.BlogPost;
import springsecdatajpa.demo.entity.DTO.AppUserDTO;
import springsecdatajpa.demo.entity.DTO.BlogPostDTO;
import springsecdatajpa.demo.entity.DTO.CreateBlogPostDTO;
import springsecdatajpa.demo.entity.DTO.UserId;
import springsecdatajpa.demo.service.BlogPostService;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class BlogPostController {

    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }


    @GetMapping("/getoneblogpostfromtopicname")
    public BlogPost getBlogPostByTopic(@RequestParam String topic) {
        return blogPostService.getBlogByTopic(topic);
    }

    @GetMapping("/getAllPosts")
    public List<BlogPostDTO> getAllBlogPosts() {
        return blogPostService.getAllBlogPostsDTO();
    }

    @PostMapping("/getusersblogposts")
    public List<BlogPostDTO> getAllPostsFromTheUser(@RequestBody UserId userId) {
        return blogPostService.getAllUsersBlogPostFromId(userId.getId());
    }

    @PostMapping("/getusersblogposts2")     // http://localhost:8081/getusersblogposts2?a=1
    public List<BlogPostDTO> getAllPostsFromTheUser2(@RequestParam int a) {
        return blogPostService.getAllUsersBlogPostFromId(a);
    }

    // TODO: REMOVE THIS ENDPOINT OR SET "ADMIN" authority to view content.
    @GetMapping("/getallpostsasadmin")
    public List<BlogPost> getAllBlogPostsAsAdmin() {
        // either remove this endpoint or protect it by authority "admin"
        return blogPostService.getAllBlogPosts();
    }


    @PostMapping("/createblogpost")
    public String createNewBlogPost(@RequestBody CreateBlogPostDTO createBlogPostDTO) {
        System.out.println("In param::: "+ createBlogPostDTO.toString());
        return blogPostService.saveABlogPost(createBlogPostDTO);
    }


    @GetMapping("/opentemporary")
    public List<BlogPostDTO> getAllBlogPostsTemporaryEndpoint() {
        System.out.println(blogPostService.getAllBlogPostsDTO());
        return blogPostService.getAllBlogPostsDTO();
    }


}





