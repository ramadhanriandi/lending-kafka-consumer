package com.lending.consumer.service;

import com.lending.consumer.entity.MongoTransaction;

import java.util.List;

public interface MongoTransactionService {
  List<MongoTransaction> findByUserId(Integer userId);
}
