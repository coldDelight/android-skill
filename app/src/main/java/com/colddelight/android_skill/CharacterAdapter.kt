package com.colddelight.android_skill

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.colddelight.android_skill.databinding.ItemCharacterBinding
import com.colddelight.domain.model.DomainCharacterInfo

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    private var items: List<DomainCharacterInfo> = ArrayList()
    lateinit var onSaveClick: (DomainCharacterInfo) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(items[position])
        holder.btnSave.setOnClickListener {
            onSaveClick(items[position])
        }
    }
    inner class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setItem(item: DomainCharacterInfo) {
            binding.tvName.text = item.name
            binding.tvSpecies.text = item.species
            if (item.image == null) {
                binding.btnSave.visibility = View.GONE
                Glide.with(itemView).asBitmap().load(item.imageLocal).into(binding.ivImg)
            } else {
                Glide.with(itemView).load(item.image).transform(CenterCrop(), RoundedCorners(16))
                    .into(binding.ivImg)
            }
        }

        val btnSave = binding.btnSave
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    @SuppressLint("NotifyDataSetChanged")
    internal fun setData(newItems: List<DomainCharacterInfo>) {
        this.items = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}