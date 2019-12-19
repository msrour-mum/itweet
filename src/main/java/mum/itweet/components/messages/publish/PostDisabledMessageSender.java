package mum.itweet.components.messages.publish;

import mum.itweet.model.dto.Message;
import mum.itweet.utitlity.ConstantKeys;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostDisabledMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void PostDisabledMessageSender(Message message)
    {
        rabbitTemplate.convertAndSend(ConstantKeys.EXCHANGE, ConstantKeys.POST_DISABLED_ROUTING_KEY, message);
    }
}
