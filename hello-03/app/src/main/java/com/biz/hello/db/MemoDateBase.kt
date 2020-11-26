package com.biz.hello.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.biz.hello.model.MemoDao
import com.biz.hello.model.MemoVO
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [MemoVO::class],version = 1 ,exportSchema =false)
abstract class MemoDateBase : RoomDatabase() {

    abstract val memoDao : MemoDao

    companion object {
        private var INSTANCE : MemoDateBase? = null
        private  val NUMBER_THREADS = 5;

        val databaseWriterExcutor:ExecutorService = Executors.newFixedThreadPool(
            NUMBER_THREADS)
        fun getInstance(context : Context) : MemoDateBase? {
            if(INSTANCE == null){
                synchronized(MemoDateBase::class.java){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    MemoDateBase::class.java, "memo_datebase").build()
                }
            }
            return INSTANCE
        }
    }
}

