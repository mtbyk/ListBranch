package com.example.nec_pcuser.listbranch

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.design.widget.TabLayout.GRAVITY_FILL
import android.support.design.widget.TabLayout.MODE_FIXED
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager

class MainActivity : AppCompatActivity(), BlankFragment.OnFragmentInteractionListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val container = findViewById<ViewPager>(R.id.container)

        container.adapter = SectionsPagerAdapter(supportFragmentManager)

        val tabs = findViewById<TabLayout>(R.id.tabs)
        tabs.tabMode = MODE_FIXED
        tabs.tabMode = GRAVITY_FILL

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }
    override fun onFragmentInteraction(uri: Uri) {
        //val intent = Intent(this,Main2Activity::class.java)
        //startActivity(intent)
    }
    override fun onBackPressed() {
        // Do something
        finish()
    }




}

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return BlankFragment.newInstance((position+1).toString(),(position+1).toString())
    }

    override fun getCount(): Int {
        // Show 3 total pages.
        return 3
    }
}
