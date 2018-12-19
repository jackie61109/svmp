package com.fet.svmp

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.fet.svmp.model.database.dao.AccountInfoDao
import com.fet.svmp.model.database.entities.AccountInfo

/**
 * Created by i_jackiechen1 on 2018/12/19 上午10:14.
 */
@Database(entities = arrayOf(AccountInfo::class), version = 1)
abstract class SvmpDataBase : RoomDatabase() {
    abstract fun AccountInfoDao(): AccountInfoDao

    companion object {

        /**
         * The only instance
         */
        private var sInstance: SvmpDataBase? = null

        /**
         * Gets the singleton instance of SampleDatabase.
         *
         * @param context The context.
         * @return The singleton instance of SampleDatabase.
         */
        @Synchronized
        fun getInstance(context: Context): SvmpDataBase {
            if (sInstance == null) {
                sInstance = Room
                        .databaseBuilder(context.applicationContext, SvmpDataBase::class.java, "svmp")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
            }
            return sInstance!!
        }
    }
}
