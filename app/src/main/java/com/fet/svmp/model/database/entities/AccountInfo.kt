package com.fet.svmp.model.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by i_jackiechen1 on 2018/12/19 上午10:15.
 */
@Entity(tableName = "Account")
class AccountInfo {

    @PrimaryKey
    var uid: Int = 0

    @ColumnInfo(name = "account_name")
    var account: String? = null

    @ColumnInfo(name = "account_pass")
    var pass: String? = null

}
