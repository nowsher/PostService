package edu.mum.cs544.PostService.services.impl;

import edu.mum.cs544.PostService.repositories.IPostDao;
import edu.mum.cs544.PostService.services.PostService;
import edu.mum.cs544.PostService.exceptions.PostDataException;
import edu.mum.cs544.PostService.model.Post;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import edu.mum.cs544.PostService.repositories.IPostDao;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private IPostDao postDao;

    public List<Post> getAll() {
        return postDao.findAll();
    }

    @Override
    public List<Post> getAllByUserId(int userId) {
        return postDao.findAllByUserId(userId);
    }

    @Override
    public void add(Post post) {
        try {
            post.setDateLastUpdated(new Date());
            postDao.save(post);
        } catch (Exception e) {
            throw new PostDataException("Invalid post data.");
        }
    }

    @Override
    public Post get(int id) {
        return postDao.findById(id).get();
    }

    @Override
    public void update(Post post, int id) {
        if (id != post.getId()) {
            throw new IllegalArgumentException("Invalid post id.");
        }
        try {
            post.setDateLastUpdated(new Date());
            Optional<Post> postTmp = postDao.findById(id);
            if (!postTmp.isEmpty()) {
                postDao.save(post);
            } else {
                throw new IllegalArgumentException("Invalid post id.");
            }
        } catch (Exception e) {
            throw new PostDataException("Invalid post data.");
        }
    }

    @Override
    public void delete(int id) {
        try {
            postDao.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid post id.");
        }

    }

}
