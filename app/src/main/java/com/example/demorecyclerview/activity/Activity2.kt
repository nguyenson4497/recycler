package com.example.demorecyclerview.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.demorecyclerview.R
import com.example.demorecyclerview.adapter.AdapterExp3
import com.example.demorecyclerview.adapter.AdapterUseViewType
import com.example.demorecyclerview.model.Object2
import jp.wasabeef.recyclerview.animators.FadeInRightAnimator
import jp.wasabeef.recyclerview.animators.LandingAnimator
import kotlinx.android.synthetic.main.recycler_2.*

class Activity2 : AppCompatActivity(), AdapterExp3.OnItemClickListener {
    private var listData: MutableList<Object2> = mutableListOf()
    private var listData2: MutableList<Object2> = mutableListOf()
    private var adapterExp3: AdapterExp3 = AdapterExp3(listData, this)
    private var adapterUseViewType: AdapterUseViewType = AdapterUseViewType(listData, listData2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_2)
        data1Already()
        data2Already()

        var staggeredGridLayoutManager: StaggeredGridLayoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        rv_sGrid.layoutManager = staggeredGridLayoutManager
        rv_sGrid.itemAnimator = FadeInRightAnimator()
        rv_sGrid.adapter = adapterExp3
        btn_add_item.setOnClickListener(View.OnClickListener {
            var object2: Object2 = Object2(R.drawable.ic_thanos, "Thanos")
            listData.add(object2)
            //adapterExp3.notifyDataSetChanged()
            rv_sGrid.scrollToPosition(listData.indexOf(object2))
        })

        rv_viewType.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_viewType.adapter = adapterUseViewType
    }

    private fun data1Already() {
        listData.add(Object2(R.drawable.ic_black_panther, "Black Panther"))
        listData.add(Object2(R.drawable.ic_black_widow, "Black Widow"))
        listData.add(Object2(R.drawable.ic_captain_america, "Captain America"))
        listData.add(Object2(R.drawable.ic_captain_marvel, "Captain Marvel"))
        listData.add(Object2(R.drawable.ic_dr_strange, "Dr Strange"))
        listData.add(Object2(R.drawable.ic_scarlet_witch, "Scarlet Witch"))
        listData.add(Object2(R.drawable.ic_spider, "Spider Man"))
        listData.add(Object2(R.drawable.ic_thor, "Thor"))
        listData.add(Object2(R.drawable.ic_loki, "Loki"))
    }

    private fun data2Already() {
        listData2.add(Object2(R.drawable.ic_superman, "Superman"))
        listData2.add(Object2(R.drawable.ic_aquaman, "Aquaman"))
        listData2.add(Object2(R.drawable.ic_batman, "Batman"))
        listData2.add(Object2(R.drawable.ic_flash, "The Flash"))
        listData2.add(Object2(R.drawable.ic_wonder_woman, "Wonder Woman"))
        listData2.add(Object2(R.drawable.ic_cyborg, "Cyborg"))
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "You choose " + listData[position].string, Toast.LENGTH_SHORT).show()
    }
}