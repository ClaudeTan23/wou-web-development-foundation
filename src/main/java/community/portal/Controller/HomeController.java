package community.portal.Controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import javax.persistence.criteria.Join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import community.portal.Entity.PostEntity;
import community.portal.Entity.RoleEntity;
import community.portal.Entity.SearchObject;
import community.portal.Entity.UsersEntity;
import community.portal.Exception.CustomException;
import community.portal.Exception.NotFound;
import community.portal.Repository.Posts;
import community.portal.Repository.Roles;
import community.portal.Repository.Users;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController extends CustomException
{
    @Autowired
    private Users users;

    @Autowired 
    private Posts posts;

    @Autowired 
    private Roles roles;

    public static Specification<PostEntity> findByContent(String content)
    {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.<String>get("content"), "%" + content + "%");
    }    

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Principal p, Model model)
    {
        UsersEntity user = users.findUserWithId(p.getName(), "active");
        List<PostEntity> post = (List<PostEntity>) posts.findAllDesc();

        model.addAttribute("user", user);
        model.addAttribute("post", post);

        return "home";
    }

    @RequestMapping(value = "/forget", method = RequestMethod.GET)
    public String Forget()
    {
        return "forget";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String Profile(Principal p, Model model)
    {
        UsersEntity user = users.findUserWithId(p.getName(), "active");

        model.addAttribute("user", user);

        return "profile";
    }

    @RequestMapping(value = "/sitemap", method = RequestMethod.GET)
    public String Sitemap(Principal p, Model model)
    {
        if(p == null)
        {
            model.addAttribute("auth", "true");

        } else 
        {
            model.addAttribute("auth", "false");
        }
     
        return "sitemap";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String Search(Principal p, Model model, SearchObject search)
    {
        UsersEntity user = users.findUserWithId(p.getName(), "active");
        List<UsersEntity> searchUser = new ArrayList<UsersEntity>();

        RoleEntity[] role = user.getRoles().toArray(new RoleEntity[user.getRoles().size()]);

        if(role[0].getRoles().equals("admin"))
        {
            if(search.s.equals("firstname"))
            {
                searchUser = users.findByFirstnameAdmin(search.v);

            } else if(search.s.equals("lastname"))
            {
                searchUser = users.findByLastnameAdmin(search.v);

            } else if(search.s.equals("city"))
            {
                searchUser = users.findByCityAdmin(search.v);

            } else if(search.s.equals("email"))
            {
                searchUser = users.findByEmailAdmin(search.v);

            }
             
        } else 
        {
            if(search.s.equals("firstname"))
            {
                searchUser = users.findByFirstname(search.v);

            } else if(search.s.equals("lastname"))
            {
                searchUser = users.findByLastname(search.v);

            } else if(search.s.equals("city"))
            {
                searchUser = users.findByCity(search.v);

            } else if(search.s.equals("email"))
            {
                searchUser = users.findByEmail(search.v);

            }
        }
        
        

        model.addAttribute("role", role[0].getRoles());
        model.addAttribute("user", user);
        model.addAttribute("response", searchUser);

        return "search";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET) 
    public String User(Model model, @PathVariable String id, Principal p)
    {
        UsersEntity Auth = users.findUserWithId(p.getName(), "active");
        UsersEntity user = users.findUserWithId(id, "active");

        model.addAttribute("Auth", Auth);
        model.addAttribute("user", user);

        return "user-profile";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET) 
    public String UserNotFound()
    {
        throw new NotFound();
    }

    @RequestMapping(value = "/admin/modify/{id}", method = RequestMethod.GET) 
    public String UserModify(Model model, @PathVariable String id, Principal p)
    {
        UsersEntity Auth = users.findUserWithId(p.getName(), "active");
        UsersEntity user = users.findUserWithIdAdmin(id);

        RoleEntity role = roles.findByRoles("admin");

        if (user.getRoles().contains(role)) return "redirect:/user/" + user.getId();

        model.addAttribute("auth", Auth);
        model.addAttribute("user", user);

        return "user-admin-update";
    }

    @RequestMapping(value = "/admin/modify", method = RequestMethod.GET) 
    public String UserModifyNotFound()
    {
        throw new NotFound();
    }

    @PostMapping(value = "/post", produces = "application/json")
    public String Post(PostEntity post, Principal p)
    {
        UsersEntity user = users.findUserWithId(p.getName(), "active");
        String[] time = LocalTime.now().toString().split(":");
        
        String timeText = time[0] + ":" + time[1] + " " + LocalDate.now();
        
        post.setUser_id(p.getName());
        post.setTime(timeText);
        post.setStatus("active");

        post.setPostuser(user);

        posts.save(post);

        return "redirect:/home";

    }
    
}
