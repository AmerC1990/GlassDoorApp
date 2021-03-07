package com.amercosovic.glassdoorapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Response(
    @SerializedName("results")
    val results: List<Result?>?
) : Parcelable