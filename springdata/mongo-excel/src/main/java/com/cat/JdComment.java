package com.cat;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "jd_comment_data")
public class JdComment {
    private String comment_id;
    private String goods_id;
    private String platform;
    private String goods_type;
    private String goods_name;
    private String shop;
    private String created;
    private String ship_address;
    private String price;
    private Integer commentSum;
    private String keyword;
}
