package community.portal.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomException 
{
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFound.class)
    public String Notfound()
    {
        System.out.println("404");
        return "404";
    }    

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(Forbidden.class)
    public String Forbidden()
    {
        return "403";
    }   
}
