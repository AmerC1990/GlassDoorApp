package com.amercosovic.glassdoorapp

import com.amercosovic.glassdoorapp.model.Company

sealed class CompaniesState {
    data class Error(val errorMessage: String) : CompaniesState()
    data class Success(val companies: Company) : CompaniesState()
    object Loading : CompaniesState()
}