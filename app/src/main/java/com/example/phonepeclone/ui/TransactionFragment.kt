package com.example.phonepeclone.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phonepeclone.R
import com.example.phonepeclone.adapter.TransactionAdapter
import com.example.phonepeclone.model.TransactionModel


class TransactionFragment : Fragment() {

    private lateinit var ctx: Context
    private lateinit var recyclerView:RecyclerView



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
        val view:View = inflater.inflate(R.layout.fragment_transaction, container, false)
        initView(view)
        val transactionModelArrayList = ArrayList<TransactionModel>()
        transactionModelArrayList.add(
            TransactionModel( "1 day ago", "Paid to",
        "Zomato", "Rs."+"500", "Debited from", R.drawable.ic_to_contact))

        transactionModelArrayList.add(
            TransactionModel( "1 day ago", "Paid to",
                "Amazon", "Rs."+"999", "Debited from", R.drawable.ic_to_contact))

        transactionModelArrayList.add(
            TransactionModel( "2 day ago", "Cashback to",
                "Dominos", "Rs."+"120", "Credited to", R.drawable.ic_to_account))

        transactionModelArrayList.add(
            TransactionModel( "3 day ago", "Paid to",
                "Swiggy", "Rs."+"429", "Debited from", R.drawable.ic_to_contact))

        transactionModelArrayList.add(
            TransactionModel( "4 day ago", "Paid to",
                "BigBazaar", "Rs."+"1259", "Debited from", R.drawable.ic_to_contact))

        transactionModelArrayList.add(
            TransactionModel( "5 day ago", "Paid to",
                "Airtel", "Rs."+"698", "Debited from", R.drawable.ic_to_contact))

        transactionModelArrayList.add(
            TransactionModel( "7 day ago", "Cashback to",
                "Myntra", "Rs."+"100", "Credited to", R.drawable.ic_to_account))

        val adapter = TransactionAdapter()
        adapter.setData(transactionModelArrayList, ctx)
        recyclerView.adapter = adapter

        return view
    }

    private fun initView(view: View) {

        recyclerView = view.findViewById(R.id.transaction_recycler)
        recyclerView.layoutManager = LinearLayoutManager(ctx)
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            TransactionFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}