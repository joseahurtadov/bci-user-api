package com.bci.technicalchalenge.pe.thirdparty.external.pubsub;

import com.bci.technicalchalenge.pe.exception.BciException;
import com.bci.technicalchalenge.pe.service.impl.PubSubMessagePublisherServiceSender;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@Log4j2
@AllArgsConstructor
public class PubSubSenderService {

  private static final String TEST_TOPIC = "TEST_TOPIC";

  private final PubSubMessagePublisherServiceSender pubSubMessagePublisherService;

  @Async("threadPoolTaskExecutor")
  public void sendMessageToGCPPubSub(String payload) {
    try {
      log.debug("message send {}", payload);
      String commitId = pubSubMessagePublisherService.sendMessageToPubSubAndReturnMessageId(payload, TEST_TOPIC);
      log.debug("commitId {}", commitId);
    } catch (ExecutionException | InterruptedException e) {
      log.error(e.getMessage(), e);
      throw new BciException("ocurrio un error al enviar el mensage al topico: " + TEST_TOPIC, e);
    }
  }
}
