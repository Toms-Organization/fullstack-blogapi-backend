package springsecdatajpa.demo.util;

import org.modelmapper.ModelMapper;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.BlogPost;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;
import springsecdatajpa.demo.entity.DTO.BlogPostDTO;
import springsecdatajpa.demo.entity.DTO.CreateBlogPostDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<BlogPostDTO> convertBlogPostToDTOs(List<BlogPost> listOfBlogPosts){
         return listOfBlogPosts.stream().map( e -> mapper.map( e, BlogPostDTO.class)).collect(Collectors.toList());
    }

    public List<BlogPostDTO> convertBlogPostToDTOs2(List<BlogPost> listOfBlogPosts){
        List<BlogPostDTO> convertedList = new ArrayList<>();

        for (int i = 0; i < listOfBlogPosts.size(); i++) {
            BlogPostDTO bpd = new BlogPostDTO();
            bpd.setId(listOfBlogPosts.get(i).getId());
            bpd.setByUser(listOfBlogPosts.get(i).getAppUser().getUserName());
            bpd.setTopic(listOfBlogPosts.get(i).getTopic());
            bpd.setText(listOfBlogPosts.get(i).getText());
            bpd.setCreatedAt(listOfBlogPosts.get(i).getCreatedAt());
            convertedList.add(bpd);
        }
        // listOfBlogPosts.stream().map( e -> mapper.map( e, BlogPostDTO.class)).collect(Collectors.toList();
        return convertedList;
    }

}
