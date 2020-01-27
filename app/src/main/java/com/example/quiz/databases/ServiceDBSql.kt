package com.example.quiz.databases

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.example.quiz.databases.model.ResultOfGame

class ServiceDBSql(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "ResultsDatabase"
        private const val TABLE_RESULTS = "ResultsTable"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_POINTS = "points"
        private const val KEY_REGIME = "regime"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val createTableCommand = ("CREATE TABLE " + TABLE_RESULTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT," + KEY_POINTS + " TEXT,"
                + KEY_REGIME + " TEXT" + ")")
        p0?.execSQL(createTableCommand)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS $TABLE_RESULTS")
        onCreate(p0)
    }

    fun addResult(result: ResultOfGame){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_NAME, result.nameOfGamer)
        contentValues.put(KEY_POINTS, result.points)
        contentValues.put(KEY_REGIME, result.regime)
        db.insert(TABLE_RESULTS, null, contentValues)
        db.close()
    }

    fun viewResults() : List<ResultOfGame>{
        val resultList : MutableList<ResultOfGame> = mutableListOf()
        val selectQuery = "SELECT  * FROM $TABLE_RESULTS"
        val db = this.readableDatabase
        var cursor: Cursor?
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var nameOfGamer: String
        var points: String
        var regime: String
        if (cursor.moveToFirst()) {
            do {
                nameOfGamer = cursor.getString(cursor.getColumnIndex("name"))
                points = cursor.getString(cursor.getColumnIndex("points"))
                regime = cursor.getString(cursor.getColumnIndex("regime"))
                val result = ResultOfGame(nameOfGamer, points, regime)
                resultList.add(result)
            } while (cursor.moveToNext())
        }
        return resultList
    }
}