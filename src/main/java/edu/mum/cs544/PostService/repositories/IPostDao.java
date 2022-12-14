package edu.mum.cs544.PostService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.PostService.model.Post;

@Repository
public interface IPostDao extends JpaRepository<Post, Integer> {

    public List<Post> findAllByUserId(int userId);

}
