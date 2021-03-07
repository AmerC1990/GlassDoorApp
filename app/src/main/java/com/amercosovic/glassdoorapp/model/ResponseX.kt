package com.amercosovic.glassdoorapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseX(
    @SerializedName("approvalStatus")
    val approvalStatus: String?,
    @SerializedName("createdDate")
    val createdDate: String?,
    @SerializedName("empRep")
    val empRep: Boolean?,
    @SerializedName("helpfulCount")
    val helpfulCount: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("notHelpfulCount")
    val notHelpfulCount: Int?,
    @SerializedName("responseText")
    val responseText: String?,
    @SerializedName("userHandle")
    val userHandle: String?
) : Parcelable