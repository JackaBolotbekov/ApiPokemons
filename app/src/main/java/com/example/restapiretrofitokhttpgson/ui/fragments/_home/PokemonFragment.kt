package com.example.restapiretrofitokhttpgson.ui.fragments._home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.restapiretrofitokhttpgson.R
import com.example.restapiretrofitokhttpgson.data.model.Pokemon
import com.example.restapiretrofitokhttpgson.databinding.FragmentPokemonBinding
import com.example.restapiretrofitokhttpgson.ui.adapter.PokemonAdapter
import com.example.restapiretrofitokhttpgson.ui.fragments.detail.DetailFragment

class PokemonFragment : Fragment() {

    private lateinit var binding: FragmentPokemonBinding
    private val viewModel by viewModels<PokemonViewModel> ()
    private val pokemonAdapter = PokemonAdapter()
    private val allPokemon = arrayListOf<Pokemon>()
    private var countOfPokemon = 20

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpListener()
        setUpRequest()
        setUpObserve()
    }

    private fun initialize() {
        binding.recyclerView.adapter = pokemonAdapter
    }

    private fun setUpListener() = with(binding) {
        root.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, DetailFragment::class.java, null)
                .commit()
        }
        fabGetMore.setOnClickListener{
            countOfPokemon += 20
            viewModel.getPokemon(offset = countOfPokemon, limit = 0)
        }
    }

    private fun setUpRequest() {
        viewModel.getPokemon(offset = 0, limit = 20)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpObserve() {
        viewModel.pokemonLiveData.observe(viewLifecycleOwner) {
            allPokemon.addAll(it)
            pokemonAdapter.submitList(allPokemon)
            pokemonAdapter.notifyDataSetChanged()
        }
        viewModel.pokemonLiveData.observe(viewLifecycleOwner) {
        }
    }
}