package com.idmission.sdk2.medium.sample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.idmission.sdk2.R
import kotlinx.android.synthetic.main.activity_final_submit.*
import kotlinx.android.synthetic.main.activity_final_submit.photoResultToolbar
import kotlinx.android.synthetic.main.activity_photo_results.*


class FinalSubmitActivity : Activity() {
    companion object {
        const val APP_CACHE = "app_cache"
        const val SUBMISSION_RESULT = "submission_result"

        fun launch(activity: Activity, response: String) {
            activity.getSharedPreferences(APP_CACHE, MODE_PRIVATE).edit()
                .putString(SUBMISSION_RESULT, response).apply()

            activity.startActivity(Intent(activity, FinalSubmitActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_submit)

        photoResultToolbar.apply {
            setTitleTextColor(ContextCompat.getColor(this@FinalSubmitActivity, R.color.white))
            setNavigationIcon(com.idmission.sdk2.capture.R.drawable.arrow_back)
            setNavigationOnClickListener { finish() }
        }

        val response =
            getSharedPreferences(APP_CACHE, MODE_PRIVATE).getString(SUBMISSION_RESULT, "")
        val responseLines = response!!.split("\n").map {
            if (it.length <= 255) it.subSequence(
                0,
                it.length
            ).toString() else it.subSequence(0, 255).toString() + "..."
        }
    }
}
