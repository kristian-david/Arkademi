package com.example.arkademi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.example.arkademi.R
import com.example.arkademi.fragments.BrowseFragment
import com.example.arkademi.fragments.DiscoverFragment
import com.example.arkademi.fragments.ProfileFragment
import com.example.arkademi.fragments.adapters.ViewPagerAdapter
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import java.util.*
import kotlin.concurrent.schedule

class HomeActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setUpTabs()

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.navView)

        toggle = ActionBarDrawerToggle(this,drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.miItem1 -> Toast.makeText(applicationContext, "Data Saver Button is Tapped", Toast.LENGTH_SHORT).show()
                R.id.miItem2 -> Toast.makeText(applicationContext, "Settings Button is Tapped", Toast.LENGTH_SHORT).show()
            }
            true
        }

        drawerLayout.visibility = View.GONE

        //val toolbarButton: ImageButton = findViewById(R.id.toolbar_button)
        //toolbarButton.setOnClickListener{ openSettings()}
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)

        if(toggle.onOptionsItemSelected(item)){
            drawerLayout.visibility = View.VISIBLE

            return true
        } else {
            // ayusin gone
            drawerLayout.visibility = View.GONE

        }

        return super.onOptionsItemSelected(item)
    }

    private fun openSettings(){

    }

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(DiscoverFragment(), "Discover")
        adapter.addFragment(BrowseFragment(), "Browse")
        adapter.addFragment(ProfileFragment(), "Profile")

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        viewPager.adapter = adapter

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }
}