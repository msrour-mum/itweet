package mum.itweet.components.messages.listener;

import mum.itweet.components.email.IEmailService;
import mum.itweet.model.Post;
import mum.itweet.model.User;
import mum.itweet.model.dto.Message;
import mum.itweet.service.PostService;
import mum.itweet.service.UserService;
import mum.itweet.utitlity.ConstantKeys;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {ConstantKeys.POST_DISABLED_QUEUE_NAME})
public class PostDisabledMessagesListener {

    //private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    IEmailService emailService;

    @Value("${email.template.deactivatedUser.title}")
    String emailTitle;
    @Value("${email.template.deactivatedUser.body}")
    String emailBody;
    @Value("${badPosts.threshold.count}")
    int count;

    @RabbitHandler
    public void receiveMessage(Message message)
    {
        System.out.println( ConstantKeys.POST_DISABLED_QUEUE_NAME + ": receive message  [" + message.getId() + "] ");

        Post post = postService.get(message.getId());
        int badPostsCount = postService.getDisabledPostCountPerUser(post.getUser().getId());
        if(badPostsCount > count)
        {
            //Deactivate user
            User user = userService.get(post.getUser().getId());
            user.setActive(false);
            userService.update(user);
            //send email
            emailBody = emailBody.replace("##EMAIL##", post.getUser().getEmail());
            emailService.sendMail(emailTitle, emailBody, user.getEmail(), "msrour@mum.edu");
        }
    }
}
