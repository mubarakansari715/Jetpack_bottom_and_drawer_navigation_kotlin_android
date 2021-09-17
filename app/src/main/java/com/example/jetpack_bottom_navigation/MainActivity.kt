package com.example.jetpack_bottom_navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBar: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Button navigation connection
        navController = findNavController(my_nav_host_fragment)
        bottomNavigationView.setupWithNavController(navController)

        //appbarConfiguration
        appBar = AppBarConfiguration(navController.graph, main_drawerLayout)
        NavigationUI.setupActionBarWithNavController(
            this,
            navController,
            main_drawerLayout
        ) //create back button and menu button

        //drawer menu controller
        NavigationUI.setupWithNavController(design_navigation_view, navController)
    }

    //handling back button
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBar)
    }

}