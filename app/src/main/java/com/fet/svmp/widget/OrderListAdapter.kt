package com.fet.svmp.widget

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fet.svmp.R
import com.fet.svmp.model.database.entities.OrderListData
import com.fet.svmp.model.database.entities.OrderListItem
import kotlinx.android.synthetic.main.adapter_transaction_list_item.view.*

/**
 * Created by i_jackiechen1 on 2019/1/14 下午5:19.
 */
class OrderListAdapter(context: Context) : RecyclerView.Adapter<OrderListAdapter.ViewHolder>() {

    var context = context

    var orderListItem: ArrayList<OrderListData> = ArrayList()

    public fun resetData(datas: List<OrderListData>) {
        orderListItem.clear()
        orderListItem.addAll(datas)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_transaction_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return orderListItem.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listData = orderListItem.get(position)
        holder.orderDate.text = listData.orderDate
        holder.orderName.text = listData.orderDesc
        holder.amount.text = listData.totalAmt
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val amount = view.text_amount
        val orderName = view.text_name
        val orderDate = view.text_date
    }
}
