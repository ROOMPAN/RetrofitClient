package com.joaye.hixgo.models;

/**
 * Created by xuyanjun on 15/10/24.
 */
public class BrowseList extends BaseArrayObjectEntity<BrowseList.BrowseListData> {

    public class BrowseListData {
        public String id;               //浏览记录id
        public String productId;        //商品id
        public String productName;      //商品名称
        public String productLogo;      //商品logo
        public String browseDate;       //浏览日期
    }

}
