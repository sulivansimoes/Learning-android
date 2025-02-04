package com.sulivan.mvvm_respository

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView


    class TaskAdapter(
        private val context: Context,
        private val tasks: List<TaskModel>
    ) : BaseAdapter() {
        override fun getCount(): Int {
            return tasks.size
        }

        override fun getItem(position: Int): Any {
            return tasks[position]
        }

        override fun getItemId(position: Int): Long {
            return tasks[position].id?.toLong() ?: 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            //Infla a listview personalizada
            val view = convertView ?: LayoutInflater.from(context)
                .inflate(R.layout.list_item_task, parent, false)

            //Pega os campos da view
            val titleTextView = view.findViewById<TextView>(R.id.titleTask)
            val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTask)
            val checkBox = view.findViewById<CheckBox>(R.id.checkBoxIsCompleted)

            //Seta os valores da view conforme parametro recebido no constrututor
            titleTextView.text = tasks[position].title
            descriptionTextView.text = tasks[position].description
            checkBox.isChecked = tasks[position].isCompleted

            //Retorna a view inflada e com valores setados
            return view
        }
    }
