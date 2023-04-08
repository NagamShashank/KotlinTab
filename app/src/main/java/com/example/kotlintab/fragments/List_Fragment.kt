package com.example.kotlintab.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlintab.adapters.AdminAdapter
import com.example.kotlintab.data.ModelData
import com.example.kotlintab.R
import com.example.kotlintab.databinding.FragmentListBinding


class List_Fragment : Fragment() {


    private var Lbinding : FragmentListBinding? = null
    private val binding get() = Lbinding!!

    private lateinit var list : ArrayList<ModelData>
    private lateinit var adapter: AdminAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Lbinding = FragmentListBinding.inflate(inflater,container,false)

//        binding.recyclerviewAdmin.setHasFixedSize(true)

        list = ArrayList()

        list.add(ModelData(R.drawable.profile1,"Rohan Sathe","Branch Head"))
        list.add(ModelData(R.drawable.profile2,"Ashish Gupta","Senior Developer"))
        list.add(ModelData(R.drawable.profile3,"Pranali Kadam","Senior Developer"))
        list.add(ModelData(R.drawable.profile4,"Sonali Sundar","Project Manager"))
        list.add(ModelData(R.drawable.profile1,"Mohan Shirke","HR Head"))
        list.add(ModelData(R.drawable.profile4,"Urmila Gupta","Accountant"))

        adapter = AdminAdapter(list)
        binding.recyclerviewAdmin.adapter = adapter
        binding.recyclerviewAdmin.layoutManager = LinearLayoutManager(context)


        return binding.root
    }



}