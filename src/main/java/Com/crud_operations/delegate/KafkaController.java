package Com.crud_operations.delegate;

import Com.crud_operations.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg/api")
public class KafkaController {

    @Autowired
    private KafkaProducer  producer;

    @GetMapping("/prducemsg")
    public void getMessageFromClient(@RequestParam("message") String message) {
        producer.sendMessage(message);

    }
}
