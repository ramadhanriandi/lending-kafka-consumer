package com.lending.consumer.consumer;

import com.lending.consumer.entity.MongoTransaction;
import com.lending.consumer.service.MongoTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class KafkaConsumer {
  @Autowired
  private MongoTransactionService mongoTransactionService;

  @KafkaListener(topics = "lending-transaction-topic", groupId = "group_id")
  public void consume(String message) {
    String parsedMessage = message.substring(12, message.length() - 1);
    String[] pairs = parsedMessage.split(", ");

    MongoTransaction mongoTransaction = new MongoTransaction();
    mongoTransaction.setTransactionId(Integer.parseInt(pairs[0].split("=")[1]));
    mongoTransaction.setAmount(Double.parseDouble(pairs[1].split("=")[1]));

    String rawDate = pairs[2].split("=")[1];
    String parsedDate = rawDate.substring(0, 10) + rawDate.substring(23);
    mongoTransaction.setTransactionDate(new Date(parsedDate));
    mongoTransaction.setTransactionType(pairs[3].split("=")[1]);
    mongoTransaction.setUserId(Integer.parseInt(pairs[4].split("=")[1]));

    mongoTransactionService.create(mongoTransaction);
  }
}
