package com.colddelight.android_skill

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.colddelight.android_skill.base.BaseFragment
import com.colddelight.android_skill.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home, HomeViewModel::class.java
) {
    private lateinit var adapter: CharacterAdapter

    override fun onInitDataBinding() {
        binding.rvCharacter.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = CharacterAdapter().apply {
            setHasStableIds(true)
        }
        binding.rvCharacter.adapter = adapter
    }

    override fun setObserver() {
        lifecycleScope.launch {
            viewModel.characterState.collectLatest {
                if (it != null) {
                    adapter.setData(it)
                }
            }
            viewModel.state.collectLatest {
                val msg = when (it?.second) {
                    FetchState.BAD_INTERNET -> "BAD_INTERNET 오류"
                    FetchState.PARSE_ERROR -> "PARSE_ERROR 오류"
                    FetchState.WRONG_CONNECTION -> "WRONG_CONNECTION 오류"
                    else -> "${it?.first?.message} 오류"
                }
                showSnackBar(msg)
            }
        }
    }

    override fun setOnClick() {
        binding.btnSaved.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_myFragment)
        }


        adapter.onSaveClick = {
            lifecycleScope.launch {
                viewModel.saveCharacter(it)
                showSnackBar("${it.name}을 저장했습니다.")
            }
        }
    }
}