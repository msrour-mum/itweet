package mum.itweet.components.messages.listener;

import mum.itweet.components.email.IEmailService;
import mum.itweet.model.Post;
import mum.itweet.model.dto.Message;
import mum.itweet.model.lookups.PostStatus;
import mum.itweet.service.PostService;
import mum.itweet.service.UserService;
import mum.itweet.utitlity.ConstantKeys;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {ConstantKeys.POST_ADDED_QUEUE_NAME})
public class PostAddedMessagesListener {

    //private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    IEmailService emailService;

    @Value("${email.template.badPost.title}")
    String emailTitle;
    @Value("${email.template.badPost.body}")
    String emailBody;

    @RabbitHandler
    public void receiveMessage(Message message)
    {
        System.out.println(ConstantKeys.POST_ADDED_QUEUE_NAME+
                ": receive messaged post added [" + message.getId() + "] ");

        Post post = postService.get(message.getId());
        if(postService.isPostContainBadWords(post.getPostText()))
        {
            post.setStatus(PostStatus.Pending);
            postService.update(post);

            emailBody = emailBody.replace("##EMAIL##", post.getUser().getEmail());
            emailBody = emailBody.replace("##POST_ID##", Long.toString(post.getId()));
            emailService.sendMail(emailTitle, emailBody, "msrour@mum.edu", "mzein@mum.edu");
        }
    }
}
