package com.amercosovic.glassdoorapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    @SerializedName("interview")
    val interview: Interview?,
    @SerializedName("relevancy")
    val relevancy: Relevancy?,
    @SerializedName("review")
    val review: ReviewX?,
    @SerializedName("salary")
    val salary: Salary?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("suggestedPost")
    val suggestedPost: Boolean?,
    @SerializedName("type")
    val type: String?
) : Parcelable