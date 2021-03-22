package com.amercosovic.glassdoorapp.adapters


import android.graphics.Color
import android.os.Bundle
import android.os.Parcelable
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
    var items: List<Result?> = ArrayList()

    // used to populate data to be binded
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

        val nonNullName: List<String> =
            nullableEmployerNames.filterNotNull().filter { !it.contains("null") }
        holder.name.text = nonNullName.toString().replace("[", "").replace("]", "")

        val nullableJobTitles: Array<String?> = arrayOf(
            companyData?.review?.jobTitle,
            companyData?.interview?.jobTitle,
            companyData?.salary?.jobTitle
        )
        val nonNullJobTitle: List<String> =
            nullableJobTitles.filterNotNull().filter { !it.contains("null") }
        holder.jobTitle.text = nonNullJobTitle.toString().replace("[", "").replace("]", "")

        val salary = companyData?.salary?.basePay?.amount

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

        holder.itemView.setOnClickListener {
            holder.itemView.setBackgroundColor(Color.parseColor("#E6D3E6"))
            val reviewData: ReviewX? = companyData?.review
            val salaryData: Salary? = companyData?.salary
            val interviewData: Interview? = companyData?.interview

            if (reviewData != null && !reviewData.toString().equals("null")) {
                passDataAndReplaceFragment(holder, reviewData)
            } else if (salaryData != null && !salaryData.toString().equals("null")) {
                passDataAndReplaceFragment(holder, salaryData)
            } else if (interviewData != null && !interviewData.toString().equals("null")) {
                passDataAndReplaceFragment(holder, interviewData)

            }
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
        }
        if (data is Salary) {
            bundle.putParcelable("salaryData", data)

        }
        if (data is Interview) {
            bundle.putParcelable("interviewData", data)

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