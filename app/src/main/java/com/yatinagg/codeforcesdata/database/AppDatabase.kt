package com.yatinagg.codeforcesdata.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yatinagg.codeforcesdata.model.SubmissionItems

@Database(entities = [SubmissionItems::class], version = 2)
@TypeConverters(ResultConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun submissionDao(): SubmissionDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "myDB"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}