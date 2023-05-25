package com.example.springboothw19.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Blog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title cannot be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String title;

    @NotEmpty(message = "category cannot be empty")
    @Column(columnDefinition = "varchar(20) not null check(category='health' or category='education' or category='programming')")
    private String category;

//    @NotEmpty(message = "body cannot be empty")
    @Size(min=10, max = 300, message = "body should be between 10 to 300 letters")
    @Column(columnDefinition = "varchar(300) not null")
    private String body;

    @AssertFalse
    @Column(columnDefinition = "boolean not null default false")
    private Boolean isPublished;
}
