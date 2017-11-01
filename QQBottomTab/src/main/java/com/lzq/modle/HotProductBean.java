package com.lzq.modle;

import java.util.List;

/**
 * Created by ${廖昭启} on 2017/6/15.
 */

public class HotProductBean extends BaseResponse{

    /**
     * listCount : 15
     * productList : [{"id":22,"marketPrice":200,"name":"新款毛衣","pic":"/images/product/detail/q20.jpg","price":160},{"id":25,"marketPrice":150,"name":"新款秋装","pic":"/images/product/detail/q23.jpg","price":160},{"id":26,"marketPrice":200,"name":"粉色系暖心套装","pic":"/images/product/detail/q24.jpg","price":200},{"id":27,"marketPrice":150,"name":"韩版粉嫩外套","pic":"/images/product/detail/q25.jpg","price":160},{"id":28,"marketPrice":300,"name":"春装新款","pic":"/images/product/detail/q26.jpg","price":200},{"id":29,"marketPrice":180,"name":"日本奶粉","pic":"/images/product/detail/q26.jpg","price":160},{"id":30,"marketPrice":200,"name":"超凡奶粉","pic":"/images/product/detail/q26.jpg","price":160},{"id":31,"marketPrice":260,"name":"天籁牧羊奶粉","pic":"/images/product/detail/q26.jpg","price":200},{"id":32,"marketPrice":300,"name":"fullcare奶粉","pic":"/images/product/detail/q26.jpg","price":300},{"id":33,"marketPrice":300,"name":"雀巢奶粉","pic":"/images/product/detail/q26.jpg","price":200}]
     */

    public int listCount;
    /**
     * id : 22
     * marketPrice : 200
     * name : 新款毛衣
     * pic : /images/product/detail/q20.jpg
     * price : 160
     */

    public List<ProductListBean> productList;

    public static class ProductListBean {
        public int id;
        public int marketPrice;
        public String name;
        public String pic;
        public int price;
    }

    @Override
    public String toString() {
        return "HotProductBean{" +
                "listCount=" + listCount +
                ", productList=" + productList +
                '}';
    }
}
