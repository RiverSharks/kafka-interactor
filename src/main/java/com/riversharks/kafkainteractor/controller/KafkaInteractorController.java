/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.riversharks.kafkainteractor.controller;

import com.riversharks.kafkainteractor.kafka.KafkaProducerProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class KafkaInteractorController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaProducerProperties kafkaProducerProperties;

    @PostMapping("/produce-event")
    public void produceSampleMessage(@RequestBody String message) {
        log.info("Event will be produced with payload:{}", message);
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send(kafkaProducerProperties.getTopic(), key, message);
        log.info("Message sent with key: {}",  key);
    }

}
