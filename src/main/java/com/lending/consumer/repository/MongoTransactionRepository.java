package com.lending.consumer.repository;

import com.lending.consumer.entity.MongoTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoTransactionRepository extends MongoRepository<MongoTransaction, Integer> {
  List<MongoTransaction> findAllByUserId(Integer userId);
}
