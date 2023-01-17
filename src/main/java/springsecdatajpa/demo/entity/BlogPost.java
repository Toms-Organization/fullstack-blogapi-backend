package springsecdatajpa.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blog_post")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String topic;
    private String text;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createdAt;


    @JoinColumn
    @ManyToOne(cascade = CascadeType.MERGE)
    private AppUser appUser;





}
