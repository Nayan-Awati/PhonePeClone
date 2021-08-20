package com.example.phonepeclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.phonepeclone.R
import com.example.phonepeclone.helper.BottomNavHelp
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mToolbar:Toolbar
    private lateinit var toolbarText:TextView
    private lateinit var bottomNavigationView: BottomNavigationView
    private  lateinit var homeFragment : HomeFragment
    private  lateinit var accountFragment: AccountFragment
    private  lateinit var offersFragment : OfferFragment
    private  lateinit var paymentFragment : PaymentFragment
    private  lateinit var transactionFragment :  TransactionFragment




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        //setSupportActionBar(mToolbar)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setTitle("")
        toolbarText.setText("PhonePe")



        bottomNavigationView.setOnNavigationItemSelectedListener { it ->
            when(it.itemId){
                R.id.navigation_home -> {
                    toolbarText.text= "PhonePe"
                    setUpFragment(homeFragment)
                }
                R.id.navigation_offer->{
                    toolbarText.text= "Offers"
                    setUpFragment(offersFragment)
                }
                R.id.navigation_account->{
                    toolbarText.text= "Accounts"
                    setUpFragment(accountFragment)
                }
                R.id.navigation_account->{
                    toolbarText.text= "Scan & Pay"
                    setUpFragment(paymentFragment)
                }
                R.id.navigation_transactions->{
                    toolbarText.text= "Transactions"
                    setUpFragment(transactionFragment)
                }

            }
            false
        }

        BottomNavHelp().removeShiftMode(bottomNavigationView)
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.home_view, homeFragment)
        beginTransaction.commit()

    }

    private fun initViews() {
        setContentView(R.layout.activity_main)
        mToolbar = findViewById(R.id.toolbar)
        toolbarText = findViewById(R.id.title_toolbar)
        bottomNavigationView = findViewById(R.id.navigation)
        homeFragment = HomeFragment()
        accountFragment = AccountFragment()
        offersFragment = OfferFragment()
        paymentFragment = PaymentFragment()
        transactionFragment = TransactionFragment()
    }

    private fun setUpFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
        fragmentTransaction.replace(R.id.home_view, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.notify-> {
                Toast.makeText(this,"Notification", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.scanNpay-> {
                Toast.makeText(this,"Scan any code", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}

