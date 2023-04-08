package com.example.kotlintab.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintab.data.ModelData
import com.example.kotlintab.databinding.ItemLayoutHorizontalBinding

class AdminAdapter (val listAdmin : ArrayList<ModelData>):
  RecyclerView.Adapter<AdminAdapter.MyView>(){

      inner class MyView(val itemLayoutHorizontalBinding: ItemLayoutHorizontalBinding):
          RecyclerView.ViewHolder(itemLayoutHorizontalBinding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(ItemLayoutHorizontalBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return listAdmin.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemLayoutHorizontalBinding.HeadImage.setImageResource(listAdmin[position].Pic)
        holder.itemLayoutHorizontalBinding.Name.text = listAdmin[position].Name
        holder.itemLayoutHorizontalBinding.Description.text = listAdmin[position].Description
    }

}