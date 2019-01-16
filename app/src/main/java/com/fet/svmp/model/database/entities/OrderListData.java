package com.fet.svmp.model.database.entities;

/**
 * Created by i_jackiechen1 on 2019/1/14 下午5:17.
 */
public class OrderListData {

    /**
     * orderNo : UA000000000382
     * orderDate : 2016/04/06
     * orderStatus : F
     * orderInstance : L
     * orderDesc : 測式商品
     * totalAmt : 30
     */

    private String orderNo;
    private String orderDate;
    private String orderStatus;
    private String orderInstance;
    private String orderDesc;
    private String totalAmt;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderInstance() {
        return orderInstance;
    }

    public void setOrderInstance(String orderInstance) {
        this.orderInstance = orderInstance;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }
}
