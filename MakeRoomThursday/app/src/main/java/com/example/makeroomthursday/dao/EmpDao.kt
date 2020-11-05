package com.example.makeroomthursday.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.makeroomthursday.models.EmployeeEntity

@Dao
interface EmpDao {

    @Insert
    fun saveEmp(emp: EmployeeEntity)

    @Query("select * from EmployeeEntity")
    fun readEmp() : List<EmployeeEntity>
}