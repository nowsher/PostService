package edu.mum.cs544.PostService.contrtollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import edu.mum.cs544.PostService.dtos.ResponseDto;
import edu.mum.cs544.PostService.model.Post;
import edu.mum.cs544.PostService.services.PostService;

@RestController
@RequestMapping("/api/v1/posts")
public class PostContrtoller {

    @Autowired
    private PostService postService;    

    @GetMapping
    public ResponseDto<List<Post>> getAllByUserId(@RequestParam(required = false) Integer userId) {
        if (userId == null) {
            return new ResponseDto<>("List posts", false, postService.getAll() , null);            
        }
        return new ResponseDto<>("List posts", false, postService.getAllByUserId(userId.intValue()) , null);                
    }

    @GetMapping(value = "/{id}")
    public ResponseDto<Post> get(@PathVariable int id) {
        return new ResponseDto<>("Get a Post", false, postService.get(id) , null);        
    }

    @PostMapping(value = "/add")
    public ResponseDto<Post> add(@RequestBody Post post) {
        postService.add(post);        
        return new ResponseDto<Post>("Post added", false, post , null);        
    }

    @PostMapping(value = "/update/{id}")
    public ResponseDto<Post> update(@PathVariable int id, @RequestBody Post post) {
        postService.update(post,id);                
        return new ResponseDto<Post>("Post was updated", false, post, null);        
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseDto<String> delete(@PathVariable int id) {
        postService.delete(id);
        return new ResponseDto<String>("Post was deleted", false, null , null);
    }

}
