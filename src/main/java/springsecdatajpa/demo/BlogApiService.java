package springsecdatajpa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springsecdatajpa.demo.config.RsaKeyProperties;
import springsecdatajpa.demo.service.AppUserService;
import springsecdatajpa.demo.service.BlogPostService;

import javax.annotation.PostConstruct;


@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class BlogApiService {

	private final AppUserService appUserService;
	private final BlogPostService blogPostService;

	public BlogApiService(AppUserService appUserService, BlogPostService blogPostService) {
		this.appUserService = appUserService;
		this.blogPostService = blogPostService;
	}


	@PostConstruct
	public void initData() {

		// Add a blogpost
//		AppUser appUser = appUserService.findUserByID(1);
//
//		CreateBlogPostDTO blogPost1 = new CreateBlogPostDTO("About me", "This is long text about me...", appUser);
//		blogPostService.saveBlogPost(blogPost1);
	}



	public static void main(String[] args) {
		SpringApplication.run(BlogApiService.class, args);
	}




}
