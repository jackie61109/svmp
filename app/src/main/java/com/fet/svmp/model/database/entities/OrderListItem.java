package com.fet.svmp.model.database.entities;

import java.util.List;

/**
 * Created by i_jackiechen1 on 2019/1/14 下午5:15.
 */
public class OrderListItem {

    /**
     * total : 1
     * page : 1
     * split : 10
     * datas : [{"orderNo":"UA000000000382","orderDate":"2016/04/06","orderStatus":"F","orderInstance":"L","orderDesc":"測式商品","totalAmt":"30"},{"orderNo":"UA000000000381","orderDate":"2016/04/06","orderStatus":"F","orderInstance":"L","orderDesc":"測式商品","totalAmt":"30"},{"orderNo":"UA000000000382","orderDate":"2016/04/06","orderStatus":"F","orderInstance":"L","orderDesc":"測式商品","totalAmt":"30"},{"orderNo":"UA000000000381","orderDate":"2016/04/06","orderStatus":"F","orderInstance":"L","orderDesc":"測式商品","totalAmt":"30"},{"orderNo":"UA000000000382","orderDate":"2016/04/06","orderStatus":"F","orderInstance":"L","orderDesc":"測式商品","totalAmt":"30"},{"orderNo":"UA000000000381","orderDate":"2016/04/06","orderStatus":"F","orderInstance":"L","orderDesc":"測式商品","totalAmt":"30"},{"orderNo":"UA000000000382","orderDate":"2016/04/06","orderStatus":"F","orderInstance":"L","orderDesc":"測式商品","totalAmt":"30"},{"orderNo":"UA000000000381","orderDate":"2016/04/06","orderStatus":"F","orderInstance":"L","orderDesc":"測式商品","totalAmt":"30"},{"orderNo":"UA000000000382","orderDate":"2016/04/06","orderStatus":"F","orderInstance":"L","orderDesc":"測式商品","totalAmt":"30"},{"orderNo":"UA000000000381","orderDate":"2016/04/06","orderStatus":"F","orderInstance":"L","orderDesc":"測式商品","totalAmt":"30"}]
     */

    private int total;
    private int page;
    private int split;
    private List<OrderListData> datas;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSplit() {
        return split;
    }

    public void setSplit(int split) {
        this.split = split;
    }

    public List<OrderListData> getDatas() {
        return datas;
    }

    public void setDatas(List<OrderListData> datas) {
        this.datas = datas;
    }


}
