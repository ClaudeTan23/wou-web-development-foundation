package community.portal.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long comment_id;

    @Column(length = 255, nullable = false)
    String content;

    @Column(length = 255, nullable = false)
    String user_id;

    @Column(length = 255, nullable = false)
    String post_id;

    @Column(length = 255, nullable = false)
    String time;

    @Column(length = 255, nullable = false)
    String status;

    @ManyToMany(fetch = FetchType.EAGER)
    List<UsersEntity> users = new ArrayList<UsersEntity>();

    public Long getComment_id()
    {
        return this.comment_id;
    }

    public Long setComment_id(Long comment_id)
    {
        return this.comment_id = comment_id;
    }

    public String getUser_id()
    {
        return this.user_id;
    }

    public String setPost_id(String post_id)
    {
        return this.post_id = post_id;
    }

    public String getPost_id() {
        return this.post_id;
    }

    public String setUser_id(String user_id) {
        return this.user_id = user_id;
    }

    public String getContent()
    {
        return this.content;
    }

    public String setContent(String content)
    {
        return this.content = content;
    }

    public String getTime()
    {
        return this.time;
    }

    public String setTime(String time)
    {
        return this.time = time;
    }

    public String getStatus()
    {
        return this.status;
    }

    public String setStatus(String status)
    {
        return this.status = status;
    } 

    public List<UsersEntity> getCommentuser()
    {
        return this.users;
    }

    public void setCommentuser(UsersEntity commentUser)
    {
        this.users.add(commentUser);
    }
}
