package com.qingshan.assign;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author: qingshan
 */
public class ProducerSendTest {
    public static void main(String[] args) {
        Properties props=new Properties();
        //props.put("bootstrap.servers","192.168.44.161:9093,192.168.44.161:9094,192.168.44.161:9095");
        props.put("bootstrap.servers","192.168.44.160:9092");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        // 0 发出去就确认 | 1 leader 落盘就确认| all 所有Follower同步完才确认
        props.put("acks","1");
        // 异常自动重试次数
        props.put("retries",3);
        // 多少条数据发送一次，默认16K
        props.put("batch.size",16384);
        // 批量发送的等待时间
        props.put("linger.ms",5);
        // 客户端缓冲区大小，默认32M，满了也会触发消息发送
        props.put("buffer.memory",33554432);
        // 获取元数据时生产者的阻塞时间，超时后抛出异常
        props.put("max.block.ms",3000);

        Producer<String,String> producer = new KafkaProducer<String,String>(props);

        producer.send(new ProducerRecord<String,String>("ass5part",0,"0","0"));
        producer.send(new ProducerRecord<String,String>("ass5part",1,"1","1"));
        producer.send(new ProducerRecord<String,String>("ass5part",2,"2","2"));
        producer.send(new ProducerRecord<String,String>("ass5part",3,"3","3"));
        producer.send(new ProducerRecord<String,String>("ass5part",4,"4","4"));

        producer.close();
    }

}
