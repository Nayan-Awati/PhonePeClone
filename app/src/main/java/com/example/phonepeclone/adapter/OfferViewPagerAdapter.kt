package com.example.phonepeclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.phonepeclone.R

class OfferViewPagerAdapter: PagerAdapter (){
    private var ctx: Context?=null
    private var offerList = ArrayList<String>()

    fun setData(contxt:Context, arrData:ArrayList<String>){
        offerList = arrData
        ctx = contxt
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view:View = LayoutInflater.from(ctx).inflate(R.layout.offer_viewpager_item, container, false)
        val txtOffer:TextView = view.findViewById(R.id.offerGame)
        txtOffer.text = offerList[position]
        container.addView(view)
        return view
    }

    override fun getCount(): Int {
        return offerList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view : View = `object` as View
        container.removeView(view)
    }
}