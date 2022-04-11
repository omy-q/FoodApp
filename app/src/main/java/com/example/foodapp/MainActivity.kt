package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.foodapp.databinding.ActivityMainBinding
import com.example.foodapp.view.FoodMenuFragment
import com.example.foodapp.view.base.BaseFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {
        binding.navigationBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_menu -> {
                    transferToFragment(FoodMenuFragment())
                    true
                }
                R.id.item_profile -> {
                    setToast("Profile Fragment")
                    true
                }
                R.id.item_basket -> {
                    setToast("Basket Fragment")
                    true
                }
                else -> false
            }
        }
    }

    private fun transferToFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun setToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}