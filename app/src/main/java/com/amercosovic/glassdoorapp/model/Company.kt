package com.amercosovic.glassdoorapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Company(
    @SerializedName("jessionid")
    val jessionid: String?,
    @SerializedName("response")
    val response: Response?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("success")
    val success: Boolean?
) : Parcelable