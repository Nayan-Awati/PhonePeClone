package com.example.phonepeclone.ui

import android.content.Context
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.phonepeclone.R
import com.example.phonepeclone.adapter.DealerAdapter
import com.example.phonepeclone.adapter.OfferAdapter
import com.example.phonepeclone.adapter.OfferViewPagerAdapter
import com.example.phonepeclone.model.DealerModel
import com.example.phonepeclone.model.OfferModel
import java.util.*
import kotlin.collections.ArrayList

class OfferFragment : Fragment() {
    private var ctx: Context?= null
    private lateinit var offerRecycler: RecyclerView
    private lateinit var dealersRecyclerOnline: RecyclerView
    private lateinit var dealersrRecycler: RecyclerView
    private lateinit var adapter: DealerAdapter
    private lateinit var viewPager: ViewPager
    private var offerArray = ArrayList<String>()
    private lateinit var lnrLyt :LinearLayout
    private lateinit var timer: Timer
    private var count:Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_offer, container, false)
        initViews(view)
        setUpViewPager()


        var offlineMerchantList = ArrayList<DealerModel>()
        offlineMerchantList.add(DealerModel("StarBucks", "Flat","Rs"+"39", "Cashback", "Valid Once Per User"))
        offlineMerchantList.add(DealerModel("McDonalds", "Get Burger worth","Upto"+"Rs"+"150", "Cashback", "Valid for New User"))
        offlineMerchantList.add(DealerModel("Metro", "Flat","Rs"+"20", "Free", "On Ticket Payment of 200 and above"))
        offlineMerchantList.add(DealerModel("Airtel Recharge", "CashBack","Rs"+"40", "Wallet", "Only for first transaction"))

        adapter = DealerAdapter()
        adapter.setData(requireContext(), offlineMerchantList)
        dealersrRecycler.adapter = adapter

        val onlineDealerList = ArrayList<DealerModel>()
        onlineDealerList.add(DealerModel("Zomato", "Get","20%","CashBack","Valid Twice Per User"))
        onlineDealerList.add(DealerModel("Swiggy", "Get","15%","CashBack","For New User Only"))
        onlineDealerList.add(DealerModel("PVR Cinemas", "Get","50%","CashBack","Book 4 tickets"))
        onlineDealerList.add(DealerModel("Amazon", "Get","25%","CashBack","On orders above Rs.500"))
        adapter = DealerAdapter()
        adapter.setData(requireContext(), onlineDealerList)
        dealersRecyclerOnline.adapter = adapter

        val offerList = ArrayList<OfferModel>()
        offerList.add(OfferModel("Bill Payment", "25% Cashback", R.drawable.ic_bill_green))
        offerList.add(OfferModel("Electricity", "15% Cashback", R.drawable.ic_lightbulb_green))
        offerList.add(OfferModel("Water Bill", "12% Cashback", R.drawable.ic_water_green))
        val adapter = OfferAdapter()
        adapter.setData(requireContext(),offerList)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                addBottomDots(position)
            }
        })
        timer= Timer()
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
        }, 500, 2000)
        return view
    }

    private fun setUpViewPager() {
        offerArray = ArrayList()
        offerArray.add("25% Cashback")
        offerArray.add("Free Recharge")
        offerArray.add("20% off on HDFC card")
        offerArray.add("10% discount on Flight Bookings")
        val viewPagerAdapter = OfferViewPagerAdapter()
        viewPagerAdapter.setData(requireContext(), offerArray)
        viewPager.adapter = viewPagerAdapter
        viewPager.clipToPadding = false
        viewPager.setPadding(40,0,40,20)
        viewPager.pageMargin = 20
        addBottomDots(0)
    }

    override fun onDetach() {
        super.onDetach()
        timer.cancel()
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

    private fun initViews(view: View) {
        viewPager = view.findViewById(R.id.offer_view_pager)
        lnrLyt = view.findViewById(R.id.ln_points)
        offerRecycler = view.findViewById(R.id.rv_bill_pay_offers)
        dealersrRecycler = view.findViewById(R.id.rv_offline_merchant)
        dealersRecyclerOnline = view.findViewById(R.id.rv_online_dealers)
        dealersRecyclerOnline.isNestedScrollingEnabled= false
        dealersrRecycler.isNestedScrollingEnabled = false
        val layoutManager = LinearLayoutManager(ctx)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        offerRecycler.layoutManager = layoutManager
        dealersrRecycler.layoutManager = GridLayoutManager(ctx, 3)
        dealersRecyclerOnline.layoutManager = GridLayoutManager(ctx, 3)


    }

    companion object {

        @JvmStatic
        fun newInstance() =
            OfferFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}