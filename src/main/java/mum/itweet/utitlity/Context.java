package mum.itweet.utitlity;

import mum.itweet.security.JPAUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

public class Context {

    public static JPAUserDetails getUser()
    {
       return (JPAUserDetails) SecurityContextHolder
               .getContext()
               .getAuthentication()
               .getPrincipal();
    }

    public static int getUserId()
    {
        return getUser().getId();
    }
    public static String getUserIdAsString()
    {
        return Integer.toString(getUser().getId());
    }
    public static String getUserName()
    {
       return getUser().getUsername();
    }
}
