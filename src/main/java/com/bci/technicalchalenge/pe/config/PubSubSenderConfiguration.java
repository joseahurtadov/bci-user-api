package com.bci.technicalchalenge.pe.config;

import com.bci.technicalchalenge.pe.service.impl.PubSubMessagePublisherServiceSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PubSubSenderConfiguration {

  @Autowired
  private PubSubTemplate pubSubTemplate;

  @Bean
  PubSubMessagePublisherServiceSender pubSubMessagePublisherService() {
    return new PubSubMessagePublisherServiceSender(pubSubTemplate);
  }

}
