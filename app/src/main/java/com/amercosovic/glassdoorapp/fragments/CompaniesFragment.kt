package com.amercosovic.glassdoorapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.amercosovic.glassdoorapp.CompaniesState
import com.amercosovic.glassdoorapp.R
import com.amercosovic.glassdoorapp.adapters.CompanyListAdapter
import com.amercosovic.glassdoorapp.viewmodels.CompaniesViewModel
import kotlinx.android.synthetic.main.fragment_companies.*

class CompaniesFragment : Fragment() {
    lateinit var recyclerViewAdapter: CompanyListAdapter
    private var viewModel = CompaniesViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_companies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        initRecyclerView()
        viewModel.fetchCompanies()
        attachObservers()
    }

    // initialize recyclerview
    private fun initRecyclerView() {
        companiesRecyclerView.apply {
            recyclerViewAdapter = CompanyListAdapter()
            adapter = recyclerViewAdapter
            val decoration =
                DividerItemDecoration(requireContext(), StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(decoration)
        }
    }

    // attach live data observers for restaurant data to populate recycler view
    private fun attachObservers() {
        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is CompaniesState.Loading -> {

                }
                is CompaniesState.Success -> {
                    state.companies.response?.results?.let { recyclerViewAdapter.setListData(it) }
                    recyclerViewAdapter.notifyDataSetChanged()
                }
                is Error -> {
                    Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

}