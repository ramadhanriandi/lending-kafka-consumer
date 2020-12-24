package com.lending.consumer.service;

import com.lending.consumer.entity.MongoTransaction;

import java.util.List;

public interface MongoTransactionService {
  void create(MongoTransaction mongoTransaction);

  List<MongoTransaction> findByUserId(Integer userId);
}
