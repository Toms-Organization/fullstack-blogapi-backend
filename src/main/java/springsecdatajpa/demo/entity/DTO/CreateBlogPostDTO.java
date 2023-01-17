package springsecdatajpa.demo.entity.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springsecdatajpa.demo.entity.AppUser;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBlogPostDTO {

    private String topic;
    private String text;
    private AppUserDTO appUserDTO;


}
