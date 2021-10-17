package com.assessment.notes.domain;



import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "user_notes")
public class Note{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable=false)
    private Long id;
    @Column(name = "Title", length=50, nullable = false)
    private String title;
    @Column(name = "Note", length=1000)
    private String note;
    @Column(name = "CreateTime", nullable = false)
    private Date createTime;
    @Column(name = "LastUpdateTime", nullable = false)
    private Date lastUpdateTime;
    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;
}
