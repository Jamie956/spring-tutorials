package com.jamie;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

@Component
public class Producer {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void send() {
        kafkaTemplate.send("test_topic", "this is content!");
    }

    public void send2() {
        kafkaTemplate.send("test_topic", "this is content!!").addCallback(success -> {
            assert success != null;
            RecordMetadata metadata = success.getRecordMetadata();
            String topic = metadata.topic();
            int partition = metadata.partition();
            long offset = metadata.offset();
            System.out.println("发送消息成功: " + topic + "    " + partition + "   " + offset);
        }, failure -> {
            System.out.println("发送消息失败: " + failure.getMessage());
        });
    }

    public void send3() {
        kafkaTemplate.send("test_topic", "this is content!!!").addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("发送消息失败：" + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                System.out.println("发送消息成功：" + result.getRecordMetadata().topic() + "       " + result.getRecordMetadata().partition() + "      " + result.getRecordMetadata().offset());
            }
        });
    }


}
