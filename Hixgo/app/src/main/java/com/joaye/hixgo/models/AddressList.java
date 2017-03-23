package com.joaye.hixgo.models;

/**
 * Created by xuyanjun on 15/10/24.
 */
public class AddressList extends BaseArrayObjectEntity<AddressList.AddressListData> {

    public class AddressListData {
        public String id;
        public String name;             //收货人
        public String mobile;           //手机号
        public String cardId;           //身份证号
        public String provinceNo;       //省编号
        public String provinceName;     //省名字
        public String cityNo;           //市编号
        public String cityName;         //市名字
        public String areaNo;           //区编号
        public String areaName;         //区名称
        public String _default;         //是否默认(1默认2不默认)
        public String address;          //详细地址
    }

}
