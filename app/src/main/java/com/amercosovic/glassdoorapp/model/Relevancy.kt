package com.amercosovic.glassdoorapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Relevancy(
    @SerializedName("city")
    val city: @RawValue Any?,
    @SerializedName("employmentStatus")
    val employmentStatus: @RawValue Any?,
    @SerializedName("industry")
    val industry: @RawValue Any?,
    @SerializedName("jobTitle")
    val jobTitle: @RawValue Any?,
    @SerializedName("weight")
    val weight: Double?
) : Parcelable