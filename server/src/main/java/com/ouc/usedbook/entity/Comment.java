package com.ouc.usedbook.entity;
import com.ouc.usedbook.dto.CommentDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * 评论
 *
 * @author 孙浩杰
 * @date 2020/06/01
 */
@Entity
@Data
@NoArgsConstructor
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long uid;
  private long bid;
  private Date date;
  private String content;

  public Comment(CommentDTO commentDTO){
    this.uid = commentDTO.getUid();
    this.bid = commentDTO.getBid();
    this.content = commentDTO.getComment();
    this.date = new Date(System.currentTimeMillis());
  }
}
