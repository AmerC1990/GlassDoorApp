package com.amercosovic.glassdoorapp.adapters


import android.graphics.Color
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.amercosovic.glassdoorapp.R
import com.amercosovic.glassdoorapp.fragments.CompanyDetailsFragment
import com.amercosovic.glassdoorapp.model.Interview
import com.amercosovic.glassdoorapp.model.Result
import com.amercosovic.glassdoorapp.model.ReviewX
import com.amercosovic.glassdoorapp.model.Salary
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.single_company_row.view.*

class CompanyListAdapter : RecyclerView.Adapter<CompanyListAdapter.ViewHolder>() {
    val companyDetailsFragment = CompanyDetailsFragment()
    var items: List<Result?> = ArrayList()

    fun setListData(data: List<Result?>) {
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_company_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    // bind data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val companyData = items[position]

        val nullableEmployerNames: Array<String?> = arrayOf(
            companyData?.review?.employerName,
            companyData?.interview?.employerName, companyData?.salary?.employerName
        )
//        for (employerName in nullableEmployerNames) {
        val nonNullName: List<String> =
            nullableEmployerNames.filterNotNull().filter { !it.contains("null") }
        holder.name.text = nonNullName.toString().replace("[", "").replace("]", "")
//        }

        val nullableJobTitles: Array<String?> = arrayOf(
            companyData?.review?.jobTitle,
            companyData?.interview?.jobTitle,
            companyData?.salary?.jobTitle
        )
        val nonNullJobTitle: List<String> =
            nullableJobTitles.filterNotNull().filter { !it.contains("null") }
        holder.jobTitle.text = nonNullJobTitle.toString().replace("[", "").replace("]", "")

        val salary = companyData?.salary?.basePay?.amount
//            ?: "Salary not available"
//            holder.salary.text = "$${salary}".substringBefore(".")

        if (salary != null || !salary.toString().contains("null")) {
            holder.salary.text = "$${salary}".substringBefore(".")
        } else {
            holder.salary.text = "Salary not available"
        }

        val overallNumericReview = companyData?.review?.overallNumeric
        val overallReview = companyData?.review?.overall

        if (!overallNumericReview.toString().contains("null")
            && !overallReview.toString().contains("null")
        ) {

            holder.review.text = overallNumericReview.toString() + " Overall: " +
                    overallReview.toString()
        } else {
            holder.review.visibility = View.GONE
        }


//        if (companyData?.review?.employerName != null) {
//            holder.name.text = companyData?.review?.employerName
//        }
//        else {
//            if (companyData?.interview?.employerName != null) {
//                holder.name.text = companyData?.interview?.employerName.toString()
//            }
//            else {
//                if (companyData?.salary?.employerName != null) {
//                    holder.name.text = companyData?.salary?.employerName
//                }
//            }
//        }

        val nullableImageUrls: Array<String?> = arrayOf(
            companyData?.salary?.sqLogoUrl,
            companyData?.review?.sqLogoUrl, companyData?.interview?.sqLogoUrl
        )

        val nonNullImageUrl: List<String> =
            nullableImageUrls.filterNotNull().filter { !it.contains("null") }


        Glide.with(holder.companyImage)
            .load(nonNullImageUrl.toString().replace("[", "").replace("]", ""))
            .centerCrop()
            .placeholder(R.drawable.defaultcompanyimage)
            .error(R.drawable.defaultcompanyimage)
            .into(holder.companyImage)

//        holder.review.text = companyData?.review?.overall
//        if (companyData?.salary?.basePay != null) {
//            holder.salary.text = companyData.salary.basePay.toString()
//        } else if (companyData?.salary?.basePay == null) {
//            holder.salary.text = "$$"
//        }
//        holder.salary.text = companyData?.review?.jobInformation?.toString()
//
//        holder.interview.text = companyData?.review?.featuredReview?.toString()

//        Log.d("data", companyData.toString())
//        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, RestaurantDetailsActivity::class.java)
//            intent.putExtra("restaurantDataFromList", restaurantData)
//            holder.itemView.context.startActivity(intent)
//        }
        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, RestaurantDetailsActivity::class.java)
//            intent.putExtra("restaurantDataFromList", restaurantData)
//            holder.itemView.context.startActivity(intent)

//            Log.d("clicked","name-  + ${holder?.name?.text}, salary - ${companyData?.salary?.basePay}, job title - ${companyData?.review?.jobTitle}, job review - ${holder?.review?.text}")
//            Log.d("comp", companyData?.review?.compensationAndBenefitsRating.toString())
//            Log.d("reviewInterviewSalary", "review- " + companyData?.review.toString()
//                    + " ///interview -"
//                    + companyData?.interview.toString() + " ///salary - "
//                    + companyData?.salary.toString() )
//            Log.d("interview object", companyData?.review.toString())
            if (overallNumericReview.toString().isNullOrEmpty()) {
                Log.d("null", "null")
            }
            if (overallNumericReview.toString().contains("null")) {
                Log.d("null", "nullString")
            }
//            holder.itemView.setBackgroundColor(CologetResources().getColor(R.color.black))
            holder.itemView.setBackgroundColor(Color.parseColor("#E6D3E6"))
            var reviewData: ReviewX? = companyData?.review
            var salaryData: Salary? = companyData?.salary
            var interviewData: Interview? = companyData?.interview
//            val data = reviewData ?: salaryData
//            Log.d("holderdata", companyData?.interview.toString())
//            passDataAndReplaceFragment(holder,companyData?.interview.toString())
            if (reviewData != null && !reviewData.toString().equals("null")) {
                Log.d("reviewwwfuckyou", reviewData.toString())
                passDataAndReplaceFragment(holder, reviewData)
            } else if (salaryData != null && !salaryData.toString().equals("null")) {
                Log.d("reviewwwfuckyou", salaryData.toString())
                passDataAndReplaceFragment(holder, salaryData)
            } else if (interviewData != null && !interviewData.toString().equals("null")) {
                Log.d("reviewwwfuckyou", interviewData.toString())
                passDataAndReplaceFragment(holder, interviewData)

            }
//            if (reviewData != null && !reviewData.toString().contains("null")) {
//                passDataAndReplaceFragment(holder,reviewData)
//            }
//            if (salaryData != null && !salary.toString().contains("null")) {
//                passDataAndReplaceFragment(holder,salaryData)
//            }

        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.employerName
        val review: TextView = itemView.jobReview
        val salary: TextView = itemView.companySalary
        val jobTitle: TextView = itemView.jobTitle
        val companyImage: ImageView = itemView.companyImage
    }

    private fun passDataAndReplaceFragment(holder: ViewHolder, data: Parcelable?) {
        val bundle = Bundle()
        if (data is ReviewX) {
            bundle.putParcelable("reviewData", data)
            Log.d("passed", data.toString())
        }
        if (data is Salary) {
            bundle.putParcelable("salaryData", data)
            Log.d("passed", data.toString())

        }
        if (data is Interview) {
            bundle.putParcelable("interviewData", data)
            Log.d("passed", data.toString())

        }

        val transaction =
            (holder.itemView.context as FragmentActivity).supportFragmentManager.beginTransaction()
        val fragment = CompanyDetailsFragment()
        fragment.arguments = bundle
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()

    }

}