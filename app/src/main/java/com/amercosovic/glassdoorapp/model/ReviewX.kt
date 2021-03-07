package com.amercosovic.glassdoorapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class ReviewX(
    @SerializedName("advice")
    val advice: String?,
    @SerializedName("approvalStatus")
    val approvalStatus: String?,
    @SerializedName("attributionURL")
    val attributionURL: String?,
    @SerializedName("careerOpportunitiesRating")
    val careerOpportunitiesRating: Double?,
    @SerializedName("ceoApproval")
    val ceoApproval: String?,
    @SerializedName("ceoRating")
    val ceoRating: Double?,
    @SerializedName("compensationAndBenefitsRating")
    val compensationAndBenefitsRating: Double?,
    @SerializedName("cons")
    val cons: String?,
    @SerializedName("cultureAndValuesRating")
    val cultureAndValuesRating: Double?,
    @SerializedName("currentJob")
    val currentJob: Boolean?,
    @SerializedName("employerId")
    val employerId: Int?,
    @SerializedName("employerName")
    val employerName: String?,
    @SerializedName("employerResponse")
    val employerResponse: @RawValue Any?,
    @SerializedName("employmentStatus")
    val employmentStatus: String?,
    @SerializedName("featuredReview")
    val featuredReview: Boolean?,
    @SerializedName("headline")
    val headline: String?,
    @SerializedName("helpfulCount")
    val helpfulCount: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("jobInformation")
    val jobInformation: @RawValue Any?,
    @SerializedName("jobTitle")
    val jobTitle: String?,
    @SerializedName("jobTitleFromDb")
    val jobTitleFromDb: String?,
    @SerializedName("lengthOfEmployment")
    val lengthOfEmployment: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("newReview")
    val newReview: Boolean?,
    @SerializedName("notHelpfulCount")
    val notHelpfulCount: Int?,
    @SerializedName("overall")
    val overall: String?,
    @SerializedName("overallNumeric")
    val overallNumeric: Double?,
    @SerializedName("pros")
    val pros: String?,
    @SerializedName("recommendToFriend")
    val recommendToFriend: Boolean?,
    @SerializedName("reviewDateTime")
    val reviewDateTime: String?,
    @SerializedName("seniorLeadershipRating")
    val seniorLeadershipRating: Double?,
    @SerializedName("sqLogoUrl")
    val sqLogoUrl: String?,
    @SerializedName("totalHelpfulCount")
    val totalHelpfulCount: Int?,
    @SerializedName("workLifeBalanceRating")
    val workLifeBalanceRating: Double?
) : Parcelable