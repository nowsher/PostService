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

import edu.mum.cs544.PostService.model.Post;
import edu.mum.cs544.PostService.services.PostService;

@RestController
@RequestMapping("/api/v1/posts")
public class PostContrtoller {

    @Autowired
    private PostService postService;    

    @GetMapping
    public List<Post> getAllByUserId(@RequestParam(required = false) Integer userId) {
        if (userId == null) {
            return postService.getAll();
        }
        return postService.getAllByUserId(userId.intValue());
    }

    @GetMapping(value = "/{id}")
    public Post get(@PathVariable int id) {
        return postService.get(id);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> add(@RequestBody Post post) {
        postService.add(post);        
        return new ResponseEntity<>("{ \"Message\": \"Post was added.\"}", HttpStatus.OK);
    }

    @PostMapping(value = "/update/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Post post) {
        postService.update(post,id);                
        return new ResponseEntity<>("{ \"Message\": \"Post was updated.\"}", HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        postService.delete(id);
        return new ResponseEntity<>("{ \"Message\": \"Post was deleted.\"}", HttpStatus.OK);
    }

}
