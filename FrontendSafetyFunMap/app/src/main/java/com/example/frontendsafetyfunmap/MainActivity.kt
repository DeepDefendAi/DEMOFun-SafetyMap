package com.example.frontendsafetyfunmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import com.example.frontendsafetyfunmap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return true
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setSelectedItemId(R.id.homeItem)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.mapItem -> replaceFragment(Map())
                R.id.homeItem -> replaceFragment(Home())
                R.id.menuItem -> replaceFragment(Menu())
                R.id.notificationsItem -> replaceFragment(Notifications())
                else ->{}
            }
            true
        }
    }
}
