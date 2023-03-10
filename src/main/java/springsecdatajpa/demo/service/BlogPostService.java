package springsecdatajpa.demo.service;


import org.springframework.stereotype.Service;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.BlogPost;
import springsecdatajpa.demo.entity.DTO.AppUserDTO;
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

    public BlogPost getBlogByTopic(String topic) {
        return blogPostRepository.findByTopic(topic);
    }

    public void saveBlogPost(CreateBlogPostDTO blogPost1) {
        BlogPost bp = mapper.convertDtoToBlogPost(blogPost1);
        blogPostRepository.save(bp);
    }


    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public String saveABlogPost(CreateBlogPostDTO createBlogPostDTO) {

        if (createBlogPostDTO.getText()== null  || createBlogPostDTO.getTopic() == null ) {
            System.out.println("Entry not posted to Database. Add both Topic and text please!");
            return "Entry not posted to Database. Add both Topic and text please!";
        }
        if(createBlogPostDTO.getTopic().isBlank() || createBlogPostDTO.getText().isBlank()){
            System.out.println("Entry not posted to Database. Neither Topic or text can be white spaces only!");
            return "Entry not posted to Database. Neither Topic or text can be white spaces only!";
        }
        // TODO: 1st find user
        AppUser appUser = appUserService.findUserByID(createBlogPostDTO.getAppUserId());

        // TODO: 2nd Convert blogDTO --> BlogPost
        BlogPost bp = mapper.convertDtoToBlogPost2(createBlogPostDTO, appUser);

        // TODO: Save blogpost with repo
        blogPostRepository.save(bp);
        return "The Blog Entry was successfully saved";
    }

    public List<BlogPostDTO> getAllBlogPostsDTO() {
        List<BlogPost> allBlogs = blogPostRepository.findAll();
        List<BlogPostDTO> convertedList = mapper.convertBlogPostToDTOs2(allBlogs);
        return convertedList;
    }

    public List<BlogPostDTO> getAllUsersBlogPost(AppUserDTO appUserDTO) {
        AppUser appUser = appUserService.findUserByID(appUserDTO.getId());
        List<BlogPost> allBlogs = blogPostRepository.findAllByAppUser(appUser);
        List<BlogPostDTO> convertedList = mapper.convertBlogPostToDTOs2(allBlogs);
        return convertedList;
    }

    public List<BlogPostDTO> getAllUsersBlogPostFromId(Integer a) {
        AppUser appUser = appUserService.findUserByID(a);
        List<BlogPost> allBlogs = blogPostRepository.findAllByAppUser(appUser);
        List<BlogPost> allBlogsSortedByDate = mapper.sortBlogPostByLastestAdded(allBlogs);
        List<BlogPostDTO> convertedList = mapper.convertBlogPostToDTOs2(allBlogsSortedByDate);
        return convertedList;
    }
}
