package com.example.restapiretrofitokhttpgson.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.restapiretrofitokhttpgson.R
import com.example.restapiretrofitokhttpgson.data.model.Pokemon
import com.example.restapiretrofitokhttpgson.databinding.FragmentPokemonBinding
import com.example.restapiretrofitokhttpgson.ui.adapter.PokemonAdapter
import com.google.android.material.snackbar.Snackbar

class PokemonFragment : Fragment() {

    private lateinit var binding: FragmentPokemonBinding
    private val viewModel by viewModels<PokemonViewModel> ()
    private val pokemonAdapter = PokemonAdapter()

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
        setUpObserve()
    }

    private fun initialize() {
        binding.recyclerView.adapter = pokemonAdapter
    }

    private fun setUpObserve() {
        viewModel.pokemonLiveData.observe(viewLifecycleOwner) {
            pokemonAdapter.submitList(it)
        }
        viewModel.pokemonLiveData.observe(viewLifecycleOwner) {
        }
    }
}