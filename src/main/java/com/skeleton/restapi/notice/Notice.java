package com.skeleton.restapi.notice;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "notice", catalog = "skeleton")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @CreatedDate
    @Column(nullable = true)
    private LocalDateTime cdate;

    @Column(length = 30)
    private String cuser;

    @CreatedDate
    @Column(nullable = true)
    private LocalDateTime udate;

    @Column(length = 30)
    private String uuser;

}
