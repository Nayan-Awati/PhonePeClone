package com.example.phonepeclone.ui

import android.content.Context
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.phonepeclone.R
import com.example.phonepeclone.adapter.HomeViewPagerAdapter
import org.w3c.dom.Text
import java.security.AccessController.getContext
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment() {


    private lateinit var viewPager: ViewPager
    private lateinit var lnrLyt: LinearLayout
    private lateinit var offerList: ArrayList<Int>
    private var count = 0
    private lateinit var timer: Timer





//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        arguments?.let {
//
//        }
//    }

    private fun initViews(view:View) {
        viewPager = view.findViewById(R.id.view_pager_home)
        lnrLyt = view.findViewById(R.id.ln_points_home)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home,container,false)
        initViews(view)
        setUpViewPager()
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                addBottomDots(position)

            }

        })
        timer = Timer()
        timer.schedule(object : TimerTask(){
            override fun run(){
                activity?.runOnUiThread{
                    if(count <=5){
                        viewPager.currentItem = count
                        count++
                    }else{
                        count =0
                        viewPager.currentItem = count
                    }
                }
            }
        }, 500,2000)
        // Inflate the layout for this fragment
        return view
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    private fun setUpViewPager() {
        offerList = ArrayList<Int>()
        offerList.add(R.drawable.jsi)
        offerList.add(R.drawable.jse1)
        offerList.add(R.drawable.jse2)

        val viewPagerAdapter= HomeViewPagerAdapter()
        viewPagerAdapter.setData(offerList)
        viewPager.adapter
        addBottomDots(0)





        
    }

    private fun addBottomDots(currentpage: Int) {
        var mTextDot=ArrayList<TextView>()
        lnrLyt.removeAllViews()

        for(i in 0 until mTextDot.size){
            mTextDot[i] = TextView(context)
            mTextDot[i].setText(Html.fromHtml("&#8226"))
            mTextDot[i].setTextSize(35F)
            mTextDot[i].setTextColor(resources.getColor(R.color.grey_300))
            lnrLyt.addView(mTextDot[i])
        }
        if(mTextDot.size > 0){
            mTextDot[currentpage].setTextColor(resources.getColor(R.color.grey_400))
        }



    }

    override fun onDetach() {

        super.onDetach()
        timer.cancel()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}