package community.portal.RestController;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import community.portal.Entity.CommentEntity;
import community.portal.Entity.PostEntity;
import community.portal.Entity.UsersEntity;
import community.portal.Exception.CustomException;
import community.portal.Repository.Comments;
import community.portal.Repository.Posts;
import community.portal.Repository.Users;

@RestController
public class PostController extends CustomException
{
    @Autowired 
    private Users users;

    @Autowired
    private Posts posts;

    @Autowired
    private Comments comments;

    @PostMapping(value = "/comment", produces = "text/plain")
    public String Comment(CommentEntity comment, Principal p)
    {
        UsersEntity user = users.findUserWithId(p.getName(), "active");
        String[] time = LocalTime.now().toString().split(":");
        
        String timeText = time[0] + ":" + time[1] + " " + LocalDate.now();
        
        comment.setTime(timeText);
        comment.setStatus("active");
        comment.setUser_id(p.getName());
        comment.setCommentuser(user);
        
        comments.save(comment);

        List<CommentEntity> allComment = comments.findAllByPostId(comment.getPost_id().toString());

        String jsonString = "";

        for (CommentEntity commentEntity : allComment) 
        {
            jsonString += "\"content\":" + "\"" + commentEntity.getContent() + "\"" + ",";
            jsonString += "\"time\":" + "\"" + commentEntity.getTime() + "\"" + ",";
            jsonString += "\"username\":" + "\"" +  commentEntity.getCommentuser().get(0).getLastname() + " " + commentEntity.getCommentuser().get(0).getFirstname() + "\""  + ",";
            jsonString += "\"image\":" + "\"" + commentEntity.getCommentuser().get(0).getImage() + "\"";
            jsonString += "###";
        }

        return jsonString;

    }

    @GetMapping(value = "/comments/{postId}", produces = "text/plain")
    public String fetchComments(@PathVariable String postId)
    {
        List<CommentEntity> allComment = comments.findAllByPostId(postId);

        String jsonString = "";

        for (CommentEntity commentEntity : allComment) 
        {
            jsonString += "\"content\":" + "\"" + commentEntity.getContent() + "\"" + ",";
            jsonString += "\"time\":" + "\"" + commentEntity.getTime() + "\"" + ",";
            jsonString += "\"username\":" + "\"" +  commentEntity.getCommentuser().get(0).getLastname() + " " + commentEntity.getCommentuser().get(0).getFirstname() + "\""  + ",";
            jsonString += "\"image\":" + "\"" + commentEntity.getCommentuser().get(0).getImage() + "\"";
            jsonString += "###";
        }

        return jsonString;
    }

}
