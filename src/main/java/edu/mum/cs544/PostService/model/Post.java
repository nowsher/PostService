package edu.mum.cs544.PostService.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "blogpost")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @NotBlank
    private String title;

    @NotNull 
    private Date dateLastUpdated;

    @Lob
    @NotNull
    @NotBlank
    private String text;    

    @Positive
    private int userId;
}
