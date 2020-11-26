package com.jamie;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private ConsumerFactory consumerFactory;

    // 消息过滤器
    @Bean
    public ConcurrentKafkaListenerContainerFactory filterContainerFactory() {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory);
        // 被过滤的消息将被丢弃
        factory.setAckDiscarded(true);
        // 消息过滤策略
        factory.setRecordFilterStrategy(consumerRecord -> {
//            if (Integer.parseInt(consumerRecord.value().toString()) % 2 == 0) {
//                return false;
//            }
            if(consumerRecord.toString().contains("!")){
                return false;
            }
            //返回true消息则被过滤
            return true;
        });
        return factory;
    }


    @Bean
    public ConsumerAwareListenerErrorHandler consumerAwareErrorHandler() {
        return (message, exception, consumer) -> {
            System.out.println("消费异常：" + message.getPayload());
            return null;
        };
    }

//    @KafkaListener(topics = {"test_topic"})
//    public void receive(String message){
//        System.out.println("消费消息:" + message);
//    }

//    @KafkaListener(topics = {"test_topic"})
//    public void onMessage1(ConsumerRecord<?, ?> record) {
//        System.out.println("topic: " + record.topic() + "    partition: " + record.partition() + "     value: " + record.value());
//    }

//    @KafkaListener(id = "consumer1", groupId = "test-consumer-group", topicPartitions = {
//        @TopicPartition(topic = "test_topic", partitions = {"0"}),
//        @TopicPartition(topic = "test_topic2", partitions = "0", partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "8"))})
//    public void onMessage2(ConsumerRecord<?, ?> record) {
//        System.out.println("topic:" + record.topic() + "|partition:" + record.partition() + "|offset:" + record.offset() + "|value:" + record.value());
//    }

    /**
     * # 设置批量消费
     * spring.kafka.listener.type=batch
     * # 批量消费每次最多消费多少条消息
     * spring.kafka.consumer.max-poll-records=5
     */
//    @KafkaListener(id = "consumer2", groupId = "test-consumer-group", topics = "test_topic")
//    public void onMessage3(List<ConsumerRecord<?, ?>> records) {
//        System.out.println(">>>批量消费一次，records.size()=" + records.size());
//        for (ConsumerRecord<?, ?> record : records) {
//            System.out.println(record.value());
//        }
//    }

    /**
     *
     */
//    @KafkaListener(topics = {"test_topic"}, errorHandler = "consumerAwareErrorHandler")
//    public void onMessage4(ConsumerRecord<?, ?> record) throws Exception {
//        throw new Exception("模拟异常");
//    }


    // 消息过滤监听
//    @KafkaListener(topics = {"test_topic"}, containerFactory = "filterContainerFactory")
//    public void onMessage6(ConsumerRecord<?, ?> record) {
//        System.out.println(record.value());
//    }

    @KafkaListener(topics = {"topic1"})
    @SendTo("topic2")
    public String onMessage7(ConsumerRecord<?, ?> record) {
        return record.value()+"     -forward message";
    }
}