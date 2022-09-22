package edu.mum.cs544.PostService.services;
import edu.mum.cs544.PostService.repositories.IPostDao;
import edu.mum.cs544.PostService.model.Post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional //(propagation = Propagation.REQUIRES_NEW)
public class PostService {
    @Autowired
    private IPostDao postDao;

    public List<Post> getAll() {
        return postDao.findAll();
    }

    public void add(Post post) {
        postDao.save(post);
    }

    public Post get(int id) {
        return postDao.findById(id).get();
    }

    public void update(Post post) {
        postDao.save(post);
    }

    public void delete(int id) {
        postDao.deleteById(id);
    }

}
