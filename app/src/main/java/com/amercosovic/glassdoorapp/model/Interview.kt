package com.amercosovic.glassdoorapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Interview(
    @SerializedName("approvalStatus")
    val approvalStatus: String?,
    @SerializedName("attributionURL")
    val attributionURL: String?,
    @SerializedName("employerId")
    val employerId: Int?,
    @SerializedName("employerName")
    val employerName: String?,
    @SerializedName("featuredReview")
    val featuredReview: Boolean?,
    @SerializedName("helpfulCount")
    val helpfulCount: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("interviewDate")
    val interviewDate: @RawValue Any?,
    @SerializedName("interviewSource")
    val interviewSource: String?,
    @SerializedName("interviewSteps")
    val interviewSteps: @RawValue Any?,
    @SerializedName("jobTitle")
    val jobTitle: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("negotiationDetails")
    val negotiationDetails: @RawValue Any?,
    @SerializedName("newReview")
    val newReview: Boolean?,
    @SerializedName("notHelpfulCount")
    val notHelpfulCount: Int?,
    @SerializedName("otherSteps")
    val otherSteps: @RawValue Any?,
    @SerializedName("outcome")
    val outcome: String?,
    @SerializedName("processAnswer")
    val processAnswer: String?,
    @SerializedName("processDifficulty")
    val processDifficulty: String?,
    @SerializedName("processInterviewExperience")
    val processInterviewExperience: @RawValue Any?,
    @SerializedName("processLength")
    val processLength: Int?,
    @SerializedName("processOverallExperience")
    val processOverallExperience: String?,
    @SerializedName("questions")
    val questions: List<Question?>?,
    @SerializedName("reasonForDeclining")
    val reasonForDeclining: @RawValue Any?,
    @SerializedName("reviewDateTime")
    val reviewDateTime: String?,
    @SerializedName("sqLogoUrl")
    val sqLogoUrl: String?,
    @SerializedName("testSteps")
    val testSteps: @RawValue Any?,
    @SerializedName("totalHelpfulCount")
    val totalHelpfulCount: Int?
) : Parcelable