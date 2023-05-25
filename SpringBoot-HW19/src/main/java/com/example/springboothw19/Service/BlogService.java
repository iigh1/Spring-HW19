package com.example.springboothw19.Service;

import com.example.springboothw19.ApiException.ApiException;
import com.example.springboothw19.Model.Blog;
import com.example.springboothw19.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;


    public List<Blog> getAllBlog(){
        return blogRepository.findAll();
    }


    public void addBlog(Blog blog){
        blogRepository.save(blog);
    }

    public void updateBlog(Integer id, Blog blog){
        Blog oldBlog = blogRepository.findBlogById(id);

        if (oldBlog==null){
            throw  new ApiException("blog not found");
        }
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setCategory(blog.getCategory());
        oldBlog.setBody(blog.getBody());

        blogRepository.save(oldBlog);
    }

    public void deleteBlog(Integer id){
        Blog oldBlog=blogRepository.pleaseGetId(id);

        if (oldBlog==null){
            throw new ApiException("blog not found");
        }
        blogRepository.delete(oldBlog);
    }

    public Blog findBlogById(Integer id){
        Blog blog = blogRepository.findBlogById(id);

        if(blog==null){
            throw new ApiException("blog not found");
        }
        return blog;
    }

    public Blog findBlogByTitle(String title){
        Blog blog = blogRepository.findBlogByTitle(title);

        if (blog==null){
            throw new ApiException("blog not fond");
        }
        return blog;
    }

    public List<Blog> findBlogByCat(String category){
        List<Blog> blogs = blogRepository.findBlogByCategory(category);

        if (blogs==null){
            throw new ApiException("category not found");
        }
        return blogs;

    }

    public void published(Integer id){
        Blog blog=blogRepository.findBlogById(id);

        if (blog==null){
            throw new ApiException("not found");
        }
        blog.setIsPublished(true);
        blogRepository.save(blog);
    }

}
