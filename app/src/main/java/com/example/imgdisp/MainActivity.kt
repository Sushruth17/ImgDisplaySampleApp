package com.example.imgdisp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imgdisp.adapters.MyAdapter


class MainActivity : AppCompatActivity() {
    private val imgUrl: ArrayList<String> = ArrayList()
    var manager: LinearLayoutManager? = null
    var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgUrl.add("https://gamedata.britishcouncil.org/sites/default/files/attachment/number-1_1.jpg")
        imgUrl.add("https://gamedata.britishcouncil.org/sites/default/files/attachment/number-2_1.jpg")
        imgUrl.add("https://gamedata.britishcouncil.org/sites/default/files/attachment/number-3_1.jpg")
        imgUrl.add("https://gamedata.britishcouncil.org/sites/default/files/attachment/number-4_1.jpg")
        imgUrl.add("https://gamedata.britishcouncil.org/sites/default/files/attachment/number-5_1.jpg")
        imgUrl.add("https://gamedata.britishcouncil.org/sites/default/files/attachment/number-6_1.jpg")
        imgUrl.add("https://gamedata.britishcouncil.org/sites/default/files/attachment/number-7_0.jpg")
        imgUrl.add("https://gamedata.britishcouncil.org/sites/default/files/attachment/number-8_1.jpg")
        imgUrl.add("https://gamedata.britishcouncil.org/sites/default/files/attachment/number-9_1.jpg")

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        manager = LinearLayoutManager(this)

        recyclerView?.layoutManager = manager
        recyclerView.setItemViewCacheSize(3)
        adapter = MyAdapter(imgUrl, this)
        recyclerView?.adapter = adapter
    }
}
