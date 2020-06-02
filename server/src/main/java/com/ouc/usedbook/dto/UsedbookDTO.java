package com.ouc.usedbook.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/2 10:14
 */
@Data
public class UsedbookDTO {
    private Long uid;
    private String bookname;
    private Double price;
    private String author;
    private String publisher;
    private String recency;
    private MultipartFile coverimg;
    private String note;
}
