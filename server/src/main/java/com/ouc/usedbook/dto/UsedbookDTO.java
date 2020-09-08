package com.ouc.usedbook.dto;

import com.ouc.usedbook.entity.Usedbook;
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
    private String coverimg;
    private String note;

    public Usedbook toUsedbook(String coverImg) {
        Usedbook usedbook = new Usedbook();
        usedbook.setBookname(bookname);
        usedbook.setPrice(price);
        usedbook.setAuthor(author);
        usedbook.setPublisher(publisher);
        usedbook.setRecency(recency);
        usedbook.setNote(note);
        usedbook.setCoverimg(coverImg);

        return usedbook;
    }
}
