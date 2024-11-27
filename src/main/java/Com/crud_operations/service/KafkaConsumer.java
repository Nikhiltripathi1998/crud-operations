package Com.crud_operations.service;


import org.hibernate.annotations.SecondaryRow;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "crud_topic", groupId = "crud-operation")
    public void consume(String message) {
        System.out.println("Consumed message:" + message);
    }

}
