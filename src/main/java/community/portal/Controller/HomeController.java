package community.portal.Controller;

import java.security.Principal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import community.portal.Entity.SearchObject;
import community.portal.Entity.UsersEntity;
import community.portal.Repository.Users;

@Controller
public class HomeController 
{
    @Autowired
    Users users;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Principal p, Model model)
    {
        UsersEntity user = users.findUserWithId(p.getName(), "active");

        model.addAttribute("user", user);

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

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String Search(Principal p, Model model, SearchObject search)
    {
        UsersEntity user = users.findUserWithId(p.getName(), "active");
        List<UsersEntity> searchUser = new ArrayList<UsersEntity>();
        
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
}
