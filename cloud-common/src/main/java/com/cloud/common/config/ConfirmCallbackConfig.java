package com.cloud.common.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 消息发送确认配置 ： 发送到交换机的确认
 */
@Component
@Log4j2
public class ConfirmCallbackConfig implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct // @PostContruct是spring框架的注解，在⽅法上加该注解会在项⽬启动的时候执⾏该⽅法，也可以理解为在spring容器初始化的时候执
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
    }

    /**
     * 交换机不管是否收到消息的一个回调方法 ： 消息的生产者发送消息给交换机，不管交换是否接收到消息都会 执行这个回调方法
     *
     * @param correlationData 消息相关数据
     * @param ack             交换机是否收到消息
     * @param cause           失败原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) { // 消息投递到broker 的状态，true表示成功
            log.info("消息发送成功！");
        } else { // 发送异常
            log.error("消息发送异常，异常原因：{}", cause);
        }
    }
}
