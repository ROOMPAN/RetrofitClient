package com.joaye.hixgo.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyanjun on 15/10/24.
 */
public class CollectProductList extends BaseArrayObjectEntity<CollectProductList.CollectProductListData> {

    public class CollectProductListData {
        public String type;         //(热卖中的商品/即将开抢的商品)
        public List<Product> product = new ArrayList<Product>();
    }

    public class Product {
        public String id;
        public String productId;    //商品id
        public String productName;  //商品名称
        public String productLogo;  //商品logo
        public String startDate;    //浏览日期
        public String collectDate;  //活动结束时间
        public String stock;        //库存数
        public String status;       //商品上下架状态(1上架 2下架)
    }

}
