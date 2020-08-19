package com.byoedele.popuphi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.student_template.view.*

class StudentsAdapter(val context: Context, private val students: List<Student>) :
    RecyclerView.Adapter<StudentsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.student_template, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return students.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student = students[position]
        holder.setData(student, position)
    }


    /**
     * An inner class to apply appropriate functions to each of the views as they are binded
     * is created below.
     * On initialization, an Onclick listener is set on each itemView (Each item body) to show
     * toast using the extended toast function on the Context. An onClick listener is also set on
     * each of the chat image to send an intent to share the formatted text implicitly.
     */

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentStudent: Student? = null
        var currentPos = 0

        init {
            itemView.setOnClickListener {
                context.showToast("Hi! Wanna chat with ${currentStudent!!.name}?")
            }

            itemView.imgShare.setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, "Hi ${currentStudent?.name}")
                intent.type = "text/plain"

                context.startActivity(Intent.createChooser(intent, "Chat with a Friend"))

            }
        }

        fun setData(student: Student?, position: Int) {
            itemView.txvTitle.text = student!!.name

            this.currentStudent = student
            this.currentPos = position
        }
    }
}