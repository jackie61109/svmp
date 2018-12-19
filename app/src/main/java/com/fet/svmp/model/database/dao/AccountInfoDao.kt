package com.fet.svmp.model.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.fet.svmp.model.database.entities.AccountInfo

/**
 * Created by i_jackiechen1 on 2018/12/19 上午10:34.
 */
@Dao
interface AccountInfoDao {

    @Query("SELECT * FROM Account")
    fun getAll(): List<AccountInfo>


    @Query("SELECT * FROM Account WHERE Account.uid LIKE :uid ")
    fun findById(uid: Int): AccountInfo

    @Insert
    fun insertAll(vararg users: AccountInfo)

    @Delete
    fun delete(user: AccountInfo)
}
