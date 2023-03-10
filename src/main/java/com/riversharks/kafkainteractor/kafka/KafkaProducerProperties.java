package com.riversharks.kafkainteractor.kafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "integration.kafka.producer.sample")
public class KafkaProducerProperties {
    private String bootstrapServers;
    private String topic;

}
