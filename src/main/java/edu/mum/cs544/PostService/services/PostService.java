package edu.mum.cs544.PostService.services;

import edu.mum.cs544.PostService.repositories.IPostDao;
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

@Service
@Transactional
public interface PostService {

    public List<Post> getAllByUserId(int userId);
    public List<Post> getAll();
    public void add(Post post);
    public Post get(int id);
    public void update(Post post, int id);
    public void delete(int id);
}
