package com.example.makeroomthursday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.makeroomthursday.dao.AppDb
import com.example.makeroomthursday.models.EmployeeEntity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("DEBUG", "APP IS LOADING")

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "EmployeeDb").build()

        Thread {
            Log.i("ROOMBB", "Starting Thread - Saving to Database")

            var emp = EmployeeEntity()

            emp.emp_id = 1
            emp.emp_name = "Greg"
            emp.emp_post = "LeBeau"

            db.empDao().saveEmp(emp)

            emp.emp_id = 2
            emp.emp_name = "Yaya"
            emp.emp_post = "LeMoche"

            Log.i("ROOMDB", emp.emp_name)
            db.empDao().saveEmp(emp)

        }.start()

        Thread{
            Log.i("ROOMBB", "Starting Thread - Reading to Database")
        }

        var emp = EmployeeEntity()

        emp.emp_id = 1
        emp.emp_name= "Greg"
        emp.emp_post= "LeBeau"

        Log.i("ROOMDB", emp.emp_name)

        db.empDao().saveEmp(emp)

        emp.emp_id = 2
        emp.emp_name = "Yaya"
        emp.emp_post = "LeMoche"

        Log.i("ROOMDB", emp.emp_name)

        db.empDao().saveEmp(emp)

        for (emp in db.empDao().readEmp())
            Log.i("ROOMDB", emp.emp_id.toString())
            Log.i("ROOMDB", emp.emp_name)
            Log.i("ROOMDB", emp.emp_post)

        
    }
}