package springsecdatajpa.demo.controller;

import org.springframework.web.bind.annotation.*;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.BlogPost;
import springsecdatajpa.demo.entity.DTO.AppUserDTO;
import springsecdatajpa.demo.entity.DTO.BlogPostDTO;
import springsecdatajpa.demo.entity.DTO.CreateBlogPostDTO;
import springsecdatajpa.demo.service.BlogPostService;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/blogpost")
public class BlogPostController {

    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }


    @GetMapping("/getoneblogpostfromtopicname")
    public BlogPost getBlogPostByTopic(@RequestParam String topic){
       return blogPostService.getBlogByTopic(topic);
    }

    @GetMapping("/getAllPosts")
    public List<BlogPostDTO> getAllBlogPosts(){
        return blogPostService.getAllBlogPostsDTO();
    }

    @PostMapping("/getmyposts")
    public List<BlogPostDTO> getAllPostsFromOneUser(@RequestBody AppUserDTO appUserDTO ){
        return blogPostService.getAllUsersBlogPost(appUserDTO);
    }



    // TODO: REMOVE THIS ENDPOINT OR SET "ADMIN" authority to view content.
    @GetMapping("/getallpostsasadmin")
    public List<BlogPost> getAllBlogPostsAsAdmin(){
        // either remove this endpoint or protect it by authority "admin"
        return blogPostService.getAllBlogPosts();
    }


    @PostMapping("/createblogpost")
    public String createNewBlogPost(@RequestBody CreateBlogPostDTO createBlogPostDTO){
        blogPostService.saveBlogPost2(createBlogPostDTO);
        return "Blogpost created";
    }




}
