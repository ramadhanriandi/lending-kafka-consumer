package com.lending.consumer.service;

import com.lending.consumer.entity.MongoTransaction;
import com.lending.consumer.repository.MongoTransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MongoTransactionServiceBean implements MongoTransactionService {
  @Autowired
  private MongoTransactionRepository mongoTransactionRepository;

  @Override
  public List<MongoTransaction> findByUserId(Integer userId) {
    return mongoTransactionRepository.findAllByUserId(userId);
  }
}
