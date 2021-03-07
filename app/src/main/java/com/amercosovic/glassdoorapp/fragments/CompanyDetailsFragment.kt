package com.amercosovic.glassdoorapp.fragments

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.amercosovic.glassdoorapp.R
import com.amercosovic.glassdoorapp.model.Interview
import com.amercosovic.glassdoorapp.model.ReviewX
import com.amercosovic.glassdoorapp.model.Salary
import com.bumptech.glide.Glide


class CompanyDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        val inflater = inflater.inflate(R.layout.fragment_company_details, container, false)
        val companyDetailsTextview = inflater.findViewById<TextView>(R.id.companyDetailsTextview)
        val companyDetailsImageview = inflater.findViewById<ImageView>(R.id.companyDetailsImageview)
        companyDetailsTextview.setMovementMethod(ScrollingMovementMethod())
        val reviewData = arguments?.getParcelable<ReviewX>("reviewData")
        val salaryData = arguments?.getParcelable<Salary>("salaryData")
        val interviewData = arguments?.getParcelable<Interview>("interviewData")
        if (reviewData != null && reviewData.toString() != "null") {
            setCompanyImage(
                reviewData.sqLogoUrl.toString().replace("[", "").replace("]", ""),
                companyDetailsImageview
            )
            companyDetailsTextview.text = reviewData.employerName.toString() + "\n" +
                    "Overall Satisfaction: " + reviewData.overall + "\n" + "Pros: " + reviewData.pros + "\n" +
                    "Cons: " + reviewData.cons
        }
        if (salaryData != null && salaryData.toString() != "null") {
            setCompanyImage(
                salaryData.sqLogoUrl.toString().replace("[", "").replace("]", ""),
                companyDetailsImageview
            )
            companyDetailsTextview.text =
                salaryData.employerName.toString() + "\n" + "Job Title: " +
                        salaryData.jobTitle + "\n" + "Location: " + salaryData.location + "\n" +
                        "Base Pay: " + salaryData.basePay + "\n" +
                        "Mean Pay: " + salaryData.meanBasePay
        }
        if (interviewData != null && interviewData.toString() != "null") {
            setCompanyImage(
                interviewData.sqLogoUrl.toString().replace("[", "").replace("]", ""),
                companyDetailsImageview
            )
            companyDetailsTextview.text = "Interview Process: " + interviewData.processAnswer +
                    "\n" + "Interview Difficulty: " + interviewData.processDifficulty + "\n" +
                    "Overall Experience: " + interviewData.processOverallExperience
        }
        return inflater
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragmentContainer, CompaniesFragment())
            commit()
        }
        return true
    }

}

private fun setCompanyImage(imageUrl: String, imageView: ImageView) {
    Glide.with(imageView)
        .load(imageUrl.toString().replace("[", "").replace("]", ""))
        .centerCrop()
        .placeholder(R.drawable.defaultcompanyimage)
        .error(R.drawable.defaultcompanyimage)
        .into(imageView)
}
