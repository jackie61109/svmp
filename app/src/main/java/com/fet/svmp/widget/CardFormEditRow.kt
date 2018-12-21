package com.fet.svmp.widget

import android.content.Context
import android.databinding.BindingMethod
import android.databinding.BindingMethods
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.fet.svmp.R

@BindingMethods(BindingMethod(type = com.fet.svmp.widget.CardFormEditRow::class, attribute = "valueText", method = "setValue"))
class CardFormEditRow @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : RelativeLayout(context, attrs) {

    private val mTxtValue: TextView
    private val bottomDivider: View

    init {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val row = inflater.inflate(R.layout.row_setting_info, this, true)

        val a = context.obtainStyledAttributes(attrs, R.styleable.CardFormEditRow, 0, 0)
        val iconDrawable = a.getDrawable(R.styleable.CardFormEditRow_iconDrawable)
        val labelText = a.getString(R.styleable.CardFormEditRow_labelText)
        val valueText = a.getString(R.styleable.CardFormEditRow_valueText)
        val isShowDivider = a.getBoolean(R.styleable.CardFormEditRow_showBottomDivider, false)

        a.recycle()

        val txtLabel = row.findViewById<TextView>(R.id.txt_row_label)
        if (null != iconDrawable) {
            val imgIcon = row.findViewById<ImageView>(R.id.img_icon)
            imgIcon.setImageDrawable(iconDrawable)
        }

        txtLabel.text = labelText

        mTxtValue = row.findViewById(R.id.txt_row_value)
        setValue(valueText ?: "")
        bottomDivider = row.findViewById(R.id.row_divider)
        isShowBottomDivider(isShowDivider)
    }

    fun setValue(value: String) {
        mTxtValue.text = value
    }

    private fun isShowBottomDivider(isShow: Boolean) {
        if (isShow) {
            bottomDivider.visibility = View.VISIBLE
        } else {
            bottomDivider.visibility = View.GONE
        }
    }
}
