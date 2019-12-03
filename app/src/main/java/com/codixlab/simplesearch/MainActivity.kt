package com.codixlab.simplesearch

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: SimpleRecyclerViewAdapter

    lateinit var filteredList: ArrayList<Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    /*
       inti method to initilize recyclerView and list
     */
    private fun init() {

        var list: ArrayList<Data> = getData(this)
        list.addAll(getData(this))
        setupRecyclerView(list)
        mSearchName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                filteredList = ArrayList()
                if (p0.toString() != "") {
                    for (item in list) {
                        if (item.name.toLowerCase().contains(p0.toString().toLowerCase())) {
                            filteredList.add(item)
                        }
                    }
                    setupRecyclerView(filteredList)
                } else {
                    setupRecyclerView(list)
                }
            }

        })


    }

    private fun setupRecyclerView(list: ArrayList<Data>) {

        //initlizing adapter
        adapter = SimpleRecyclerViewAdapter(this, list)

        //setting up layout manager to recyclerView
        simpleList.layoutManager = LinearLayoutManager(this)
        simpleList.setHasFixedSize(true)

        //setting adapter to recyclerView
        simpleList.adapter = adapter

    }

    fun getData(context: Context): ArrayList<Data> {

        val people = ArrayList<Data>()
        //getting array from resource which I have implemented under values folder,you can have your dummy data
        val data = context.resources.getStringArray(R.array.people)

        //same as data I have put dummy images as well in drawable and put those images in an array.
        val images = context.resources.obtainTypedArray(R.array.images)

        //looping through all dummy data
        for (i in data.indices) {
            val d = Data(data[i], "", images.getResourceId(i, -1))
            people.add(d)
        }

        return people

    }


}
