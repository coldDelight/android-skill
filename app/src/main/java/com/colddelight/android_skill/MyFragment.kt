package com.colddelight.android_skill

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.colddelight.android_skill.base.BaseFragment
import com.colddelight.android_skill.databinding.FragmentMyBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MyFragment : BaseFragment<FragmentMyBinding, MyViewModel>(
    R.layout.fragment_my,MyViewModel::class.java
)  {
    private lateinit var adapter : CharacterAdapter
    override fun onInitDataBinding() {
        binding.rvMy.layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adapter =  CharacterAdapter().apply {
            setHasStableIds(true)
        }
        binding.rvMy.adapter = adapter

    }
    override fun setObserver() {
        lifecycleScope.launchWhenStarted {
            viewModel.characterState.collectLatest {
                if (it != null) {
                    adapter.setData(it)
                }
            }
        }
    }
    override fun setOnClick() {

    }

}