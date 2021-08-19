package com.example.phonepeclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.phonepeclone.R

class HomeViewPagerAdapter : PagerAdapter() {
    private var ctx:Context? = null
    private var offerList = ArrayList<Int>()

    override fun getCount(): Int {
        return offerList.size
    }
    fun setData(arrData : List<Int>){
        offerList = arrData as ArrayList<Int>
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        ctx = container.context
        val view = LayoutInflater.from(ctx).inflate(R.layout.item_layout_offer,container,false)
        val txOffer :ImageView= view.findViewById(R.id.containZone)
        txOffer.setImageResource(offerList.get(position))
        container.addView(view)
        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        var view:View = `object` as View
        container.removeView(view)
    }

}