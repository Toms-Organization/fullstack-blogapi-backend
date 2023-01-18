package springsecdatajpa.demo.service;


import org.springframework.stereotype.Service;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.BlogPost;
import springsecdatajpa.demo.entity.DTO.CreateBlogPostDTO;
import springsecdatajpa.demo.repository.BlogPostRepository;
import springsecdatajpa.demo.util.MapperClass;

import java.util.List;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final AppUserService appUserService;
    private final MapperClass mapper = new MapperClass();



    public BlogPostService(BlogPostRepository blogPostRepository, AppUserService appUserService) {
        this.blogPostRepository = blogPostRepository;
        this.appUserService = appUserService;
    }

    public BlogPost getBlogByTopic(String topic){
        return blogPostRepository.findByTopic(topic);
    }

    public void saveBlogPost(CreateBlogPostDTO blogPost1) {
        BlogPost bp = mapper.convertDtoToBlogPost(blogPost1);
        blogPostRepository.save(bp);
    }


    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public void saveBlogPost2(CreateBlogPostDTO createBlogPostDTO) {

        // TODO: 1st find user
        AppUser appUser = appUserService.findUserByID(createBlogPostDTO.getAppUserId());

        // TODO: 2nd Convert blogDTO --> BlogPost
        BlogPost bp = mapper.convertDtoToBlogPost2(createBlogPostDTO, appUser);

        // TODO: Save blogpost with repo
        blogPostRepository.save(bp);
    }
}
