package com.assessment.notes.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, updatable = false)
    private Long id;
    @Column(name="email", nullable = false)
    private String email;
    private String password;
    @Column(name = "CreateTime", nullable = false)
    private Date createTime;
    @Column(name = "LastUpdateTime", nullable = false)
    private Date lastUpdateTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Note> noteList;
}
