package com.example.springboothw19.Repository;

import com.example.springboothw19.Model.Blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {


    Blog findBlogById( Integer id);

    Blog findBlogByTitle(String title);

    List<Blog> findBlogByCategory(String category);


    @Query("select s from Blog s where s.id=?1")
    Blog pleaseGetId(Integer id);




}
