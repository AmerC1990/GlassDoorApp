package com.amercosovic.glassdoorapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amercosovic.glassdoorapp.CompaniesState
import com.amercosovic.glassdoorapp.retrofit.ApiClient
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class CompaniesViewModel : ViewModel() {
    // initialize mutable live data object
    val state: MutableLiveData<CompaniesState> = MutableLiveData()

    // get data for companies
    fun fetchCompanies() {
        state.value = CompaniesState.Loading
        viewModelScope.launch(IO) {
            val response = ApiClient.getClient.getCompanies()
            if (response.toString().isNotEmpty()) {
                state.postValue(CompaniesState.Success(response))
            } else {
                state.postValue(CompaniesState.Error("Error getting data"))
            }
        }
    }
}