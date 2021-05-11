package com.example.demorecyclerview.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.*
import com.example.demorecyclerview.R
import com.example.demorecyclerview.adapter.AdapterExp1
import com.example.demorecyclerview.adapter.AdapterExp2
import com.example.demorecyclerview.model.Object2
import kotlinx.android.synthetic.main.recycler_1.*
import java.util.*

class Activity1 : AppCompatActivity() {
    private val listData1 = arrayOf(
        "String1", "String2", "String3", "String4", "String5", "String6",
        "String7", "String8", "String10"
    )
    private val adapterExp1: AdapterExp1 = AdapterExp1(listData1)
    private var listData2: MutableList<Object2> = mutableListOf()
    private var adapterExp2: AdapterExp2 = AdapterExp2(listData2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_1)
        dataAlready()

        var itemTouchHelper: ItemTouchHelper = ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.DOWN or ItemTouchHelper.UP,
                ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                adapterExp2.notifyItemMoved(viewHolder.layoutPosition, target.layoutPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                var positionOfData = viewHolder.layoutPosition
                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        listData2.removeAt(positionOfData)
                        adapterExp2.notifyItemRemoved(viewHolder.layoutPosition)
                        Toast.makeText(
                            this@Activity1,
                            listData2[positionOfData].string,
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                    ItemTouchHelper.RIGHT -> {
                        listData2.removeAt(positionOfData)
                        adapterExp2.notifyItemRemoved(viewHolder.layoutPosition)
                    }

                }
            }
        })
        itemTouchHelper.attachToRecyclerView(rv_vertical)

/*
        var connect: ConcatAdapter = ConcatAdapter(adapterExp1, adapterExp2)
        rv_vertical.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_vertical.adapter = connect
*/
        rv_horizontal.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_horizontal.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        )
        rv_horizontal.adapter = adapterExp1

        var snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_vertical)
        rv_vertical.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_vertical.scrollToPosition(3)
        rv_vertical.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rv_vertical.adapter = adapterExp2

        rv_grid.layoutManager = GridLayoutManager(
            this, 4,
            GridLayoutManager.HORIZONTAL, false
        )
        rv_grid.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        var line: DividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        ContextCompat.getDrawable(this, R.drawable.line)?.let { line.setDrawable(it) }
        rv_grid.addItemDecoration(line)
        rv_grid.adapter = adapterExp2

    }

    private fun dataAlready() {
        listData2.add(Object2(R.drawable.ic_black_panther, "Black Panther"))
        listData2.add(Object2(R.drawable.ic_black_widow, "Black Widow"))
        listData2.add(Object2(R.drawable.ic_captain_america, "Captain America"))
        listData2.add(Object2(R.drawable.ic_captain_marvel, "Captain Marvel"))
        listData2.add(Object2(R.drawable.ic_dr_strange, "Dr Strange"))
        listData2.add(Object2(R.drawable.ic_scarlet_witch, "Scarlet Witch"))
        listData2.add(Object2(R.drawable.ic_spider, "Spider Man"))
        listData2.add(Object2(R.drawable.ic_thor, "Thor"))
        listData2.add(Object2(R.drawable.ic_loki, "Loki"))
        listData2.add(Object2(R.drawable.ic_black_panther, "Black Panther"))
        listData2.add(Object2(R.drawable.ic_black_widow, "Black Widow"))
        listData2.add(Object2(R.drawable.ic_captain_america, "Captain America"))
        listData2.add(Object2(R.drawable.ic_captain_marvel, "Captain Marvel"))
        listData2.add(Object2(R.drawable.ic_dr_strange, "Dr Strange"))
        listData2.add(Object2(R.drawable.ic_scarlet_witch, "Scarlet Witch"))
        listData2.add(Object2(R.drawable.ic_spider, "Spider Man"))
        listData2.add(Object2(R.drawable.ic_thor, "Thor"))
        listData2.add(Object2(R.drawable.ic_loki, "Loki"))
    }
}