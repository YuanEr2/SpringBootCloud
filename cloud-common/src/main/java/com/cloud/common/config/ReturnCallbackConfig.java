package com.cloud.common.config;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 消息发送到队列的确认  一旦消息发送到队列失败 则会执行  returnedMessage 方法
 */
@Component
public class ReturnCallbackConfig implements RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct // @PostContruct是spring框架的注解，在⽅法上加该注解会在项⽬启动的时候执⾏该⽅法，也可以理解为在spring容器初始化的时候执
    public void init() {
        rabbitTemplate.setReturnsCallback(this);
    }

    /**
     * 消息发送到 队列失败 执行的 方法
     * @param returnedMessage the returned message and metadata.
     */
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        System.out.println("消息" + returnedMessage.getMessage().toString() + "被交换机" + returnedMessage.getExchange() + "回退！"
                + "退回原因为：" + returnedMessage.getReplyText());
        // 回退了所有的信息，可做补偿机制  记录到 数据库
    }
}
