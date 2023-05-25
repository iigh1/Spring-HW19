package com.example.springboothw19.Controller;

import com.example.springboothw19.Model.Blog;
import com.example.springboothw19.Service.BlogService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;


    @GetMapping("/get")
    public ResponseEntity getAllBlog(){

        List<Blog> blogs= blogService.getAllBlog();
        return ResponseEntity.status(200).body(blogs);

    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog){

        blogService.addBlog(blog);
        return ResponseEntity.status(200).body("blog added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody Blog blog,@PathVariable Integer id){

        blogService.updateBlog(id,blog);
        return ResponseEntity.status(200).body("blog updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
        return ResponseEntity.status(200).body("blog deleted");
    }


    @GetMapping("/get-id/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id){
        Blog blog = blogService.findBlogById(id);
        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/get-title/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title){
        Blog blog = blogService.findBlogByTitle(title);
        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/get-cat/{category}")
    public ResponseEntity getBlogByCategory(@PathVariable String category){
        List<Blog>blogs=blogService.findBlogByCat(category);
        return ResponseEntity.status(200).body(blogs);
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity ChangePublished(@Valid @PathVariable Integer id){

        blogService.published(id);
        return ResponseEntity.status(200).body("Changed");
    }


}
