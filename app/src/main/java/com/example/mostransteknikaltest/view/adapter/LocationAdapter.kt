package com.example.mostransteknikaltest.view.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mostransteknikaltest.R
import com.example.mostransteknikaltest.model.Character
import com.example.mostransteknikaltest.model.CharacterWithAssignedLocation
import com.example.mostransteknikaltest.view.CharacterDetailActivity

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {
    private var locations = ArrayList<CharacterWithAssignedLocation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_location_list, parent, false)
        return LocationViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, CharacterDetailActivity::class.java).putExtra("character", Character(location.characterId, location.name, location.species, location.gender,location.imageResource, location.assignedLocation))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return locations.size
    }

    fun submitList(location: List<CharacterWithAssignedLocation>) {
        locations.clear()
        locations.addAll(location)
        notifyDataSetChanged()
    }

    // View holder for RecyclerView
    inner class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val locationNameTextView: TextView = itemView.findViewById(R.id.locationNameTextView)

        fun bind(location: CharacterWithAssignedLocation) {
            locationNameTextView.text = location.assignedLocation
        }
    }
}
