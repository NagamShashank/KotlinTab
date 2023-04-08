package com.example.kotlintab.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.kotlintab.fragments.List_Fragment
import com.example.kotlintab.fragments.SignInFragment
import com.example.kotlintab.fragments.SignUpFragment


internal class MyPageAdapter(fm:FragmentManager):FragmentPagerAdapter(fm){


    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> SignInFragment()
            1 -> SignUpFragment()
            //2 -> List_Fragment()
            else -> SignInFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Sign In"
            1 -> "Sign Up"
            //2 -> "List"
            else -> "Sign In"
        }
    }

}
