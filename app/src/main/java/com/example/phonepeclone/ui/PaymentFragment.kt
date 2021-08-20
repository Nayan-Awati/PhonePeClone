package com.example.phonepeclone.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.Toast
import com.example.phonepeclone.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_payment.*


class PaymentFragment : Fragment() {

    private var ctx: Context?=null
    private lateinit var tabLayout:TabLayout

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
        val view:View = inflater.inflate(R.layout.fragment_payment, container, false)
        initViews(view)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                if(position == 0){
                    Toast.makeText(requireContext(), "UPI ID feature", Toast.LENGTH_SHORT).show()
                }
                else{

                    Toast.makeText(requireContext(), "QR Scanner feature", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        return view
    }

    private fun initViews(view: View) {
        tabLayout = view.findViewById(R.id.pay_tab)
        tabLayout.addTab(tabLayout.newTab().setText("UPI ID"))
        tabLayout.addTab(tabLayout.newTab().setText("SCAN QR"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PaymentFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}