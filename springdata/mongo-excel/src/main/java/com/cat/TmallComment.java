package com.cat;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * mongo 天猫数据
 */
@Data
@NoArgsConstructor
@Document(collection = "tmallcomments")
public class TmallComment {
    private String _id;
    private String seller_id;
    private String goods_id;
    /**
     * 平台
     */
    private String platform = "天猫";
    /**
     * 产品分类
     */
    private String goods_name;
    /**
     * 产品名称
     */
    private String title;
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
    private String rateDate;
    /**
     * 价格
     */
    private String price;
    /**
     * 发货地
     */
    private String location;
    /**
     * 店铺名称
     */
    private String shop_name;
    /**
     * 网址链接
     */
    private String detail_url;
}
