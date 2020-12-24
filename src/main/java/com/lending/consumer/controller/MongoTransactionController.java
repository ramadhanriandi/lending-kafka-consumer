package com.lending.consumer.controller;

import com.lending.consumer.entity.MongoTransaction;
import com.lending.consumer.model.response.GetUserTransactionsResponse;
import com.lending.consumer.model.response.ListBaseResponse;
import com.lending.consumer.service.MongoTransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = MongoTransactionControllerPath.BASE_PATH)
public class MongoTransactionController {
  @Autowired
  private MongoTransactionService mongoTransactionService;

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getUserTransactions(@NotBlank @RequestParam Integer userId) {
    List<MongoTransaction> mongoTransactionList = this.mongoTransactionService.findByUserId(userId);
    List<GetUserTransactionsResponse> userTransactionsResponseList = new ArrayList<>();

    for (MongoTransaction mongoTransaction : mongoTransactionList) {
      GetUserTransactionsResponse userTransactionsResponse = GetUserTransactionsResponse.builder().build();
      BeanUtils.copyProperties(mongoTransaction, userTransactionsResponse);
      userTransactionsResponseList.add(userTransactionsResponse);
    }

    return ResponseEntity.ok(new ListBaseResponse<>(null, null, true, userTransactionsResponseList));
  }
}
