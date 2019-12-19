package mum.itweet.components.messages.publish;

import mum.itweet.model.dto.Message;
import mum.itweet.utitlity.ConstantKeys;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PostAddedMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void PostAddedMessageSender(Message message)
    {
        rabbitTemplate.convertAndSend(ConstantKeys.EXCHANGE, ConstantKeys.POST_ADDED_ROUTING_KEY, message);
    }
}
