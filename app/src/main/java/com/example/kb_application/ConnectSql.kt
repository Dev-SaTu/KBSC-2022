package com.example.kb_application

import android.os.StrictMode
import android.util.Log
import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object ConnectSql {

    private val ip = "database-1.cegbnrakdnsa.ap-northeast-2.rds.amazonaws.com" // your database server ip
    private val db = "database-1" // your database name
    private val username = "gihwan" // your database username
    private val password = "1z2x3c4v@" // your database password

    fun dbConn() : Connection? {

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn : Connection? = null
        var connString: String? = null
        try {
            Class.forName("net.sourgeforge.jtds.jdbc.Driver")
            connString = "jdbc:jtds:sqlserver://$ip;databaseName=$db;user=$username;password=$password;"
            conn = DriverManager.getConnection(connString)
        }catch (ex: SQLException){
            Log.e("Error : ", ex.message.toString())
        }catch (ex1: ClassNotFoundException){
            Log.e("Error : ", ex1.message.toString())
        }catch (ex2: Exception){
            Log.e("Error : ", ex2.message.toString())
        }

        return conn
    }
}