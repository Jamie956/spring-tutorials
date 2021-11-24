package com.cat;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "tmallcomments")
public class TmallComment {
    private String _id;
    private String seller_id;
    private String goods_id;
    private String goods_name;
    private String rateDate;
    private String price;
    private String location;
    private String shop_name;
    private String title;
    private String detail_url;
    private Integer commentSum;
}
