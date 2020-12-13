package com.qingshan.simple;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

/**
 * @author: qingshan
 */
public class  SimpleProducer {
    public static void main(String[] args) {
        Properties pros=new Properties();
        pros.put("bootstrap.servers","192.168.1.2:9092,192.168.1.9:9092,192.168.1.10:9092");
//        pros.put("bootstrap.servers","8.131.93.74:9092");
        pros.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        pros.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        // 0 发出去就确认 | 1 leader 落盘就确认| all(-1) 所有Follower同步完才确认
        pros.put("acks","1");

        // 创建Sender线程
        Producer<String,String> producer = new KafkaProducer<String,String>(pros);

        for (int i =0 ;i<10;i++) {
            producer.send(new ProducerRecord<String,String>("mytopic",Integer.toString(i),Integer.toString(i)));
             System.out.println("发送:"+i);
        }

        //producer.send(new ProducerRecord<String,String>("mytopic","1","1"));
        //producer.send(new ProducerRecord<String,String>("mytopic","2","2"));

        producer.close();
    }
}
