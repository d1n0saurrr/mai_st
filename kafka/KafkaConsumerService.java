import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaConsumerService {

    private final YourService yourService;

    @Autowired
    public KafkaConsumerService(YourService yourService) {
        this.yourService = yourService;
    }

    @KafkaListener(topics = "your-topic", groupId = "your-group-id")
    public void consume(YourMessageClass message) {
        log.debug("Received message: {}", message);
        // Example: Save message to database
        yourService.processMessage(message);
    }
}
