package com.app.ptever.domain.vo;

import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
@lombok.Data
public class FaqVO {
    
//    문의 번호
    private Integer faqId;
//    문의 제목
    private String faqTitle;
//    문의 내용
    private String faqContent;
//    문의 등록일
    private Data faqRegisterDate;
//    작성자의 id
    private Long userId;

}
