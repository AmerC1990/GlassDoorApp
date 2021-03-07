package com.amercosovic.glassdoorapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Question(
    @SerializedName("attributionURL")
    val attributionURL: @RawValue Any?,
    @SerializedName("date")
    val date: @RawValue Any?,
    @SerializedName("employer")
    val employer: String?,
    @SerializedName("helpfulCount")
    val helpfulCount: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("jobTitle")
    val jobTitle: String?,
    @SerializedName("locationCity")
    val locationCity: @RawValue Any?,
    @SerializedName("locationCountry")
    val locationCountry: @RawValue Any?,
    @SerializedName("locationState")
    val locationState: @RawValue Any?,
    @SerializedName("question")
    val question: String?,
    @SerializedName("responses")
    val responses: List<ResponseX?>?,
    @SerializedName("squareLogo")
    val squareLogo: String?,
    @SerializedName("totalHelpfulCount")
    val totalHelpfulCount: Int?
) : Parcelable