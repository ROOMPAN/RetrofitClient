package com.joaye.hixgo.models;

import java.util.ArrayList;

/**
 * Created by xuyanjun on 15/11/1.
 */
public class VirtualList extends BaseArrayObjectEntity<VirtualList.VirtualListData> {

    public class VirtualListData {
        public int id;
        public String code;
        public String name;
        public String logo;
        public String banner;
        public ArrayList<Child> children = new ArrayList<Child>();

        public class Child {
            public String id;
            public String code;
            public String name;
            public String logo;
            public String banner;
            public ArrayList<Child> children = new ArrayList<Child>();
        }
    }
}
