package com.fet.svmp.view

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.fet.svmp.R
import com.fet.svmp.SvmpDataBase
import com.fet.svmp.customize.Configs
import com.fet.svmp.databinding.ActivityTransactionListBinding
import com.fet.svmp.model.database.entities.AccountInfo
import com.fet.svmp.model.database.entities.OrderListItem
import com.fet.svmp.viewmodel.TransactionListViewModel
import com.fet.svmp.widget.OrderListAdapter
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_transaction_list.*
import java.util.*


/**
 * Created by i_jackiechen1 on 2018/11/30 上午10:21.
 */
class TransactionListActivity : BaseActivity() {

    private val adapter: OrderListAdapter = OrderListAdapter(this)

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, TransactionListActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityTransactionListBinding>(this, R.layout.activity_transaction_list)
        binding.vm = TransactionListViewModel(SvmpDataBase.getInstance(this).AccountInfoDao(), this)

        setToolBar(this, R.string.title_activity_transaction_list)

        transaction_list.layoutManager = LinearLayoutManager(this)
        transaction_list.adapter = adapter

        getResponse()

        Timer(true).schedule(object:TimerTask(){
            override fun run() {
                val item = AccountInfo()
                item.uid = 0
                item.time = Date().time
                SvmpDataBase.getInstance(applicationContext).AccountInfoDao().insert(item)
                Logger.d("Time milliseconds = " + item.time)
            }

        },5000,5000)
    }

    private fun getResponse() {
//        val getRequest = JsonArrayRequest(Request.Method.GET, Configs.TEST_URL + "wp/v2/posts/?page=" + 1, null,
//                Response.Listener<JSONArray> { response ->
//                    // display response
//                    Logger.d(response.toString() + "Size: " + response.length())
//        val raw = resources.openRawResource(resources.getIdentifier("db.json","raw", packageName))
//        val a = BufferedReader(InputStreamReader(raw,"UTF8"))
//        val response = a.readLine()
        val orderListItem: OrderListItem = Gson().fromJson(Configs.TEST_RESPONSE, OrderListItem::class.java)
        adapter.resetData(orderListItem.datas)
//                    for (i in 0 until response.length()) {
//                        val post = Posts()
//                        try {
//                            Logger.d("Object at " + i + response.get(i))
//                            val obj = response.getJSONObject(i)
//                            post.id = obj.getInt("id")
//                            post.createdAt = obj.getString("date")
//                            post.postURL = obj.getString("link")
//                            val titleObj = obj.getJSONObject("title")
//                            post.title = titleObj.getString("rendered")
//                            mPosts.add(post)
//
//
//                        } catch (e: JSONException) {
//                            e.printStackTrace()
//                        }
//
//                    }
//
//                    setData(mPosts)
//                },
//                Response.ErrorListener { error -> Logger.d(error.toString()) }
//        )

//        val requestQueue = Volley.newRequestQueue(this)
//        requestQueue.add(getRequest)
    }
}