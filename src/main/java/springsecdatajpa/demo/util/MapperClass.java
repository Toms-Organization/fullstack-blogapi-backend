package springsecdatajpa.demo.util;

import org.modelmapper.ModelMapper;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.BlogPost;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;
import springsecdatajpa.demo.entity.DTO.CreateBlogPostDTO;

public class MapperClass {


    private final ModelMapper mapper = new ModelMapper();



    public AppUser convertDtoToUser(AppUserLoginDTO appUserLoginDTO) {
        return mapper.map(appUserLoginDTO, AppUser.class);
    }

    public BlogPost convertDtoToBlogPost(CreateBlogPostDTO createBlogPostDTO){
        return mapper.map(createBlogPostDTO, BlogPost.class);
    }

    public BlogPost convertDtoToBlogPost2(CreateBlogPostDTO createBlogPostDTO, AppUser appUser) {
        BlogPost bp = new BlogPost();
        bp.setTopic(createBlogPostDTO.getTopic());
        bp.setText(createBlogPostDTO.getText());
        bp.setAppUser(appUser);
        return bp;

    }
}
