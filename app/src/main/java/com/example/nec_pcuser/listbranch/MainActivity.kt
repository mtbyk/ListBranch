package com.example.nec_pcuser.listbranch

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

class MainActivity : AppCompatActivity(), BlankFragment.OnFragmentInteractionListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val container = findViewById<CustomViewPager>(R.id.container)
        container.setPagingEnabled(false)


        container.adapter = SectionsPagerAdapter(supportFragmentManager)

        val tabs = findViewById<TabLayout>(R.id.tabs)

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }
    override fun onFragmentInteraction(list: List<ListItemClass>) {
        val intent = Intent(this,TextList::class.java)

        intent.putExtra("list",list as ArrayList<ListItemClass>)
        startActivity(intent)
    }
    override fun onFragmentInteraction(textId: Int) {
        val intent = Intent(this,QuestionList::class.java)

        intent.putExtra("textId",textId)
        startActivity(intent)
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

class CustomViewPager(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {

    private var isEnable = true

    override fun onTouchEvent(ev: MotionEvent?): Boolean = when (isEnable) {
        true -> super.onTouchEvent(ev)
        else -> false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean = when (isEnable) {
        true -> super.onInterceptTouchEvent(ev)
        else -> false
    }

    fun setPagingEnabled(isEnable: Boolean) {
        this.isEnable = isEnable
    }
}

