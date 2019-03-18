package com.fet.svmp.model.database.dao

import android.arch.persistence.room.*
import com.fet.svmp.model.database.entities.AccountInfo
import io.reactivex.Flowable

/**
 * Created by i_jackiechen1 on 2018/12/19 上午10:34.
 */
@Dao
interface AccountInfoDao {

    @Query("SELECT * FROM Account")
    fun getAll(): List<AccountInfo>?

    @Query("SELECT * FROM Account WHERE Account.uid LIKE :uid ")
    fun findById(uid: Int): AccountInfo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: AccountInfo)

    @Query("DELETE FROM Account")
    fun deleteAll()

    @Query("SELECT Account.time FROM Account WHERE Account.uid LIKE :uid ")
    fun getTime(uid: Int) : Flowable<Long>

}
