package com.idmission.sdk2.medium.sample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.idmission.sdk2.client.model.InitializeResponse
import com.idmission.sdk2.client.model.Response
import com.idmission.sdk2.client.model.SDKCustomizationOptions
import com.idmission.sdk2.identityproofing.IdentityProofingSDK
import com.idmission.sdk2.medium.sample.databinding.ActivityMainBinding
import com.idmission.sdk2.sample.tokenapi.LoginTokenApiHandler
import com.idmission.sdk2.utils.LANGUAGE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var apiBaseUrl = "https://apidemo.idmission.com/"
    //TODO update your loginID, password, MerchantID and productID
    var loginID = ""
    var password = ""
    var merchantID: Long = 19592
    var productID = ""
    var clientSecret = ""
    var clientID = ""
    var productName = "Identity_Validation_and_Face_Matching"
    var lang = "EN"
    var isSDKinit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editApiTextUrl.setText(apiBaseUrl)
        binding.editTextLoginId.setText(loginID)
        binding.editTextPassword.setText(password)
        binding.editTextMerchantId.setText(merchantID.toString(), TextView.BufferType.EDITABLE)
        binding.editTextClientSecret.setText(clientSecret)
        binding.editTextClientId.setText(""+clientID)

        binding.buttonContinue.setOnClickListener {
            var response: Response<InitializeResponse>
            showProgress();
            CoroutineScope(Dispatchers.Main).launch {
                withContext(Dispatchers.IO) {

                    var accessTokenInfo = LoginTokenApiHandler.getLoginAccessTokenRequest(
                        clientId = findViewById<EditText>(R.id.edit_text_client_id).text.toString(),
                        userId = findViewById<EditText>(R.id.edit_text_login_id).text.toString(),
                        password = findViewById<EditText>(R.id.edit_text_password).text.toString(),
                        clientSecret = findViewById<EditText>(R.id.edit_text_client_secret).text.toString(),
                        tokenCreateEnvironment = if (findViewById<EditText>(R.id.edit_api_text_url).text.toString()
                                .contains("demo")
                        ) "DEMO"
                        else if (findViewById<EditText>(R.id.edit_api_text_url).text.toString()
                                .contains("uat")
                        )
                            "UAT" else "KYC"
                    )

                    response = IdentityProofingSDK.initialize(
                        this@MainActivity,
                        binding.editApiTextUrl.text.toString(),
                        sdkCustomizationOptions = SDKCustomizationOptions(LANGUAGE.valueOf(lang)),
                        enableDebug = false,
                        isUpdateModelsData = true,
                        accessToken = accessTokenInfo?.access_token
                    )

                }
                isSDKinit = response.result?.status?.statusCode?.equals("000") == true
            }.invokeOnCompletion {
                if (isSDKinit) {
                    startActivity(
                        Intent(
                            this,
                            ServiceCallActivity::class.java
                        ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    )
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Error: SDK initialization credentials are not correct",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                hideProgress()
            }

        }
    }

    private fun showProgress() {
        findViewById<ProgressBar>(R.id.indeterminateBar).visibility=View.VISIBLE
    }

    private fun hideProgress() {
        findViewById<ProgressBar>(R.id.indeterminateBar).visibility = View.GONE
    }
}