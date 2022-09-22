package edu.mum.cs544.PostService.contrtollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import edu.mum.cs544.PostService.model.Post;
import edu.mum.cs544.PostService.services.PostService;

@RestController
// @RequestMapping("/posts")
public class PostContrtoller {

    @Autowired
    private PostService  postService;

    // @GetMapping("/")
    // public RedirectView redirectRoot() {
    //     return new RedirectView("/posts");
    // }

    @GetMapping(value = "/posts", produces = "application/json")
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping(value = "/posts/{id}")
    public Post get(@PathVariable int id) {
        return postService.get(id);
    }

    @PostMapping(value = "/posts/add", consumes = "application/json")
    public RedirectView add(@RequestBody Post post) {
        postService.add(post);
        Long id = post.getId();
        return new RedirectView("/posts/" + id);
    }

    @PostMapping(value = "/posts/update/{id}", consumes = "application/json")
    public String update(@PathVariable long id, @RequestBody Post post) {
        if (id != post.getId()) {
            throw new IllegalArgumentException();
        }
        postService.update(post);
        return "{ \"post updated\": " + id + "}";
    }

    @GetMapping(value = "/posts/delete/{id}")
    public String delete(@PathVariable int id) {
        postService.delete(id);
        return "{ \"post deleted\": " + id + "}";
    }


}
