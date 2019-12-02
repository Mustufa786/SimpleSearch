package com.codixlab.simplesearch

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: SimpleRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    private fun init() {

        var list: ArrayList<Data> = getData(this)
        list.addAll(getData(this))
        adapter = SimpleRecyclerViewAdapter(this, list)
        simpleList.layoutManager = LinearLayoutManager(this)
        simpleList.setHasFixedSize(true)
        simpleList.adapter = adapter


    }

    fun getData(context: Context): ArrayList<Data> {

        val people = ArrayList<Data>()
        val data = context.resources.getStringArray(R.array.people)
        val images = context.resources.obtainTypedArray(R.array.images)

        for (i in data.indices) {
            val d = Data(data[i], "", images.getResourceId(i, -1))
            people.add(d)
        }

        return people

    }


}
