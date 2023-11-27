package com.broncospace.android.starvis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.broncospace.android.starvis.api.PositionItem
import com.broncospace.android.starvis.databinding.ListItemGalleryBinding

class SatelliteViewHolder (
    private val binding: ListItemGalleryBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(positionItem: PositionItem) {
        //todo
    }
}

class SatelliteListAdapter (
    private val positionItems: List<PositionItem>
) : RecyclerView.Adapter<SatelliteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SatelliteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return SatelliteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SatelliteViewHolder, position: Int) {
        val item = positionItems[position]
        holder.bind(item)
    }

    override fun getItemCount() = positionItems.size
}