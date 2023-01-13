package springsecdatajpa.demo.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserLoginDTO {

    private String username;
    private String userpassword;
}
