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
    /**
     * 平台
     */
    private String platform = "京东";
    /**
     * 产品分类
     */
    private String goods_type;
    /**
     * 产品名称
     */
    private String goods_name;
    /**
     * 关键词命中
     */
    private String keyword;
    /**
     * 品牌（无）
     */
    /**
     * 全年评论数
     */
    private Integer commentSum;
    /**
     * 销量（无）
     */
    /**
     * 最后一次更新时间
     */
    private String created;
    /**
     * 价格
     */
    private String price;
    /**
     * 发货地
     */
    private String ship_address;
    /**
     * 店铺名称
     */
    private String shop;
    /**
     * 网址链接（无）
     */
}
