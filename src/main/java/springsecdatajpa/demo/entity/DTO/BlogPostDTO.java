package springsecdatajpa.demo.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import springsecdatajpa.demo.entity.AppUser;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostDTO {

    private int id;
    private String topic;
    private String text;
    private Date createdAt;
    private String byUser;


//    public void setCreatedAt(Date createdAt) {
//        String oldFormat = createdAt.toString();
//        String datetime = oldFormat.substring(0,10);
////        System.out.println(oldFormat);
////        LocalDateTime datetime = LocalDateTime.parse(oldFormat, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
//        this.createdAt = datetime;
//    }
}
