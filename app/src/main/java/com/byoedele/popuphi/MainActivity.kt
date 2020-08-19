package com.byoedele.popuphi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }


    /**
     * The RecyclerView is set up below to make the onCreate method cleaner and easier to read
     * The StudentsAdapter class is used as the Adapter.
     */
private fun setupRecyclerView() {
    val layoutManager = LinearLayoutManager(this)
    layoutManager.orientation = LinearLayoutManager.VERTICAL
    recyclerView.layoutManager = layoutManager

    val adapter = StudentsAdapter(
        this,
        Supplier.students
    )
    recyclerView.adapter = adapter
}
}