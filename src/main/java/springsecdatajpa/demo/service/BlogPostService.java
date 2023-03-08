package springsecdatajpa.demo.service;


import org.springframework.stereotype.Service;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.BlogPost;
import springsecdatajpa.demo.entity.DTO.BlogPostDTO;
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

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public void saveBlogPost(CreateBlogPostDTO createBlogPostDTO) {
        AppUser appUser = appUserService.findUserByID(createBlogPostDTO.getAppUserId());
        BlogPost bp = mapper.convertDtoToBlogPost2(createBlogPostDTO, appUser);
        blogPostRepository.save(bp);
    }

    public List<BlogPostDTO> getAllBlogPostsDTO() {
        List<BlogPost> allBlogs = blogPostRepository.findAll();
        List<BlogPostDTO> convertedList = mapper.convertBlogPostToDTOs2(allBlogs);
        return convertedList;
    }


    public List<BlogPostDTO> getAllUsersBlogPostFromId(Integer a) {
        AppUser appUser = appUserService.findUserByID(a);
        List<BlogPost> allBlogs = blogPostRepository.findAllByAppUser(appUser);
        List<BlogPostDTO> convertedList = mapper.convertBlogPostToDTOs2(allBlogs);
        return convertedList;
    }
}
