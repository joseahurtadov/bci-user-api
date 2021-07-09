package com.bci.technicalchalenge.pe.service;

import java.util.concurrent.ExecutionException;

/**
 * |description|.<br/>
 * <b>Class</b>: PubSubMessagePublisherService<br/>
 * <b>Copyright</b>: &copy; 2020 Intercorp Retail.<br/>
 * <b>Company</b>: Intercorp Retail.<br/>
 *
 * @author Intercorp Retail <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>PM42722316 : Jose Hurtado</li>
 * </ul>
 * <u>Create</u>:<br/>
 * <ul>
 * <li>Set. 03, 2020 Creaci&oacute;n de Clase.</li>
 * </ul>
 * @version 1.0
 */
public interface PubSubMessagePublisherService {

  void sendMessageToPubSub(String messageJsonPayload, String topicId);

  String sendMessageToPubSubAndReturnMessageId(String messageJsonPayload, String topicId)
      throws ExecutionException, InterruptedException;

}
