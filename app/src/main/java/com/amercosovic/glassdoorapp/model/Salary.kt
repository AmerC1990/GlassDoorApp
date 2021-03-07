package com.amercosovic.glassdoorapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Salary(
    @SerializedName("attributionURL")
    val attributionURL: String?,
    @SerializedName("basePay")
    val basePay: @RawValue BasePay?,
    @SerializedName("employerId")
    val employerId: Int?,
    @SerializedName("employerName")
    val employerName: String?,
    @SerializedName("employmentStatus")
    val employmentStatus: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("jobTitle")
    val jobTitle: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("meanBasePay")
    val meanBasePay: @RawValue MeanBasePay?,
    @SerializedName("payDeltaLocationType")
    val payDeltaLocationType: String?,
    @SerializedName("payDeltaPercent")
    val payDeltaPercent: Double?,
    @SerializedName("payPeriod")
    val payPeriod: String?,
    @SerializedName("reviewDateTime")
    val reviewDateTime: String?,
    @SerializedName("sqLogoUrl")
    val sqLogoUrl: String?
) : Parcelable