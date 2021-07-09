package com.bci.technicalchalenge.pe.service.impl;

import com.bci.technicalchalenge.pe.service.PubSubMessagePublisherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;


import java.util.concurrent.ExecutionException;


@Service
@Slf4j
@AllArgsConstructor
public class PubSubMessagePublisherServiceSender implements PubSubMessagePublisherService {

  private PubSubTemplate pubSubTemplate;

  // envia mensaje pubsub y no retorna commit id
  @Override
  public void sendMessageToPubSub(String messageJsonPayload, String topicId) {
    this.pubSubTemplate.publish(topicId,
        messageJsonPayload);
  }

  // envia mensaje pubsub y retorna commit id
  @Override
  public String sendMessageToPubSubAndReturnMessageId(String messageJsonPayload, String topicId)
      throws ExecutionException, InterruptedException {
    ListenableFuture<String> future = this.pubSubTemplate.publish(topicId,
        messageJsonPayload);
    log.debug("pub sub message id: {}", future.get());
    return future.get();
  }

}
