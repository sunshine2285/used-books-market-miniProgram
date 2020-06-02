package com.ouc.usedbook.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * usedbook
 *
 * @author 孙浩杰
 * @date 2020/06/01
 */
@Entity
@Data
@NoArgsConstructor
public class Usedbook {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long uid;
  private String bookname;
  private double price;
  private String author;
  private String publisher;
  private String recency;
  private String coverimg;
  private String note;
}
