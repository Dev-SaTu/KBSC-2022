package com.example.kb_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.Toast
import java.sql.DriverManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Class.forName("com.mysql.cj.jdbc.Driver")

        val sign_up_btn: Button = findViewById(R.id.sign_up_btn)
        sign_up_btn.setOnClickListener {

            val Intent = Intent(this,SignUpActivity::class.java)

            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)

            // var conn = ConnectSql.dbConn()
            var conn = DriverManager.getConnection("jdbc:mysql://database-1.cegbnrakdnsa.ap-northeast-2.rds.amazonaws.com:3306/kb_db", "gihwan", "1z2x3c4v")

            /*if (conn != null) {
                Toast.makeText(this@MainActivity, "conn is not null", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "conn is null", Toast.LENGTH_SHORT).show()
            }*/

            /*var stmt = conn?.createStatement()
            var rs = stmt?.executeQuery("select * from user")

            if (rs != null) {

                if (rs.next()) {

                    Toast.makeText(this@MainActivity, rs.getString(1), Toast.LENGTH_SHORT).show()

                } else {

                    Toast.makeText(this@MainActivity, "No", Toast.LENGTH_SHORT).show()

                }

            } else {

                Toast.makeText(this@MainActivity, "JANG", Toast.LENGTH_SHORT).show()

            }*/

            // startActivity(Intent)

        }
    }
}