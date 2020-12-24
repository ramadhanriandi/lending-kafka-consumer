package com.lending.consumer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = MongoTransaction.COLLECTION_NAME)
public class MongoTransaction {
  public static final String COLLECTION_NAME = "transactions";

  public static final String FIELD_TRANSACTION_ID = "transaction_id";
  public static final String FIELD_AMOUNT = "amount";
  public static final String FIELD_TRANSACTION_DATE = "transaction_date";
  public static final String FIELD_TRANSACTION_TYPE = "transaction_type";
  public static final String FIELD_USER_ID = "user_id";

  @Field(value = MongoTransaction.FIELD_TRANSACTION_ID)
  private int transactionId;

  @Field(value = MongoTransaction.FIELD_AMOUNT)
  private double amount;

  @Field(value = MongoTransaction.FIELD_TRANSACTION_DATE)
  private Date transactionDate;

  @Field(value = MongoTransaction.FIELD_TRANSACTION_TYPE)
  private String transactionType;

  @Field(value = MongoTransaction.FIELD_USER_ID)
  private int userId;

}
