# Module IDentity-SDK

## Introduction

This guide introduces the IDentity Android SDK within the IDmission product suite. Developers,
project managers and QA testers should reference this guide for information on configuration and
use of the IDentity SDK on the Android platform. We recommend reviewing the entire implementation
guide to fully understand the IDentity SDK functionality and its respective capabilities.

This guide details processes and procedures for embedding the IDentity SDK into your host
application and utilizing its current features. For additional IDentity SDK support, please contact
our Customer Support team at support@idmission.com.

## Overview and Key Features

The IDmission IDentity SDK is a comprehensive toolkit that enables the use of any combination of
factors of identity to complete digital transformation goals. The goal of the IDentity SDK is to
offer seamless integration into an existing digital paradigm where the end-to-end customer
experience is still owned and managed in-house.

## Quick Links to get started with IDentity SDK for Android

SDK Flavours Download Links - As per your requirement you can downloads the below
IDentityMediumSDK / IDentityMediumSDKWithoutModels.

[Download IDentityMediumSDK](https://github.com/Idmission-LLC/MediumSdk2SampleDemo) - Directly links
to the IDentityMediumSDK Sample app on IDmission GitHub Repository
<br/>[Download IDentityMediumSDKWithoutModels](https://github.com/Idmission-LLC/MediumSdk2WithoutModelsSampleDemo) - Directly links
to the IDentityMediumSDKWithoutModels Sample app on IDmission GitHub Repository
<br/>

<a href="https://documentation.idmission.com/identity/Android-SDK-2/index.html">
SDK Documentation</a> - Directly links to the Identity Proofing SDK

<br/>
<br/>

The main features supported in this SDK are:
<br/>

* <a href="https://documentation.idmission.com/identity/Android-SDK-2/-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/live-face-check.html">
  Live face Check</a><br/>
* <a href="https://documentation.idmission.com/identity/Android-SDK-2/-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/id-validation.html">
  ID Validation</a><br/>
* <a href="https://documentation.idmission.com/identity/Android-SDK-2/-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/id-validation-and-match-face.html">
  ID Validation and face match</a><br/>
* <a href="https://documentation.idmission.com/identity/Android-SDK-2/-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/id-validation-andcustomer-enroll.html">
  Enrollment</a><br/>
* <a href="https://documentation.idmission.com/identity/Android-SDK-2/-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/customer-enroll-biometrics.html">
  Enrollment with Biometrics</a><br/>
* <a href="https://documentation.idmission.com/identity/Android-SDK-2/-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/customer-verification.html">
  Customer Verification</a><br/>
* <a href="https://documentation.idmission.com/identity/Android-SDK-2/-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/auto-fill.html">
  Auto Fill</a><br/>
* <a href="https://documentation.idmission.com/identity/Android-SDK-2/-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/video-id.html">
  Video ID</a><br/><br/>

## SDK Server API call
* <a href="https://documentation.idmission.com/identity/Android-SDK-2/-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/initialize.html">
  Initialize SDK</a><br/>
* <a href="https://documentation.idmission.com/identity/Android-SDK-2/-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/final-submit.html">
  Final Submit</a><br/>
* <a href="https://documentation.idmission.com/identity/Android-SDK-2/-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/generic-final-submit.html">
  Generic Final Submit</a><br/><br/>

## Technical Prerequisites

Before integrating the SDK, ensure your environment meets the following requirements:

| Requirement | Value |
| :--- | :--- |
| **Minimum SDK Version** | API Level 26 (Android 8.0) |
| **Target/Compile SDK Version** | API Level 36 |
| **Java Version** | Java 17 |
| **Kotlin Version** | 2.2.0+ |
| **Build System** | Gradle (Groovy or Kotlin DSL) |


## Android Manifest Permissions

The SDK requires the following permissions and features to be declared in your `AndroidManifest.xml`:

```xml
<!-- Hardware Features -->
<uses-feature android:name="android.hardware.camera.any" />

<!-- Required Permissions -->
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.VIBRATE" />
<uses-permission android:name="android.permission.WAKE_LOCK" />

<!-- Optional/Feature Specific Permissions -->
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.RECORD_AUDIO" />
```

> **Note:** `android.permission.NFC` and the `android.hardware.nfc` feature are **not** part of
> this base manifest. They're declared inside the optional `idmission-nfc` module and merge into
> your app automatically only if you add that module as a dependency.

## Getting Started

### 1. Please contact to sales@idmission.com for Login Credentials, which you will later pass to the SDK.

### 2.1. (Groovy) Go to your **project-level** build.gradle file, and add the following in the `allprojects` block:

    ```
    allprojects {  
        repositories {  
            google()  
            mavenCentral()  
            // important stuff below  
            maven {
                url "https://gitlab.idmission.com/api/v4/projects/220/packages/maven"
                name "GitLab"
                credentials(HttpHeaderCredentials) {
                    name = "Private-Token"
                    value = "WESesyuSD9fQeqNEyig6"
                }
                authentication {
                    header(HttpHeaderAuthentication)
                }
            }
            //Required for fingerprint capture
            maven { url 'https://jitpack.io' }
        }  
    }
    ```
### 2.2. (Kotlin DSL) Go to your **project-level** settings.gradle.kts file, and add the following:

```
   pluginManagement {
        repositories {
            google()
            mavenCentral()
            gradlePluginPortal()
        }
    }
    dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
            google()
            mavenCentral()
            // important stuff below 
            maven {
                url = uri("https://gitlab.idmission.com/api/v4/projects/220/packages/maven")
                name = "GitLab"
                credentials(HttpHeaderCredentials::class) {
                    name = "Private-Token"
                    value = "WESesyuSD9fQeqNEyig6"
                }
                authentication {
                    create<HttpHeaderAuthentication>("header")
                }
            }
            //Required for fingerprint capture
            maven {
                 url = uri("https://jitpack.io")
            }
        }
    } 
    rootProject.name = "AndroidSDKWithKTS"
    include(":app")

```


### 3. In your **app-level** build.gradle (or build.gradle.kts) file, add the following:

    ```
    android {  
        // Java 17 is required for the latest CameraX and SDK features
        compileOptions {  
            sourceCompatibility JavaVersion.VERSION_17  
            targetCompatibility JavaVersion.VERSION_17  
        }  
        kotlinOptions {  
            jvmTarget = "17"  
        }  
    }
    
    //IdentityVideoID SDK
    dependencies {  
         implementation 'com.idmission.sdk2:idmission-videoidsdk:11.1.5.2.29'     
    }

    //IdentityVideoIDWithoutModels SDK
    dependencies {  
        implementation 'com.idmission.sdk2:idmission-videoidsdkwithoutmodels:11.1.5.2.29'     
    }

    //IdentityMedium SDK
    dependencies {  
         implementation 'com.idmission.sdk2:idmission-mediumsdk:11.1.19.2.10'     
    }

    //IdentityMediumWithoutModels SDK
    dependencies {  
         implementation 'com.idmission.sdk2:idmission-mediumsdkwithoutmodels:11.1.19.2.10'     
    }
    
    //IdentityLite SDK
    dependencies {  
         implementation 'com.idmission.sdk2:idmission-litesdk:11.1.19.2.10'     
    }

    //IdentityLiteWithoutModels SDK
    dependencies {  
         implementation 'com.idmission.sdk2:idmission-litesdkwithoutmodels:11.1.19.2.10'     
    }
    
    //IdentityLiveness SDK
    dependencies {  
    implementation 'com.idmission.sdk2:idmission-livenesssdk:11.1.19.2.10'     
    }

    //IdentityLivenessWithoutModels SDK
    dependencies {  
        implementation 'com.idmission.sdk2:idmission-livenesssdkwithoutmodels:11.1.19.2.10'     
    }
    ```

### 4. Sync your project with Gradle
### 5. Generate Access Token :
<b>Tokens are to be obtained on your server and sent to the client in the initialize call.</b>
   ### Login Credentials required for token generation.
   The following details are required to generate a token:

    * Auth_url : Authentication url for the given environment

    * client_id : Client ID generated for the specific company

    * client_secret : Client credentials/secret generated for the specific company

    * Username : Integ user name

    * Password: Password of the Integ user

   All company login details needed are provided upon sign up on the Identity Portal.

   ### Token Generation using RESTful API
   Token Generation Sample Request:
```
         curl --location --request POST 'https://auth.idmission.com/auth/realms/identity/protocol/openid-connect/token' \
         --header 'Content-Type: application/x-www-form-urlencoded' \
         --data-urlencode 'grant_type=password' \
         --data-urlencode 'client_id=XXXXXXX' \
         --data-urlencode 'client_secret=XXXXXXXX' \
         --data-urlencode 'username=XXXXXXXX' \
         --data-urlencode 'password=XXXXXXXXX' \
         --data-urlencode 'scope=api_access'
```
    
   Sample Response - Token Generation:
```
     {
        "access_token": "eyJhbGciO....5gNZx03Myb8ZuyY2gu3u-8KgGmULBs9mkPcg",
        "expires_in": 18000,
        "refresh_expires_in": 0,
        "token_type": "Bearer",
        "session_state": "e0b689e8-e7c6-47b7-bf9d-1349ea813c96",
        "scope": "email profile api_access"
     }
```
   The following details are the response parameters

    * access_token : Access Token value

    * expires_in : Access token expires time in seconds

    * refresh_expires_in : Refresh access token expires time in seconds

    * token_type : Token type

    * session_state : session state value

    * scope : Token scope

### 6.  SDK Initialization API.
* <a href="https://documentation.idmission.com/identity/Android-SDK-2/-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/initialize.html">
  Initialize SDK</a><br/>
<b>Token obtained from server needs to be passed in initialize call as below</b>
```
     IdentityProofingSDK.initialize(
     activity,
     apiBaseUrl = apiBaseUrl,
     sdkCustomizationOptions = SDKCustomizationOptions(language = "EN"),
     enableDebug = false,
     accessToken = accessTokenValue)
```

### 7. You may now use the library. Example usage below:
        ```kotlin
        class LaunchActivity : AppCompatActivity() {    
        
             private var apiBaseUrl = "https://api.idmission.com/"
             private val enableDebug = false
             private val enableGPS = true
             
             // 1. Initialize the launcher to receive results
             private val idMissionLauncher = registerForActivityResult(
                 IdMissionCaptureLauncher()
             ) { result ->
                 // Handle the capture result here
                 if (result != null) {
                    // do whatever you want with the data!
                 }
             }
            
            override fun onCreate(savedInstanceState: Bundle?) {  
                super.onCreate(savedInstanceState)  
                setContentView(R.layout.activity_launch)
                
                // 2. SDK initialize call (Recommended to do this early)
                init_button.setOnClickListener {
                    lifecycleScope.launch {
                        val response = withContext(Dispatchers.IO) {
                            // Generate a token as described in the 'Generate Access Token' section.
                            IdentityProofingSDK.initialize(
                                applicationContext, 
                                apiBaseUrl = apiBaseUrl, 
                                enableDebug = enableDebug,
                                enableGPS = enableGPS,
                                sdkCustomizationOptions = SDKCustomizationOptions(language = "EN"),
                                accessToken = "YOUR_ACCESS_TOKEN"
                            )
                        }
                        // Handle initialization response
                    }
                }
                
                // 3. Launch a service (e.g., ID Validation & Enrollment)
                someButton.setOnClickListener {
                    IdentityProofingSDK.idValidationAndcustomerEnroll(
                        this,
                        uniqueNumber = "UNIQUE_ID_123"
                    ) 
                }  
                
                // 4. Final submit call to send data to the server
                submitDataButton.setOnClickListener {
                    lifecycleScope.launch {
                        IdentityProofingSDK.finalSubmit(applicationContext)
                    }
                }  
            }
        }
        ```

Additional supported features

* <a href="./-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/document-capture.html">
  Document Capture</a><br/>
* <a href="./-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/voice-capture.html">
  Voice Capture</a><br/>
* Signature Capture<br/>
* Four Fingerprint Capture<br/><br/>



## Getting Started for Signature Capture

1. In your **app-level** build.gradle file, add the following:

    ```
    android {  
        // Java 17 is required for latest SDK features
        compileOptions {  
            sourceCompatibility JavaVersion.VERSION_17  
            targetCompatibility JavaVersion.VERSION_17  
        }  
        kotlinOptions {  
            jvmTarget = "17"  
        }  
    }
    
    dependencies {  
         implementation 'com.idmission.sdk2:signatureLib:11.01.07.05'    
    }
    
    ```
2. Sync your project with Gradle
3. To capture a signature, use the following code.
    ```
    SignatureSDK.captureSignature(Activity activityContext)
    
    SignatureSDK.captureSignature(
        Activity activityContext, 
        JSONObject captureSignatureConfig)
    ```

   Signature Capture Parameters

   |Parameter |      Type      |                                                                                                           Description                                                                                                            |
   | :---: |:--------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
   |<B>Parameter | <B>Type        |                                                                                                          <B>Description                                                                                                          |
   | activityContext|    Context     |                                                                                                    Instance of your Activity                                                                                                     |
   | captureSignatureConfig|   JSONObject   | {
          "signature_capture_screen_background_color": "#FFFFFF",
          "signature_capture_screen_box_border_color": "#000000",

          "signature_stroke_color": "#0000FF",
          "signature_stroke_size": "20",

          "signature_title_text": "Please Sign Below",
          "signature_title_text_color": "#0000FF",
          "signature_title_text_font": "font/custom_font.ttf",
          "signature_title_text_font_size": "20",
        
          "signature_done_btn_text": "Done 1",
          "signature_done_btn_text_color": "#FFFFFF",
          "signature_done_btn_text_font_size": "20",
          "signature_done_btn_text_font": "font/custom_font.ttf",
          "signature_done_btn_background": "done_button",
        
          "signature_clear_btn_text": "Clear 1",
          "signature_clear_btn_text_color": "#FF0000",
          "signature_clear_btn_text_font_size": "20",
          "signature_clear_btn_text_font": "font/custom_font.ttf",
          "signature_clear_btn_background": "cancel_button",
        
          "signature_back_btn_tint_color": "#FF0000",
          "signature_back_btn_image": "back_cancel_arrow",
          
        } 

   4. You may now use the library. Example usage below:
       ```
       class LaunchActivity : Activity() {    
    
           override fun onCreate(savedInstanceState: Bundle?) {  
               super.onCreate(savedInstanceState)  
               setContentView(R.layout.activity_launch)
            
               //SDK signature call
               signatureCapture.setOnClickListener{
               var doneBtnText = getString(R.string.done)
                   var cancelBtnText = getString(R.string.clear)
                   var signTitle = getString(R.string.sign_title)
    
                   SignatureSDK.captureSignature(this@LaunchActivity, JSONObject("{
                   "signature_capture_screen_background_color": "#FFFFFF",
                   "signature_capture_screen_box_border_color": "#000000",
      
                   "signature_stroke_color": "#0000FF",
                   "signature_stroke_size": "20",
    
                   "signature_title_text": "Please Sign Below",
                   "signature_title_text_color": "#0000FF",
                   "signature_title_text_font": "font/custom_font.ttf",
                   "signature_title_text_font_size": "20",
            
                   "signature_done_btn_text": "Done 1",
                   "signature_done_btn_text_color": "#FFFFFF",
                   "signature_done_btn_text_font_size": "20",
                   "signature_done_btn_text_font": "font/custom_font.ttf",
                   "signature_done_btn_background": "done_button",
            
                   "signature_clear_btn_text": "Clear 1",
                   "signature_clear_btn_text_color": "#FF0000",
                   "signature_clear_btn_text_font_size": "20",
                   "signature_clear_btn_text_font": "font/custom_font.ttf",
                   "signature_clear_btn_background": "cancel_button",
            
                   "signature_back_btn_tint_color": "#FF0000",
                   "signature_back_btn_image": "back_cancel_arrow"
              
               }"))
            }
            
    
           // Signature result is received in onActivityResult and set this result to SDK 2.0 Api setSignatureData  
           override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {  
               data ?: return  
               if (requestCode == SignatureConstants.SIGNATURE_CAPTURE_REQUEST_CODE) {
                   var signatureData = data?.getStringExtra("SignatureImage")
                   var signatureDataCoordinates = data?.getStringExtra("SignatureDataCoordinates")
                   IdentityProofingSDK.setSignatureData(signatureData,signatureDataCoordinates)
               } else if (requestCode == SignatureConstants.SIGNATURE_CANCEL_RESPONSE_CODE) {
                   // cancelled by user
                   IdentityProofingSDK.setSignatureData(null,null)
               }
           } 
       ```

## Getting Started for Four Fingerprint Capture

1. In your **app-level** build.gradle file, add the following:
    ```
    android {  
        // Java 17 is required for latest SDK features
        compileOptions {  
            sourceCompatibility JavaVersion.VERSION_17  
            targetCompatibility JavaVersion.VERSION_17  
        }  
        kotlinOptions {  
            jvmTarget = "17"  
        }  
    }
    
    dependencies {  
        implementation 'com.idmission.sdk2:4FingerprintCaptureLib:11.01.01.01' 
    }
    
    ```

2. Sync your project with Gradle
3. You may now use the library. Example usage below:
    ```
    class LaunchActivity : Activity() {    
    
        override fun onCreate(savedInstanceState: Bundle?) {  
            super.onCreate(savedInstanceState)  
            setContentView(R.layout.activity_launch)
            
            //capture fingerprint
            fingerPrintCapture.setOnClickListener{
                val indexCapture: Boolean = true
                val middleCapture: Boolean = true
                val ringCapture: Boolean = true
                val babyCapture: Boolean = true
    
                val dIndexKeep = true
                val dMiddleKeep = true
                val dRingKeep = true
                val dBabyKeep = true
    
                val captureLeftHand: Boolean = true
                val instructionScreen: Boolean = false
                val config = JSONObject()
                config.put(
                    UIConfigurationParameters.CFC_PROCESS_INDEX_FINGER,
                    if (indexCapture) "Y" else "N"
                )
                config.put(
                    UIConfigurationParameters.CFC_PROCESS_MIDDLE_FINGER,
                    if (middleCapture) "Y" else "N"
                )
                config.put(
                    UIConfigurationParameters.CFC_PROCESS_RING_FINGER,
                    if (ringCapture) "Y" else "N"
                )
                config.put(
                    UIConfigurationParameters.CFC_PROCESS_BABY_FINGER,
                    if (babyCapture) "Y" else "N"
                )
                config.put(
                    UIConfigurationParameters.CFC_CAPTURE_LEFT_HAND,
                    if (captureLeftHand) "Y" else "N"
                )
    
                config.put(
                    UIConfigurationParameters.CFC_KEEP_INDEX_FINGER,
                    if (dIndexKeep) "Y" else "N"
                )
                config.put(
                    UIConfigurationParameters.CFC_KEEP_MIDDLE_FINGER,
                    if (dMiddleKeep) "Y" else "N"
                )
                config.put(
                    UIConfigurationParameters.CFC_KEEP_RING_FINGER,
                    if (dRingKeep) "Y" else "N"
                )
                config.put(
                    UIConfigurationParameters.CFC_KEEP_BABY_FINGER,
                    if (dBabyKeep) "Y" else "N"
                )
    
                config.put(
                    UIConfigurationParameters.CFC_SHOW_INSTRUCTION_SCREEN,
                    if (instructionScreen == true) "Y" else "N"
                )
                //set language for sdk capture
                FingerPrintCaptureSDK.setLanguage(LanguageUtils.LANGUAGE.ES.toString())
                
                FingerPrintCaptureSDK.captureFourFingerprint(this@IDCaptureActivity,
                    config
                ) { resultMap, response -> //set 4fingerPrintData in to the sdk 2.0
                    IdentityProofingSDK.set4FingerPrintData(resultMap)
                }
            }
    
        
    ```

Custom Camera Fingerprint Capture Configurations
<table><thead>
<tr>
<th style="text-align: left"><strong>Camera fingerprint capture config</strong></th>
<th style="text-align: left"><strong>Description</strong></th>
</tr>
</thead><tbody>
<tr>
<td style="text-align: left"><code>cfc_label_text_typeface_type</code></td>
<td style="text-align: left"><p>Following values are supported for label typeface.</p><p></p><p>DEFAULT, DEFAULT_BOLD, SANS_SARIF, SERIF, MONOSPACE</p></td>
</tr>
<tr>
<td style="text-align: left"><code>cfc_label_text_typeface_style</code></td>
<td style="text-align: left"><p>Following values are supported for label typeface style.</p><p></p><p>NORMAL, BOLD, ITALIC, BOLD_ITALIC</p></td>
</tr>
<tr>
<td style="text-align: left"><p><code>cfc_label_text_color</code></p><p><code>cfc_label_text_color_alpha</code></p></td>
<td style="text-align: left">Color and Transparency of label text on instruction screen.</td>
</tr>
<tr>
<td style="text-align: left"><p><code>cfc_instruction_button_color</code></p><p><code>cfc_instruction_button_alpha</code></p></td>
<td style="text-align: left">Color and Transparency of instruction screen continue button.</td>
</tr>
<tr>
<td style="text-align: left"><p><code>cfc_instruction_button_txt_color</code></p><p><code>cfc_instruction_button_txt_alpha</code></p></td>
<td style="text-align: left">Color and Transparency of instruction screen continue button text.</td>
</tr>
<tr>
<td style="text-align: left"><code>id_enable_label_shadow</code></td>
<td style="text-align: left">Enable/Disable label shadow</td>
</tr>
<tr>
<td style="text-align: left"><p><code>id_capture_button_color</code></p><p><code>id_capture_button_alpha</code></p></td>
<td style="text-align: left">Color and Transparency of ID capture button.</td>
</tr>
<tr>
    <td style="text-align: left"><code>labels</code></td>
    <td style="text-align: left"><p>Currently following labels are shown on FingerPrint Capture screen, that can be customized with your own custom message.</p><p>camera_finger_capture_title<br/>move_closer<br/>move_away<br/>incorrect_hand<br/>hold_steady<br/>capturing_detail<br/>finger_too_close<br/>finger_too_far</td>
</tr>
</tbody></table>Additional functions are also detailed in
the <a href="./-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/index.html">
SDK Documentation</a>

## Getting Started for NFC / ePassport and Card Chip Reading

1. In your **app-level** build.gradle file, add the following:

    ```
    android {  
        // Java 17 is required for latest SDK features
        compileOptions {  
            sourceCompatibility JavaVersion.VERSION_17  
            targetCompatibility JavaVersion.VERSION_17  
        }  
        kotlinOptions {  
            jvmTarget = "17"  
        }  
    }
    
    dependencies {  
         implementation 'com.idmission.sdk2:idmission-nfc:11.1.19.2.10'    
    }
    
    ```
2. Sync your project with Gradle
3. To capture NFC data, use the following code.
    ```kotlin
    IdentityProofingSDK.idValidation(
        activity,
        idType = idMaster,
        idCountry = countryMaster,
        idState = stateMasterVO,
        additionalFlag,
        SDKCustomizationOptions(
            idCaptureCustomizationOptions = IDCaptureCustomizationOptions(
                enablePassportNfc = true
            )
        )
    )
    ```

   NFC Capture Parameters

   |Parameter |      Type      |                                                                                                           Description                                                                                                            |
   | :---: |:--------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
   | enablePassportNfc|    Boolean     |                                                                                                    Toggles NFC/ePassport chip scanning. Requires the optional `idmission-nfc` module to be added as a dependency.                                                                                                     |

4. You may now use the library. Example usage below:
    ```kotlin
    class LaunchActivity : Activity() {    
    
        override fun onCreate(savedInstanceState: Bundle?) {  
            super.onCreate(savedInstanceState)  
            setContentView(R.layout.activity_launch)
            
            //SDK nfc call
            nfcCapture.setOnClickListener{
                IdentityProofingSDK.idValidation(
                    this@LaunchActivity,
                    idType = idMaster,
                    idCountry = countryMaster,
                    idState = stateMasterVO,
                    additionalCustomerFlagData = additionalFlag,
                    sdkCustomizationOptions = SDKCustomizationOptions(
                        idCaptureCustomizationOptions = IDCaptureCustomizationOptions(
                            enablePassportNfc = true
                        )
                    )
                )
            }
        }
    }
    ```

NFC chip data comes back as `eDocument: EDocument?` on the same result object the MRZ side already carries.

<br/>
Note: When using the IDentity SDK, you do not need to create a request for XML; it is automatically generated by the SDK based on the function that you are calling

#### Parameters Used-

##### SDK initialization-
- [activityContext] - Activity  context.
- [apiBaseUrl] - Base url provided by IDmission for API calls.
- [enableDebug] - (Boolean) If you want to enable debug options or not.
- [enableGPS] - (Boolean) If you want to enable GPS options or not.
- [sdkCustomizationOptions] - SDKCustomizationOptions options if you want to add your customized
  UI details.
- [isUpdateModelsData] - (Boolean) If you want to update model from the server.
- [accessToken] - Access token value

##### Service Enroll Call

- [UniqueNumber] - Unique Number required.

##### SDK UI Customization Options-

You can customize almost every aspect of the ID and Selfie capture screens by passing `SDKCustomizationOptions` to the initialization or individual service calls. Below is the **complete technical reference** of every available field in the SDK.

---

### 1. The Main Customization Entry Point (`SDKCustomizationOptions`)

The `SDKCustomizationOptions` class acts as the master container for all UI and behavioral settings across the different capture modules (ID, Selfie, Document, etc.).

| Field | Type | Description                                                                          |
| :--- | :--- |:-------------------------------------------------------------------------------------|
| `language` | Enum | Application default language (EN, ES, etc.).                                         |
| `bothCameraToggle` | Boolean | Enable camera toggle for both selfie and document camera.                            |
| `documentCameraToggle` | Boolean| Enable camera toggle button specifically in document view.                           |
| `liveFaceCameraToggle` | Boolean | Enable camera toggle button specifically in Selfie view.                             |
| `defaultLiveFaceCamera`| Enum | Default camera facing for Selfie (`FRONT` or `BACK`).                                |
| `defaultDocumentCamera`| Enum | Default camera facing for Document (`FRONT` or `BACK`).                              |
| `documentCameraOrientation`| Enum | Capture orientation (`PORTRAIT` or `LANDSCAPE`).                                     |
| `isDebugMode` | Boolean | Toggles display of debug information overlay during capture.                         |
| `isScreenRecordingEnabled`| Boolean| Toggles permission for screen recording and screenshots.                             |
| `geolocationRequired` | Boolean | Blocks the user from proceeding if they deny/block location access. Default `false`. |

#### Sub-Option Modules
The main class also hosts specialized customization blocks for each workflow:
- `idCaptureCustomizationOptions`: Logic and UI for identity documents — see §2.
- `selfieCaptureCustomizationOptions`: Logic and UI for liveness and face capture — see §3.
- `documentCaptureCustomizationOptions`: Settings for generic document capture — see §5.
- `signatureCaptureCustomizationOptions`: Settings for signature pad screens — see §6.
- `voiceCaptureCustomizationOptions`: Settings for voice recording/biometrics — see §7.
- `autoFillCaptureCustomizationOptions`: Settings for automated data extraction flows — see §8.
- `nfcCaptureCustomizationOptions`: Settings for the NFC/ePassport chip reading screens (requires the optional `idmission-nfc` module) — see §4.

---

### 2. ID Capture Technical Reference (`IDCaptureCustomizationOptions`)

The `IDCaptureCustomizationOptions` class contains settings specific to the document scanning workflow, across four screens:
- **Capture Screen** — the live camera view: the per-side title label, a shared floating status/prompt text, the wrong-side mismatch override banner, the top bar, and the auto-capture progress ring.
- **Instruction Screen** — optional pre-capture instructions (`enableIdInstructionScreen` / `enableDocumentInstructionScreen`).
- **Retry Screen** — shown when a capture ultimately fails validation.
- **Preview Screen** — optional post-capture confirmation (`isIDCapturePreviewEnabled`).

#### 2.1 General ID Capture Settings

| Field | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `enableRealIDDetection` | Boolean | true | Toggles real ID detection logic. |
| `enableUploadIDData` | Boolean | true | Toggles uploading ID data to the GTE service. |
| `enableIDCapture4K` | Boolean | false | Toggles 4K resolution for ID capture. |
| `enableIdInstructionScreen` | Boolean | false | Toggles the instruction screen before ID capture. |
| `enableDocumentInstructionScreen` | Boolean | false | Toggles instruction screen for generic documents. |
| `enablePassportNfc` | Boolean | false | Toggles NFC/ePassport chip scanning. Requires the optional `idmission-nfc` module to be added as a dependency. Has no effect if the module isn't present. |
| `performIdCaptureBeforeSelfie` | Boolean | false | Forces ID capture before Selfie. |
| `isSecondaryID` | Boolean | false | Marks the capture as a secondary ID. |

#### 2.2 ID Capture Core Logic (`IDCaptureOptions`)

| Field                                   | Type    | Default | Description |
| :-------------------------------------- | :------ | :------ | :--- |
| `idCaptureOrientationMode`              | Enum    | HORIZONTAL | Expected physical orientation of the ID document during capture: `HORIZONTAL` (landscape), `VERTICAL` (portrait), or `DYNAMIC` (accepts either; resolved per-frame from the detected document's own width/height). |
| `documentFrameWidthRatio`               | Float   | 1.428   | Target aspect ratio for the document frame. |
| `frontRealnessThreshold`                | Float   | 0.5     | Threshold for front ID realness detection. |
| `backRealnessThreshold`                 | Float   | 0.3     | Threshold for back ID realness detection. |
| `frontDocumentConfidence`               | Float   | 0.7     | Classification confidence for front ID. |
| `backDocumentConfidence`                | Float   | 0.7     | Classification confidence for back ID. |
| `lowerWidthThresholdTolerance`          | Float   | 0.2     | Min width tolerance for auto-capture. |
| `upperWidthThresholdTolerance`          | Float   | 0.05    | Max width tolerance for auto-capture. |
| `focusThreshold`                        | Float   | 0.20    | Minimum focus probability required. |
| `fingerDetectionThreshold`              | Float   | 0.30    | Sensitivity for finger detection. |
| `glareDetectionThreshold`               | Float   | 0.50    | Sensitivity for glare detection. |
| `minMrzConfidence`                      | Float   | 0.25    | Minimum MRZ reading confidence. |
| `minBarcodeConfidence`                  | Float   | 0.50    | Minimum barcode reading confidence. |
| `documentBackComponentConfidence`       | Float   | 0.70    | Back component detection confidence. |
| `allowOverrideWrongDocumentTypeAfterMs` | Long    | 8000    | Timeout before allowing mismatch override. |
| `wrongDocumentTypeHandlingMode`         | Enum    | MANUAL  | `MANUAL_CAPTURE` or `AUTO_CAPTURE` or `EXIT` logic. |
| `wrongDocumentTypeWarningDelayInSec`    | Int     | 5       | Seconds before showing the warning label. |
| `consecutiveFakeIdCaptureLimit`         | Int     | 3       | Maximum ID capture retries allowed for repeated fake ID attempts. |
| `separateIdCardCaptureSequence`         | Boolean | false   | Toggles separate ID card preview flow. |
| `enableDynamicBothSideCapture`          | Boolean | false   | Accepts either the Front or Back side as the first capture and auto-detects which side is presented, instead of requiring Front first. |
| `isIDCapturePreviewEnabled`             | Boolean | false   | Toggles whether the ID preview/confirmation screen is displayed after successful capture. Also referenced as `enableIDPreviewScreen`. |
| `isIdInstructionAnimationEnabled`       | Boolean | true    | Toggles dynamic instruction slide animations on the pre-requisite screen. When no custom frames are supplied, the default frame set follows `idCaptureOrientationMode` (a vertical set is used for `VERTICAL`, the standard set otherwise). |
| `idInstructionAnimationDuration`        | Long    | 1L      | Total animation duration (in seconds) for all instruction frames. |
| `isBarcodeRecoveryEnabled`              | Boolean | true    | Enables the Barcode Recovery flow after accepted front/back ID captures when local barcode parsing fails. |
| `missingBarcodeTimeInterval`            | Int     | 5       | Seconds to try capturing the barcode during ID back capture before proceeding without a decoded barcode string (may trigger Barcode Recovery). |
| `barcodeRecoveryMoveCloserTimeInterval` | Int     | 10      | Barcode Recovery "move closer" window (seconds). Runs from the moment recovery starts; if the barcode bounding box does not grow enough before this elapses, recovery completes with the best image gathered so far. |
| `barcodeRecoveryCaptureTimeInterval`    | Int     | 5       | Barcode Recovery capture window (seconds), started once the move-closer (bbox-growth) requirement is met. The best readable crop within this window is captured. |

#### 2.3 ID Capture Screen Reference — Text, Font & Color (screen-wise)

Every text element on the ID Capture screens, grouped by screen and, on the Capture Screen, by the UI region it belongs to — same convention as §4.1. **Font Key** lists the size field and the custom-typeface field together (`fontOptions.*FontSize` / `fontOptions.*Font`); **Color Key** lists the text-color field and, where the row is a button, its background-color field together (`colorOptions.*`). **Default Text** is the literal fallback string shown when the field is left unset, verified against `values/strings.xml`/the call site — not a paraphrase.

**Capture Screen — Per-Side Title**

| Default Text | String Key | Font Key | Color Key |
| :--- | :--- | :--- | :--- |
| "Scan the front of ID" | `stringOptions.captureScreenFrontIDLabel` | `fontOptions.captureScreenFrontIDTextFontSize`<br>`fontOptions.captureScreenFrontIDTextFont` | `colorOptions.captureScreenFrontIDLabelColor` |
| "Scan the back of ID" | `stringOptions.captureScreenBackIDLabel` | `fontOptions.captureScreenBackIDTextFontSize`<br>`fontOptions.captureScreenBackIDTextFont` | `colorOptions.captureScreenBackIDLabelColor` |
| N/A | N/A | `fontOptions.labelFont` — fallback typeface for both labels above when no per-label font is set | `colorOptions.captureScreenBgColor` — overall screen background |

**Capture Screen — Floating Status/Prompt Text**

The messages below all render through a **single shared floating text view**, not independent labels — they cannot be individually colored or sized. Its typography is always `fontOptions.labelPromptFont` / `labelPromptFontSize`; its background/text color depends on the message's severity:

| Severity | Text Color | Background Color |
| :--- | :--- | :--- |
| Success | `colorOptions.captureScreenSuccessTextColor` | `colorOptions.captureScreenSuccessTextBgColor` (falls back to `colorOptions.progressBarColor`) |
| Informational | `colorOptions.captureScreenInfoTextColor` | `colorOptions.captureScreenInfoTextBgColor` |
| Warning/Error (default) | `colorOptions.captureScreenErrorTextColor` | `colorOptions.captureScreenErrorTextBgColor` |

Fields confirmed live-wired, with their real default text:

| Default Text | String Key |
| :--- | :--- |
| "Move closer" | `stringOptions.moveCloser` |
| "Fit document inside the rectangle" | `stringOptions.alignDocumentText` |
| "Please place the document inside the rectangle." | `stringOptions.autofillInstructionsText` |
| "Not in focus, Hold steady" | `stringOptions.tooBlurry` |
| "ID card front detected - please flip your ID card." | `stringOptions.incorrectDocumentSideFrontText` |
| "ID card back detected - please flip your ID card." | `stringOptions.incorrectDocumentSideBackText` |
| "Document detected, hold still..." | `stringOptions.documentDetectedIdHoldText` |
| "ID card back detected. Hold still..." | `stringOptions.documentDetectedIdBackHoldText` |
| "Remove finger from the ID" | `stringOptions.fingerDetectedOnIdText` |
| "Move away from direct light" | `stringOptions.glareDetectedOnIdText` |
| "Scan the back of ID" | `stringOptions.flipToBack` |
| "Scan the front of ID" | `stringOptions.flipToFront` |
| "Move Closer" | `stringOptions.moveCloserBarcode` (Barcode Recovery) |
| "Move Away" | `stringOptions.moveAwayBarcode` (Barcode Recovery) |
| "Fit document inside the overlay" | `stringOptions.alignBarcode` (Barcode Recovery) |
| "Scan the barcode" | `stringOptions.barcodeScanInstructions` (Barcode Recovery — `Operation.BARCODE_CAPTURE`, the ID-back barcode fallback flow described in §2.2, not the unrelated Document Capture operation below) |

**Capture Screen — Wrong-Side Mismatch Override**

Shown when the detected side doesn't match what's expected (e.g. Back shown when Front is required); pairs with the buttons in §2.6.

| Default Text | String Key | Font Key | Color Key |
| :--- | :--- | :--- | :--- |
| "We are having trouble identifying the correct side of your ID" | `stringOptions.idCaptureWarningMessage` | `fontOptions.warningLabelFontSize`<br>`fontOptions.warningLabelFont` | `colorOptions.warningLabelTextColor`<br>`colorOptions.warningLabelBackgroundColor` |
| "We are having trouble identifying the correct side of your ID" | `stringOptions.idCaptureFrontWarningMessage` | `fontOptions.warningLabelFontSize`<br>`fontOptions.warningLabelFont` | `colorOptions.warningLabelTextColor`<br>`colorOptions.warningLabelBackgroundColor` |

**Capture Screen — Top Bar**

| Default Text | String Key | Font Key | Color Key |
| :--- | :--- | :--- | :--- |
| N/A — unset means no text-mode Cancel control is shown at all (see `imageOptions.captureScreenCancelBtnImage`, §2.4); there is no built-in fallback string | `stringOptions.captureScreenCancelBtnText` | — (uses shared label typography) | `colorOptions.topBarCancelBtnTextColor` |
| N/A | N/A | N/A | `colorOptions.captureScreenTopBarBgColor` |
| N/A | N/A | N/A | `colorOptions.captureScreenCancelBtnTintColor` — tints `imageOptions.captureScreenCancelBtnImage` |

**Instruction Screen**

| Default Text | String Key | Font Key | Color Key |
| :--- | :--- | :--- | :--- |
| "Place your ID in the screen as shown. The image will be captured automatically." | `stringOptions.idInstructionText` | `fontOptions.instructionScreenLabelFontSize`<br>`fontOptions.instructionScreenLabelFont` | `colorOptions.instructionScreenLabelTextColor` |
| "Continue" | `stringOptions.idInstructionScreenButtonText` (Continue button) | `fontOptions.instructionScreenButtonFontSize`<br>`fontOptions.instructionScreenButtonFont` | `colorOptions.instructionScreenButtonTextColor`<br>`colorOptions.instructionScreenButtonBackgroundColor` |
| N/A | N/A | N/A | `colorOptions.instructionScreenBackgroundColor` |
| N/A | N/A | N/A | `colorOptions.instructionScreenLabelTextBgColor` |
| N/A | N/A | N/A | `colorOptions.instructionScreenBackButtonTintColor` |

**Retry Screen**

Two buttons — but note `stringOptions`' field naming doesn't match `colorOptions`/`fontOptions` here: the field literally named `retryScreenCancelButtonText` is the screen's **Done** button (its default falls back to `"Done"`, and it's styled by the `retryScreenDoneButton*` fields, not by any `retryScreenCancel*` field).

| Default Text | String Key | Font Key | Color Key |
| :--- | :--- | :--- | :--- |
| Context-dependent — see note below | `stringOptions.retryScreenLabelText` | `fontOptions.retryScreenLabelTextFontSize`<br>`fontOptions.retryScreenLabelTextFont` | `colorOptions.retryScreenLabelTextColor` |
| "Retry" | `stringOptions.retryButtonText` | `fontOptions.retryScreenRetryButtonFontSize`<br>`fontOptions.retryScreenRetryButtonFont` | `colorOptions.retryScreenRetryButtonTextColor`<br>`colorOptions.retryScreenRetryButtonBgColor` |
| "Done" | `stringOptions.retryScreenCancelButtonText` | `fontOptions.retryScreenDoneButtonFontSize`<br>`fontOptions.retryScreenDoneButtonFont` | `colorOptions.retryScreenDoneButtonTextColor`<br>`colorOptions.retryScreenDoneButtonBgColor` |
| N/A | N/A | N/A | `colorOptions.retryScreenBackgroundColor` |
| N/A | N/A | N/A | `colorOptions.retryScreenImageTintColor` — tints `imageOptions.retryScreenImage` |

**Preview Screen**

| Default Text | String Key | Font Key | Color Key |
| :--- | :--- | :--- | :--- |
| "ID Capture Successful" | `stringOptions.previewScreenTitleIdFront` | `fontOptions.previewScreenTitleFontSize`<br>`fontOptions.previewScreenTitleFont` | `colorOptions.previewScreenTitleLabelTextColor` |
| "ID Capture Successful" | `stringOptions.previewScreenTitleIdBack` | `fontOptions.previewScreenTitleFontSize`<br>`fontOptions.previewScreenTitleFont` | `colorOptions.previewScreenTitleLabelTextColor` |
| "Retry" | `stringOptions.previewScreenRetryBtnText` | `fontOptions.previewScreenRetryBtnFontSize`<br>`fontOptions.previewScreenRetryBtnFont` | `colorOptions.previewScreenRetryBtnTextColor`<br>`colorOptions.previewScreenRetryBtnBackgroundColor` |
| "Done" | `stringOptions.previewScreenDoneBtnText` | `fontOptions.previewScreenDoneBtnFontSize`<br>`fontOptions.previewScreenDoneBtnFont` | `colorOptions.previewScreenDoneBtnTextColor`<br>`colorOptions.previewScreenDoneBtnBackgroundColor` |
| N/A | N/A | N/A | `colorOptions.previewScreenBackgroundColor` |
| N/A | N/A | N/A | `colorOptions.previewScreenTopViewBgColor` |


**Declared here, but not ID front/back — the Additional Document Capture operation**

Two fields live in `IDCaptureCustomizationOptions` (not `DocumentCaptureCustomizationOptions`, §5 — a genuinely different class) but actually style the SDK's separate "additional document" capture operation (`Operation.DOCUMENT_CAPTURE`, a distinct request code from ID front/back), used for capturing supplementary documents beyond the primary ID. Do not treat these as ID labels:

| Default Text | String Key | Font Key | Color Key | Screen |
| :--- | :--- | :--- | :--- | :--- |
| "Scan the Document" | `stringOptions.captureScreenDocumentCaptureLabel` | `fontOptions.captureScreenDocumentCaptureTextFontSize`<br>`fontOptions.captureScreenDocumentCaptureTextFont` | `colorOptions.captureScreenDocumentCaptureLabelColor` | Capture Screen |
| "Place your ID in the screen as shown. The image will be captured automatically." | `stringOptions.documentInstructionText` | `fontOptions.instructionScreenLabelFontSize`<br>`fontOptions.instructionScreenLabelFont` (shared with `idInstructionText` above) | `colorOptions.instructionScreenLabelTextColor` (shared) | Instruction Screen |

The matching illustration is `imageOptions.documentInstructionImageResId` (§2.4) — a separate image from `idInstructionImageResId`.

#### 2.4 ID Capture Images (`IDImageOptions`)

| Field | Screen | Description |
| :--- | :--- | :--- |
| `captureScreenIdFrontOverlayImage` | Capture Screen | Front ID silhouette overlay. |
| `captureScreenIdBackOverlayImage` | Capture Screen | Back ID silhouette overlay. |
| `captureBottomBarImage` | Capture Screen | Bottom bar illustration. |
| `captureScreenCancelBtnImage` | Capture Screen | Top bar cancel icon (tinted by `colorOptions.captureScreenCancelBtnTintColor`). |
| `idInstructionImageResId` | Instruction Screen | Illustration for the ID instruction screen. |
| `idInstructionBackImageResId` | Instruction Screen | Back-button icon (paired with `layoutOptions.instructionBackBtnHide` and `colorOptions.instructionScreenBackButtonTintColor`). |
| `documentInstructionImageResId` | Instruction Screen | Illustration for the **Additional Document Capture** operation (see the note at the end of §2.3) — not the ID instruction screen. |
| `idCaptureInstructionAnimationImages` | Instruction Screen | List of custom drawable resource IDs for the frame-by-frame animation; when omitted, the SDK picks horizontal or vertical default frames based on `idCaptureOrientationMode`. |
| `retryScreenImage` | Retry Screen | Retry illustration (tinted by `colorOptions.retryScreenImageTintColor`). |
| `previewScreenToolbarBackIcon` | Preview Screen | Toolbar back icon. |
| `previewScreenToolbarBackIconTintColor` | Preview Screen | Tint color for the icon above (lives in `IDImageOptions` despite being a color field). |

#### 2.5 ID Capture Layout & Visibility (`IDLayoutOptions`)

| Field | Screen | Description |
| :--- | :--- | :--- |
| `captureLabelGravity` | Capture Screen | Alignment (`CENTER`/`TOP`/`BOTTOM`) for the per-side title label. |
| `topBarCancelButtonGravity` | Capture Screen | Alignment (`START`/`END`) for the top bar cancel control. |
| `isCaptureScreenToolbarTitleHide` | Capture Screen | Hides the toolbar title text. Default `true` (hidden). |
| `isIdCaptureProgressBarEnabled` | Capture Screen | Toggles the auto-capture progress ring (colored via `colorOptions.progressBarColor`). |
| `idCaptureProgressBarLineWidth` | Capture Screen | Stroke width for the progress ring. |
| `captureAnywayButton` | Capture Screen (Mismatch Override) | Background drawable for the Capture Anyway button. |
| `exitButton` | Capture Screen (Mismatch Override) | Background drawable for the Exit button. |
| `instructionContinueBtnBg` | Instruction Screen | Background drawable for the Continue button. |
| `instructionBackBtnHide` | Instruction Screen | Hides the back button. |
| `instructionLabelTextBgCardElevation` | Instruction Screen | Card elevation behind the instruction label. |
| `retryScreenRetryBtnBg` | Retry Screen | Background drawable for the Retry button. |
| `retryScreenDoneBtnBg` | Retry Screen | Background drawable for the Done button (`stringOptions.retryScreenCancelButtonText` — see the naming note in §2.3). |
| `previewScreenRetryBtnBg` | Preview Screen | Background drawable for the Retry button. |
| `previewScreenDoneBtnBg` | Preview Screen | Background drawable for the Done button. |
| `previewScreenToolbarBackIconHide` | Preview Screen | Hides the toolbar back icon. Default `true` (hidden). |

#### 2.6 ID Capture Buttons — Quick Reference

Every button across the ID Capture flow in one place. All fields below live inside `idCaptureCustomizationOptions`, and each button's fields only affect that one button:

| | Screen | Text | Text Color | Background Color | Font Size | Font | Background Drawable |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **Capture Anyway** | Capture Screen (mismatch) | `stringOptions.captureAnywayButtonText` | `colorOptions.captureAnywayButtonTextColor` | `colorOptions.captureAnywayButtonColor` | `fontOptions.captureAnywayButtonTextFontSize` | `fontOptions.captureAnywayButtonTextFont` | `layoutOptions.captureAnywayButton` |
| **Exit** | Capture Screen (mismatch) | `stringOptions.exitButtonText` | `colorOptions.exitButtonTextColor` | `colorOptions.exitButtonColor` | `fontOptions.exitButtonTextFontSize` | `fontOptions.exitButtonTextFont` | `layoutOptions.exitButton` |
| **Continue** | Instruction Screen | `stringOptions.idInstructionScreenButtonText` | `colorOptions.instructionScreenButtonTextColor` | `colorOptions.instructionScreenButtonBackgroundColor` | `fontOptions.instructionScreenButtonFontSize` | `fontOptions.instructionScreenButtonFont` | `layoutOptions.instructionContinueBtnBg` |
| **Retry** | Retry Screen | `stringOptions.retryButtonText` | `colorOptions.retryScreenRetryButtonTextColor` | `colorOptions.retryScreenRetryButtonBgColor` | `fontOptions.retryScreenRetryButtonFontSize` | `fontOptions.retryScreenRetryButtonFont` | `layoutOptions.retryScreenRetryBtnBg` |
| **Done** | Retry Screen | `stringOptions.retryScreenCancelButtonText` | `colorOptions.retryScreenDoneButtonTextColor` | `colorOptions.retryScreenDoneButtonBgColor` | `fontOptions.retryScreenDoneButtonFontSize` | `fontOptions.retryScreenDoneButtonFont` | `layoutOptions.retryScreenDoneBtnBg` |
| **Retry** | Preview Screen | `stringOptions.previewScreenRetryBtnText` | `colorOptions.previewScreenRetryBtnTextColor` | `colorOptions.previewScreenRetryBtnBackgroundColor` | `fontOptions.previewScreenRetryBtnFontSize` | `fontOptions.previewScreenRetryBtnFont` | `layoutOptions.previewScreenRetryBtnBg` |
| **Done** | Preview Screen | `stringOptions.previewScreenDoneBtnText` | `colorOptions.previewScreenDoneBtnTextColor` | `colorOptions.previewScreenDoneBtnBackgroundColor` | `fontOptions.previewScreenDoneBtnFontSize` | `fontOptions.previewScreenDoneBtnFont` | `layoutOptions.previewScreenDoneBtnBg` |

```kotlin
idCaptureCustomizationOptions = IDCaptureCustomizationOptions().apply {
    stringOptions.apply {
        captureScreenFrontIDLabel = "Front of your ID"
        idCaptureWarningMessage = "Please show the back of your ID"
        retryButtonText = "Try Again"
        retryScreenCancelButtonText = "Close" // this is the screen's Done button, not Cancel
    }
    colorOptions.apply {
        captureScreenFrontIDLabelColor = "#FFFFFF"
        warningLabelBackgroundColor = "#FFC107"
        retryScreenRetryButtonBgColor = "#2196F3"
        retryScreenDoneButtonBgColor = "#9E9E9E"
    }
    fontOptions.apply {
        captureScreenFrontIDTextFontSize = 18
        retryScreenRetryButtonFontSize = 16
    }
    layoutOptions.apply {
        captureAnywayButton = R.drawable.custom_capture_anyway_bg
        retryScreenRetryBtnBg = R.drawable.custom_retry_button_bg
    }
}
```

---

### 3. Selfie Capture Technical Reference (`SelfieCaptureCustomizationOptions`)

The `SelfieCaptureCustomizationOptions` class contains settings specific to the face capture workflow, across the same four kinds of screen as ID Capture (§2):
- **Capture Screen** — the live camera view: the toolbar title, a shared floating status/prompt text, and the top bar cancel control.
- **Instruction Screen** — optional pre-capture instructions (`enableSelfieInstructionScreen`).
- **Retry Screen** — shown when a capture ultimately fails validation.
- **Preview Screen** — optional post-capture confirmation (`isSelfieCapturePreviewEnabled`).

#### 3.1 Selfie Capture Logic (`SelfieCaptureOptions`)

| Field | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `minFaceWidth` | Float | 0.6 | Min face width relative to the frame for capture. |
| `eyeOpenProbability` | Float | 0.6 | Detection threshold for eyes open/closed prompts. |
| `minHeadEulerAngle` | Float | -10 | Min head tilt threshold for pose validation. |
| `maxHeadEulerAngle` | Float | 10 | Max head tilt threshold for pose validation. |
| `minRelativeNoseHeight` | Float | 0.48 | Min nose vertical limit to ensure face centering. |
| `maxRelativeNoseHeight` | Float | 0.67 | Max nose vertical limit to ensure face centering. |
| `labelsConfidenceThreshold` | Float | 0.8 | Detection confidence for a hand, scarf, hat or sunglasses covering the face. Sunglasses and goggles additionally need at least 0.90, so plain eyeglasses are not mistaken for them. |
| `faceMaskProbabilityThreshold` | Float | 0.90 | Detection confidence for face masks. |
| `liveFaceProbabilityThreshold` | Float | 0.9 | Critical threshold for liveness/realness grading. |
| `consecutiveFakeFaceLimit` | Int | 3 | Failed attempts allowed before showing retry. |
| `lightIntensityThreshold` | Float | 0.05 | Sensitivity for shadow and over-exposure detection. |
| `capture4K` | Boolean | false | Toggles 4K resolution capture for selfie. |
| `uploadFaceData` | Boolean | true | Toggles uploading captured face to GTE servers. |
| `focusFaceThreshold` | Float | 0.20 | Focus sensitivity for selfie capture verification. |
| `isSelfieCapturePreviewEnabled` | Boolean | false | Toggles whether the selfie preview/confirmation screen is displayed after successful capture. Also referenced as `enableSelfiePreviewScreen`. |

**Covered-face checks before capture (all SDK flavours).** In addition to liveness, focus and
face-mask detection, the selfie is captured only when:
- both eyes are open (`eyeOpenProbability`);
- no hand, scarf, sunglasses/goggles or hat is covering the face (`labelsConfidenceThreshold`) —
  the user is prompted to remove it, one item at a time in that order. Plain eyeglasses are
  allowed. This check runs before liveness, so a covered frame is never scored for liveness;
- the face-mask check passes on the current frame; it runs on every frame until capture;
- the checks above pass on 3 consecutive frames.

The saved selfie is the frame that passed these checks. The eyes-open and covered-face checks use
Google ML Kit models delivered by Google Play services; on a device where they are not available
these two checks are skipped.

#### 3.2 Selfie Capture Screen Reference — Text, Font & Color (screen-wise)

Every text element on the Selfie Capture screens, grouped by screen and, on the Capture Screen, by the UI region it belongs to — same convention as §2.3/§4.1.

**Capture Screen — Toolbar Title**

| Default Text | String Key | Font Key | Color Key |
| :--- | :--- | :--- | :--- |
| "Capture Selfie" | `stringOptions.captureScreenToolbarTitleText` | `fontOptions.captureScreenToolbarTitleTextFontSize`<br>`fontOptions.captureScreenToolbarTitleTextFont` | `colorOptions.captureScreenToolbarTitleTextColor` |
| N/A | N/A | N/A | `colorOptions.captureScreenBgColor` — overall screen background |


**Capture Screen — Floating Status/Prompt Text**

As with ID Capture (§2.3), every message below renders through a **single shared floating text view** — not independent labels. Its typography is always `fontOptions.labelPromptFont` / `labelPromptFontSize`; its background/text color depends on severity, using the same three-tier scheme as §2.3 (`captureScreenSuccessTextColor`/`BgColor`, `captureScreenInfoTextColor`/`BgColor`, `captureScreenErrorTextColor`/`BgColor`, all under `colorOptions`).

String keys sharing this text view: `captureScreenError`, `moveCloser`, `moveAway`, `alignInsideOval`, `capturingFace`, `realFace`, `fakeFace`, `leftEyeClosed`, `rightEyeClosed`, `faceMaskDetected`, `tooMuchLight`, `tooDark`, `straightenHead`, `eyesClosed`, `multipleFaces`, `moveFaceDown`, `moveFaceUp`, `glassesDetected`, `hatDetected`, `scarfDetected`, `handDetected`, `scarfHatDetected`, `glassesHatDetected`, `holdStill`, `scarfGlassesDetected`, `maskDetected`, `maskHatDetected`, `scarfMaskDetected`, `maskGlassesDetected`, `faceNotInFocus`, `liveFaceNotDetected` (all under `stringOptions`).

**Capture Screen — Top Bar / Cancel Control**

The Cancel control has two mutually exclusive modes: it renders as an icon when `imageOptions.captureScreenCancelBtnImage` is set, otherwise as text when `stringOptions.captureScreenCancelBtnText` is non-empty.

| Mode | Default Text | String Key | Font Key | Color Key |
| :--- | :--- | :--- | :--- | :--- |
| Icon (default) | N/A | N/A | N/A | `colorOptions.captureScreenCancelBtnTintColor` — tints `imageOptions.captureScreenCancelBtnImage` |
| Text | "Cancel" | `stringOptions.captureScreenCancelBtnText` | `fontOptions.captureScreenCancelBtnTextFontSize` (no matching `*Font` field) | `colorOptions.topBarTitleTextColor` — despite the name, this colors the Cancel button's text, not any toolbar title |
| Both modes | N/A | N/A | N/A | `colorOptions.captureScreenTopBarBgColor` |

**Instruction Screen**

| Default Text | String Key | Font Key | Color Key |
| :--- | :--- | :--- | :--- |
| "Remove sunglasses and hat. Avoid having bright lights behind you." | `stringOptions.selfieInstructionText` | `fontOptions.instructionScreenLabelFontSize`<br>`fontOptions.instructionScreenLabelFont` | `colorOptions.instructionScreenLabelTextColor` |
| "Continue" | `stringOptions.selfieInstructionScreenButtonText` | `fontOptions.instructionScreenButtonFontSize`<br>`fontOptions.instructionScreenButtonFont` | `colorOptions.instructionScreenButtonTextColor`<br>`colorOptions.instructionScreenButtonBackgroundColor` |
| N/A | N/A | N/A | `colorOptions.instructionScreenBackgroundColor` |
| N/A | N/A | N/A | `colorOptions.instructionScreenLabelTextBgColor` |
| N/A | N/A | N/A | `colorOptions.instructionScreenBackButtonTintColor` |

**Retry Screen**

Same naming quirk as ID Capture (§2.3): the field literally named `retryCancelButtonText` is the screen's **Done** button (defaults to `"Done"`, styled by the `retryScreenDoneButton*` fields, not by any `retryCancel*`/`retryScreenCancel*` field).

| Default Text | String Key | Font Key | Color Key |
| :--- | :--- | :--- | :--- |
| "Live face not detected, Please try again." | `stringOptions.retryScreenLabelText` | `fontOptions.retryScreenLabelTextFontSize`<br>`fontOptions.retryScreenLabelTextFont` | `colorOptions.retryScreenLabelTextColor` |
| "Retry" | `stringOptions.retryButtonText` | `fontOptions.retryScreenRetryButtonFontSize`<br>`fontOptions.retryScreenRetryButtonFont` | `colorOptions.retryScreenRetryButtonTextColor`<br>`colorOptions.retryScreenRetryButtonBgColor` |
| "Done" | `stringOptions.retryCancelButtonText` | `fontOptions.retryScreenDoneButtonFontSize`<br>`fontOptions.retryScreenDoneButtonFont` | `colorOptions.retryScreenDoneButtonTextColor`<br>`colorOptions.retryScreenDoneButtonBgColor` |
| N/A | N/A | N/A | `colorOptions.retryScreenBackgroundColor` |
| N/A | N/A | N/A | `colorOptions.retryScreenImageTintColor` — tints `imageOptions.retryScreenImage` |

**Preview Screen**

| Default Text | String Key | Font Key | Color Key |
| :--- | :--- | :--- | :--- |
| "Selfie Capture Successful" | `stringOptions.previewScreenTitle` | `fontOptions.previewScreenTitleFontSize`<br>`fontOptions.previewScreenTitleFont` | `colorOptions.previewScreenTitleLabelTextColor` |
| "Retry" | `stringOptions.previewScreenRetryBtnText` | `fontOptions.previewScreenRetryBtnFontSize`<br>`fontOptions.previewScreenRetryBtnFont` | `colorOptions.previewScreenRetryBtnTextColor`<br>`colorOptions.previewScreenRetryBtnBackgroundColor` |
| "Done" | `stringOptions.previewScreenDoneBtnText` | `fontOptions.previewScreenDoneBtnFontSize`<br>`fontOptions.previewScreenDoneBtnFont` | `colorOptions.previewScreenDoneBtnTextColor`<br>`colorOptions.previewScreenDoneBtnBackgroundColor` |
| N/A | N/A | N/A | `colorOptions.previewScreenBackgroundColor` |
| N/A | N/A | N/A | `colorOptions.previewScreenTopViewBgColor` |

#### 3.3 Selfie Capture Images (`SelfieImageOptions`)

| Field | Screen | Description |
| :--- | :--- | :--- |
| `captureSilhouetteImage` | Capture Screen | Face oval silhouette overlay. |
| `captureBottomBarImage` | Capture Screen | Bottom bar illustration. |
| `captureScreenCancelBtnImage` | Capture Screen | Top bar cancel icon — when set, the Cancel control renders as this icon instead of `stringOptions.captureScreenCancelBtnText` (see §3.2). |
| `selfieInstructionImageResId` | Instruction Screen | Illustration for the selfie instruction screen. |
| `selfieInstructionBackImageResId` | Instruction Screen | Back-button icon (paired with `layoutOptions.instructionBackBtnHide`). |
| `retryScreenImage` | Retry Screen | Retry illustration (tinted by `colorOptions.retryScreenImageTintColor`). |
| `previewScreenToolbarBackIcon` | Preview Screen | Toolbar back icon. |
| `previewScreenToolbarBackIconTintColor` | Preview Screen | Tint color for the icon above (lives in `SelfieImageOptions` despite being a color field). |

#### 3.4 Selfie Capture Layout & Visibility (`SelfieLayoutOptions`)

| Field | Screen | Description |
| :--- | :--- | :--- |
| `captureLabelGravity` | Capture Screen | Alignment (`CENTER`/`TOP`/`BOTTOM`); currently has no visible effect since the label it would position (`stringOptions.captureScreenLabel`) is unused (see §3.2). |
| `topBarCancelButtonGravity` | Capture Screen | Alignment (`START`/`END`) for the top bar cancel control. |
| `isCaptureScreenToolbarTitleHide` | Capture Screen | Hides the toolbar title text. Default `false` (shown) — unlike ID Capture, where the equivalent field defaults to hidden. |
| `instructionContinueBtnBg` | Instruction Screen | Background drawable for the Continue button. |
| `instructionBackBtnHide` | Instruction Screen | Hides the back button. |
| `instructionLabelTextBgCardElevation` | Instruction Screen | Card elevation behind the instruction label. |
| `retryScreenRetryBtnBg` | Retry Screen | Background drawable for the Retry button. |
| `retryScreenDoneBtnBg` | Retry Screen | Background drawable for the Done button (`stringOptions.retryCancelButtonText` — see the naming note in §3.2). |
| `previewScreenRetryBtnBg` | Preview Screen | Background drawable for the Retry button. |
| `previewScreenDoneBtnBg` | Preview Screen | Background drawable for the Done button. |
| `previewScreenToolbarBackIconHide` | Preview Screen | Hides the toolbar back icon. Default `true` (hidden). |

#### 3.5 Selfie Capture Buttons — Quick Reference

Every button across the Selfie Capture flow in one place. All fields below live inside `selfieCaptureCustomizationOptions`, and each button's fields only affect that one button:

| | Screen | Text | Text Color | Background Color | Font Size | Font | Background Drawable |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **Cancel** (text mode) | Capture Screen | `stringOptions.captureScreenCancelBtnText` | `colorOptions.topBarTitleTextColor` | `colorOptions.captureScreenTopBarBgColor` | `fontOptions.captureScreenCancelBtnTextFontSize` | — (no dedicated font field) | — |
| **Continue** | Instruction Screen | `stringOptions.selfieInstructionScreenButtonText` | `colorOptions.instructionScreenButtonTextColor` | `colorOptions.instructionScreenButtonBackgroundColor` | `fontOptions.instructionScreenButtonFontSize` | `fontOptions.instructionScreenButtonFont` | `layoutOptions.instructionContinueBtnBg` |
| **Retry** | Retry Screen | `stringOptions.retryButtonText` | `colorOptions.retryScreenRetryButtonTextColor` | `colorOptions.retryScreenRetryButtonBgColor` | `fontOptions.retryScreenRetryButtonFontSize` | `fontOptions.retryScreenRetryButtonFont` | `layoutOptions.retryScreenRetryBtnBg` |
| **Done** | Retry Screen | `stringOptions.retryCancelButtonText` | `colorOptions.retryScreenDoneButtonTextColor` | `colorOptions.retryScreenDoneButtonBgColor` | `fontOptions.retryScreenDoneButtonFontSize` | `fontOptions.retryScreenDoneButtonFont` | `layoutOptions.retryScreenDoneBtnBg` |
| **Retry** | Preview Screen | `stringOptions.previewScreenRetryBtnText` | `colorOptions.previewScreenRetryBtnTextColor` | `colorOptions.previewScreenRetryBtnBackgroundColor` | `fontOptions.previewScreenRetryBtnFontSize` | `fontOptions.previewScreenRetryBtnFont` | `layoutOptions.previewScreenRetryBtnBg` |
| **Done** | Preview Screen | `stringOptions.previewScreenDoneBtnText` | `colorOptions.previewScreenDoneBtnTextColor` | `colorOptions.previewScreenDoneBtnBackgroundColor` | `fontOptions.previewScreenDoneBtnFontSize` | `fontOptions.previewScreenDoneBtnFont` | `layoutOptions.previewScreenDoneBtnBg` |

```kotlin
selfieCaptureCustomizationOptions = SelfieCaptureCustomizationOptions().apply {
    stringOptions.apply {
        captureScreenToolbarTitleText = "Take a Selfie"
        moveCloser = "Move closer to the camera"
        retryButtonText = "Try Again"
        retryCancelButtonText = "Close" // this is the screen's Done button, not Cancel
    }
    colorOptions.apply {
        captureScreenToolbarTitleTextColor = "#FFFFFF"
        retryScreenRetryButtonBgColor = "#2196F3"
        retryScreenDoneButtonBgColor = "#9E9E9E"
    }
    fontOptions.apply {
        captureScreenToolbarTitleTextFontSize = 18
        retryScreenRetryButtonFontSize = 16
    }
    layoutOptions.apply {
        retryScreenRetryBtnBg = R.drawable.custom_retry_button_bg
    }
}
```

---

### 4. NFC Capture Technical Reference (`NfcCaptureCustomizationOptions`)

The `NfcCaptureCustomizationOptions` class customizes the two screens shown during passport/ID NFC chip reading (added via the optional `idmission-nfc` module — see [Getting Started for NFC / ePassport and Card Chip Reading](#getting-started-for-nfc--epassport-and-card-chip-reading)):
- The **scanning bottom sheet** — shown while the chip is being read, with a `Skip` action.
- The **error screen** — shown when the scan fails, with `Retry` and `Skip` actions.

Both screens have their own `Skip` button, so `Skip`-related fields are duplicated: the `nfcScreenSkipButton*` fields style the scanning bottom sheet's Skip button, while the `nfcErrorScreenSkipButton*` fields style the error screen's Skip button. `Retry`-related fields (`nfcErrorScreenRetryButton*`) only apply to the error screen, since only that screen has a Retry button.

#### 4.1 NFC Screen Reference — Text, Font & Color (screen- and type-wise)

Every text element on both NFC screens, grouped by screen. **Font Key** lists the size field and the custom-typeface field together (`fontOptions.*FontSize` / `fontOptions.*Font`); **Color Key** lists the text-color field and, where the row is a button, its background-color field together (`colorOptions.*`).

**Instructions Screen** (the scanning bottom sheet)

| Default Text | String Key | Font Key | Color Key |
| :--- | :--- | :--- | :--- |
| "Ready to Scan" | `stringOptions.nfcScreenReadyToScanTitle` | `fontOptions.nfcScreenReadyToScanTitleFontSize`<br>`fontOptions.nfcScreenReadyToScanTitleFont` | `colorOptions.nfcScreenReadyToScanTitleColor` |
| "Place the back of your phone over the ID or passport. Slowly move your phone up and down along the page. Once the reading begins, do not move your phone until the process completes." | `stringOptions.nfcScreenScanInstructions` | `fontOptions.nfcScreenScanInstructionsFontSize`<br>`fontOptions.nfcScreenScanInstructionsFont` | `colorOptions.nfcScreenScanInstructionsColor` |
| "SKIP" | `stringOptions.nfcScreenSkipButtonText` | `fontOptions.nfcScreenSkipButtonTextFontSize`<br>`fontOptions.nfcScreenSkipButtonTextFont` | `colorOptions.nfcScreenSkipButtonTextColor`<br>`colorOptions.nfcScreenSkipButtonBackgroundColor` |
| "Reading Data" | `stringOptions.nfcScreenLoadingText` | `fontOptions.nfcScreenLoadingTextFontSize`<br>`fontOptions.nfcScreenLoadingTextFont` | `colorOptions.nfcScreenLoadingTextColor` |
| "ID Read Successfully" | `stringOptions.nfcScreenSuccessTitle` | `fontOptions.nfcScreenSuccessTitleFontSize`<br>`fontOptions.nfcScreenSuccessTitleFont` | `colorOptions.nfcScreenSuccessTitleColor` |
| N/A | N/A | N/A | `colorOptions.nfcScreenBackgroundColor` |

**Error Screen**

| Default Text | String Key | Font Key | Color Key |
| :--- | :--- | :--- | :--- |
| "Unable to read the NFC chip. Please try again." | `stringOptions.nfcErrorScreenErrorText` | `fontOptions.nfcErrorScreenErrorTextFontSize`<br>`fontOptions.nfcErrorScreenErrorTextFont` | `colorOptions.nfcErrorScreenErrorTextColor` |
| "RETRY" | `stringOptions.nfcErrorScreenRetryButtonText` | `fontOptions.nfcErrorScreenRetryButtonTextFontSize`<br>`fontOptions.nfcErrorScreenRetryButtonTextFont` | `colorOptions.nfcErrorScreenRetryButtonTextColor`<br>`colorOptions.nfcErrorScreenRetryButtonBackgroundColor` |
| "SKIP" | `stringOptions.nfcErrorScreenSkipButtonText` | `fontOptions.nfcErrorScreenSkipButtonTextFontSize`<br>`fontOptions.nfcErrorScreenSkipButtonTextFont` | `colorOptions.nfcErrorScreenSkipButtonTextColor`<br>`colorOptions.nfcErrorScreenSkipButtonBackgroundColor` |
| N/A | N/A | N/A | `colorOptions.nfcErrorScreenImageTintColor` |
| N/A | N/A | N/A | `colorOptions.nfcErrorScreenBackgroundColor` |

#### 4.2 NFC Layout & Backgrounds (`NfcLayoutOptions`)

| Field | Screen | Description |
| :--- | :--- | :--- |
| `nfcScreenSkipButtonBackground` | Scanning bottom sheet | Custom background drawable resource (`R.drawable.*`) for the Skip button. Fully replaces the button's Material outline/ripple styling. |
| `nfcErrorScreenRetryButtonBackground` | Error screen | Custom background drawable resource for the Retry button. |
| `nfcErrorScreenSkipButtonBackground` | Error screen | Custom background drawable resource for the Skip button. |

#### 4.3 NFC Images (`NfcImageOptions`)

| Field | Screen | Description |
| :--- | :--- | :--- |
| `nfcErrorScreenImage` | Error screen | Custom drawable resource (`R.drawable.*`) shown in place of the default error icon. |

#### 4.4 NFC Buttons — Quick Reference

Across both NFC screens there are three buttons total: the scanning bottom sheet's **Skip**, and the error screen's (`PassportNfcReaderErrorActivity`) **Retry** and **Skip**. All fields below live inside `nfcCaptureCustomizationOptions`, and each button's fields only affect that one button:

| | Screen | Text | Text Color | Background Color | Font Size | Font | Background Drawable |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **Skip button** | Scanning bottom sheet | `stringOptions.nfcScreenSkipButtonText` | `colorOptions.nfcScreenSkipButtonTextColor` | `colorOptions.nfcScreenSkipButtonBackgroundColor` | `fontOptions.nfcScreenSkipButtonTextFontSize` | `fontOptions.nfcScreenSkipButtonTextFont` | `layoutOptions.nfcScreenSkipButtonBackground` |
| **Retry button** | Error screen | `stringOptions.nfcErrorScreenRetryButtonText` | `colorOptions.nfcErrorScreenRetryButtonTextColor` | `colorOptions.nfcErrorScreenRetryButtonBackgroundColor` | `fontOptions.nfcErrorScreenRetryButtonTextFontSize` | `fontOptions.nfcErrorScreenRetryButtonTextFont` | `layoutOptions.nfcErrorScreenRetryButtonBackground` |
| **Skip button** | Error screen | `stringOptions.nfcErrorScreenSkipButtonText` | `colorOptions.nfcErrorScreenSkipButtonTextColor` | `colorOptions.nfcErrorScreenSkipButtonBackgroundColor` | `fontOptions.nfcErrorScreenSkipButtonTextFontSize` | `fontOptions.nfcErrorScreenSkipButtonTextFont` | `layoutOptions.nfcErrorScreenSkipButtonBackground` |

```kotlin
nfcCaptureCustomizationOptions = NfcCaptureCustomizationOptions().apply {
    stringOptions.apply {
        nfcErrorScreenRetryButtonText = "Try Again"
        nfcErrorScreenSkipButtonText = "Skip"
    }
    colorOptions.apply {
        nfcErrorScreenRetryButtonTextColor = "#FFFFFF"
        nfcErrorScreenRetryButtonBackgroundColor = "#2196F3"
        nfcErrorScreenSkipButtonTextColor = "#FFFFFF"
        nfcErrorScreenSkipButtonBackgroundColor = "#9E9E9E"
    }
    fontOptions.apply {
        nfcErrorScreenRetryButtonTextFontSize = 16
        nfcErrorScreenSkipButtonTextFontSize = 16
    }
    layoutOptions.apply {
        nfcErrorScreenRetryButtonBackground = R.drawable.custom_retry_button_bg
        nfcErrorScreenSkipButtonBackground = R.drawable.custom_skip_button_bg
    }
    imageOptions.apply {
        nfcErrorScreenImage = R.drawable.custom_error_icon
    }
}
```

#### 4.5 Example

```kotlin
SDKCustomizationOptions(
    idCaptureCustomizationOptions = IDCaptureCustomizationOptions(
        enablePassportNfc = true
    ),
    nfcCaptureCustomizationOptions = NfcCaptureCustomizationOptions().apply {
        stringOptions.apply {
            nfcScreenReadyToScanTitle = "Hold your phone near the chip"
            nfcScreenSkipButtonText = "Skip for now"
            nfcErrorScreenSkipButtonText = "Skip"
        }
        colorOptions.apply {
            nfcScreenSkipButtonBackgroundColor = "#2196F3"
            nfcErrorScreenSkipButtonBackgroundColor = "#9E9E9E"
            nfcErrorScreenRetryButtonBackgroundColor = "#2196F3"
        }
        fontOptions.apply {
            nfcScreenReadyToScanTitleFontSize = 18
            nfcErrorScreenSkipButtonTextFontSize = 14
        }
    }
)
```

---

### 5. Document Capture Technical Reference (`DocumentCaptureCustomizationOptions`)

Settings for the generic (non-ID) document capture/upload flow. Unlike ID/Selfie/NFC, this class only has one customizable screen — the post-capture Preview screen — since the capture screen itself and the instruction screen (`enableDocumentInstructionScreen`) have no string/color/font/image options of their own.

| Field | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `enableDocumentInstructionScreen` | Boolean | false | Toggles the instruction screen before document capture/upload. |
| `enableDocumentCapture` | Boolean | false | Toggles capturing the document via camera. |
| `enableDocumentUpload` | Boolean | false | Toggles uploading a PDF or image file via the file manager, instead of camera capture. |
| `documentDefault_size` | Long | 2097152 | Default max document size, in bytes (2 MB). |
| `enableDocumentPreview` | Boolean | true | Toggles whether the post-capture/upload preview screen is shown. |

**Preview Screen — Text, Font & Color**

Same field pattern as the ID Capture (§2.3) and Selfie Capture (§3.2) Preview screens:

| String Key | Font Key | Color Key |
| :--- | :--- | :--- |
| `stringOptions.previewScreenTitle` | `fontOptions.previewScreenTitleFontSize`<br>`fontOptions.previewScreenTitleFont` | `colorOptions.previewScreenTitleLabelTextColor` |
| `stringOptions.previewScreenRetryBtnText` | `fontOptions.previewScreenRetryBtnFontSize`<br>`fontOptions.previewScreenRetryBtnFont` | `colorOptions.previewScreenRetryBtnTextColor`<br>`colorOptions.previewScreenRetryBtnBackgroundColor` |
| `stringOptions.previewScreenDoneBtnText` | `fontOptions.previewScreenDoneBtnFontSize`<br>`fontOptions.previewScreenDoneBtnFont` | `colorOptions.previewScreenDoneBtnTextColor`<br>`colorOptions.previewScreenDoneBtnBackgroundColor` |
| N/A | N/A | `colorOptions.previewScreenBackgroundColor` |
| N/A | N/A | `colorOptions.previewScreenTopViewBgColor` |

**Images & Layout**

| Field | Description |
| :--- | :--- |
| `imageOptions.previewScreenToolbarBackIcon` | Toolbar back icon. |
| `imageOptions.previewScreenToolbarBackIconTintColor` | Tint color for the icon above (lives in `DocumentImageOptions` despite being a color field). |
| `layoutOptions.previewScreenRetryBtnBg` | Background drawable for the Retry button. |
| `layoutOptions.previewScreenDoneBtnBg` | Background drawable for the Done button. |
| `layoutOptions.previewScreenToolbarBackIconHide` | Hides the toolbar back icon. Default `true` (hidden). |

### 6. Signature Capture Technical Reference (`SignatureCaptureCustomizationOptions`)

The smallest customization block in the SDK — currently one field, with no string/color/font/image/layout sub-options:

| Field | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `enableDocumentInstructionScreen` | Boolean | false | Toggles the instruction screen before signature capture. |

### 7. Voice Capture Technical Reference (`VoiceCaptureCustomizationOptions`)

| Field | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `recordingTimeInMinutes` | Int | 15 | Recording duration. Despite the field name, the underlying default is expressed in seconds (15s) — confirm the unit your target `DetectionConfig` value uses before relying on the field name alone. |

### 8. AutoFill Capture Technical Reference (`AutoFillCaptureCustomizationOptions`)

| Field | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `autoFillImageCaptureType` | Enum (`AutoFillImageCaptureType`) | `BOTH` | Which image(s) the autofill/OCR extraction flow captures. |
| `enableAutoFillInstructionScreen` | Boolean | false | Toggles the instruction screen before autofill capture. |


### 9. Comprehensive Usage Example (Kotlin)

```kotlin
private fun getCompleteSdkCustomization(): SDKCustomizationOptions {
    return SDKCustomizationOptions(
        language = LANGUAGE.EN.toString(),
        idCaptureCustomizationOptions = IDCaptureCustomizationOptions().apply {
            // General Configuration
            enableRealIDDetection = true
            enableIdInstructionScreen = true
            
            // Core Thresholds & Logic
            captureOptions.apply {
                allowOverrideWrongDocumentTypeAfterMs = 12000L
                wrongDocumentTypeHandlingMode = WrongDocumentTypeHandlingMode.MANUAL_CAPTURE
                frontRealnessThreshold = 0.85f
                separateIdCardCaptureSequence = true
            }
            // Strings & Feedback
            stringOptions.apply {
                captureScreenFrontIDLabel = "Verification: FRONT SIDE"
                previewScreenTitleIdFront = "FRONT VERIFIED"
                idCaptureWarningMessage = "Mismatch: Use Front side"
                moveCloser = "Bring the ID closer to the camera"
            }
            // Colors & Branding
            colorOptions.apply {
                warningLabelBackgroundColor = "#FFC107"
                progressBarColor = "#4CAF50"
                previewScreenBackgroundColor = "#F0F0F0"
                captureAnywayButtonColor = "#2196F3"
                exitButtonColor = "#2196F3"
            }
            // Typography (SP sizes and Font Resources)
            fontOptions.apply {
                labelFontSize = 18
                previewScreenTitleFontSize = 22
                labelFont = R.font.custom_bold
                previewScreenTitleFont = R.font.custom_bold_italic
            }
            // Layout & Visibility
            layoutOptions.apply {
                isIdCaptureProgressBarEnabled = true
                idCaptureProgressBarLineWidth = 8.0f
                isCaptureScreenToolbarTitleHide = true
            }
        },
        selfieCaptureCustomizationOptions = SelfieCaptureCustomizationOptions().apply {
            enableSelfieInstructionScreen = true
            captureOptions.liveFaceProbabilityThreshold = 0.92f
            stringOptions.liveFaceNotDetected = "Verification failed. Please stay in a well-lit area."
            colorOptions.captureScreenBgColor = "#121212" // Dark mode selfie
        }
    )
}
```


##### Setting an on cancelled callback

See the code snippet below for how to specify a callback function to be triggered when
cancelling/backing out of an SDK operation:

````
IdentityProofingSDK.setOnCancelled(fun() { print("Cancelled") })
````

## SDK documentation

You can find SDK
documentation <a href="https://documentation.idmission.com/identity/Android-SDK-2/-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/index.html">
here</a>

## SDK Flavours
- IdentityVideoID SDK
- IdentityVideoID SDK Without Models
- IdentityMedium SDK
- IdentityMedium SDK Without Models
- IdentityLite SDK
- IdentityLite SDK Without Models
- IdentityLiveness SDK
- IdentityLiveness SDK Without Models


## SDK Flavours Supported Features
    
|                         |  IdentityVideoID SDK   |  IdentityMedium SDK   |  IdentityLite SDK   |  IdentityLiveness SDK   |
|:-----------------------:|:----------------------:|:---------------------:|:-------------------:|:-----------------------:|
|                         | <B>IdentityVideoID SDK | <B>IdentityMedium SDK | <B>IdentityLite SDK | <B>IdentityLiveness SDK | 
|     Document Detect     |       On Device        |       On Device       |      On Device      |           N/A           |
|    Rotate, crop etc.    |       On Device        |       On Server       |      On Device      |           N/A           |
|    Document Realness    |       On Device        |       On Device       |      On Server      |           N/A           |
| Document Classification |       On Device        |       On Server       |      On Server      |           N/A           |
|   MRZ/Barcode reading   |       On Device        |       On Device       |      On Device      |           N/A           |
|     OCR from front      |       On Device        |       On Server       |      On Server      |           N/A           |
|       Face detect       |       On Device        |       On Device       |      On Device      |        On Device        |
|     Liveness detect     |       On Device        |       On Device       |      On Device      |        On Device        |
| Detect hats and glasses |       On Device        |       On Server       |      On Server      |        On Server        |
| Detect covered face (hand, scarf, closed eyes) |       On Device        |       On Device       |      On Device      |        On Device        |
|        Video ID         |       On Device        |          N/A          |         N/A         |           N/A           |

## Reduce APK size

### 1. Exclude specific ABI (Application Binary Interface) support like arm64-v8a, armeabi-v7a, x86_64, or x86
````
android {
    ...
    defaultConfig {
        ...
        ndk {
            abiFilters 'arm64-v8a' // Include only the ABIs you need
        }
    }
}
````
### 2. Enable app optimization 
````
android {
    buildTypes {
        release {
            // Enables code-related app optimization.
            isMinifyEnabled = true

            // Enables resource shrinking.
            isShrinkResources = true        
            ...
        }
    }
    ...
}        
````
### 3. Enable optimized resource shrinking, add the following to your project's gradle.properties file:
````
android.r8.optimizedResourceShrinking=true
````
### 4. Use SDK Flavours without models. Models are downloaded upon the first initialization of the SDK. 

Please note that **Download Size** in Android Studio's built-in APK Analyzer tool represents the estimated compressed size of the entity as it would be delivered by Google Play

## ProGuard / R8 Configuration

If you use ProGuard or R8 for code obfuscation and shrinking, add the following rules to your `proguard-rules.pro` file to ensure the SDK functions correctly:

```proguard
# Prevent package name conflicts
-repackageclasses 'com.idmission.sdk2.internal.obfuscated'
-allowaccessmodification
-flattenpackagehierarchy 'com.idmission.sdk2.internal.obfuscated'

# Core SDK classes
-keep class com.idmission.sdk2.identityproofing.IdentityProofingSDK { *; }
-keep class com.idmission.sdk2.client.cache.SDKCache { *; }
-keep class com.idmission.sdk2.client.model.** { *; }
-keep class com.idmission.sdk2.capture.presentation.camera.helpers.ProcessedCapture { *; }
-keep class * extends com.idmission.sdk2.capture.presentation.camera.helpers.ProcessedCapture { *; }

# Kotlin Serialization
-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}

# ML Kit & TensorFlow Lite
-keep class com.google.mlkit.** { *; }
-keep class org.tensorflow.** { *; }
-dontwarn org.tensorflow.**

# Retrofit & OkHttp
-keepattributes *Annotation*, InnerClasses, EnclosingMethod, Signature, Kotlin.Metadata
-keepclasseswithmembers interface * {
    @retrofit2.http.* <methods>;
}

# Preserve Enums
-keep public enum com.idmission.sdk2.** { *; }
```

## SDK Version History
#### v11.1.19.2.10 (22nd October 2026)
* Dynamic ID Capture & Barcode Handling: Enabled flexible two-sided ID capture that automatically detects the front and back of an ID in any order, while seamlessly processing barcode data on either side.
* Dynamic ID Orientation & Auto-Correction: Introduced a .dynamic capture mode that automatically adapts capture guidelines for horizontal or vertical IDs in real time and automatically rotates the final captured image to an upright orientation.
* NFC Support: Added optional NFC chip reading capabilities for supported IDs and passports 
  through the dedicated IDentityMediumNFC framework, allowing integrators to include or exclude NFC functionality based on application requirements.
* NFC Data Extraction & Modular Framework: Added support for extracting NFC chip data and 
   artifacts, including face images, document images, and digital signatures, through the modular NFC framework.
* Server Payload & Swagger v4 Support: Updated API data models to Swagger v4 specifications to 
   support transmitting extracted NFC chip artifacts, including face images, document images, and digital signatures, directly to the backend server.
* Android SDK Size Reduction: Optimized the SDK footprint by replacing PNG assets with WebP, 
  stripping unused native code, removing unused resources, and unifying serialization libraries with kotlinx.serialization.
* MRZ Extraction Improvements: Enhanced Machine Readable Zone (MRZ) capture reliability and 
  performance.
* Stability & Crash Handling: Improved internal crash handling to prevent unexpected application 
  termination during scanning sessions.
* Bug Fix – Event Log URL: Fixed an issue where switching environments did not update the 
  Event_log endpoint URL correctly.
* OpenSSL Library Upgrade: Updated the bundled OpenSSL library to the latest supported version 
  for improved security and stability.


#### v11.1.13.2.18 (23rd July 2026)
* Added a maximum retry limit for ID and selfie capture.
* Added a conditional ID success preview screen.
* Added a conditional selfie success preview screen.
* Added a barcode cropping support.
* Added a barcode recovery flow.
* Added on-device AAMVA parsing.
* Added support for mandatory geolocation enforcement.
* Added support for vertical ID capture orientation.
* Implemented image sequence animations for the Vertical ID capture instruction screen.
* Implemented image sequence animations for the ID capture instruction screen.
* Removed glasses detection from the Android Liveness module.
* Fixed an issue where the larger selfie image size on Pixel 8 devices caused increased upload time.
* Updated Android SDK 2.0 to prevent uploading screen and photocopy images to GTE when the Real ID Check is disabled.
* Updated the SDK initialization endpoint.

#### v11.1.07.2.23 (28th April 2026)
* Added customizable properties
* Updated DocumentDetect model with ID back-side prediction
* Reduced overall SDK package size
* Introduced a timeout timer for capture to improve user flow and prevent indefinite waiting.
* Implemented prompt and error messages on the ID Capture screen and Selfie screen aligned with 
  iOS behavior.
* Added support for separate front and back ID capture flow for improved control and user 
  experience.


#### v11.1.01.2.04 (15th January 2026)
* Server-Side Autofill Implementation
* UI Enhancements to support additional options for customizations.

#### v10.1.24.2.04 (08th December 2025)
* Added event logging capability within the SDK
* Security Enhancements
* Updated the SDK to ensure Error Code 31 is no longer shown to end users
* Removal of NFC passport scanning functionality from Full SDK version
* Removal of ImageLabeling module in Medium SDK
* Enabled more efficient multi-document workflows in custom product

#### v10.1.18.2.01 (11th November 2025)
* Updated the default maximum allowed fake face capture count from 15 to 10.

#### v10.1.16.2.11 (25th August 2025)
* Updated new encryption and decryption logic.
* Ability to submit request on custom product.
* Updated Google Play Store policy requirements (Android 35).
* Updated native .so with 16KB page size as per Google Play Store policy.
* UI improvement related to the Continue button.

#### v10.1.12.2.10 (24th June 2025)
* Added support for custom product request.

#### v10.1.4.2.03 (26th February 2025)
* Reduced the overall size of SDK.
* Added configuration options to change the sequence of ID and Selfie capture.
* Added support for the face mask detection model in the Medium version of the Android SDK.
* Updated libraries to comply with Google Play Policy changes for READ_MEDIA_IMAGES and READ_MEDIA_VIDEO.
* Added support to customize overlay and instruction images.
* Non-English data fields are included in the response.
* Updated all default AI models to the latest versions.

#### v9.6.24.2.15 (03rd December 2024)
* Improved capture quality with model updates that notify users of obstructions over key ID information.

#### v9.6.22.2.13 (18th November 2024)
* Integrated the latest swagger V4 API version. This includes updates to model download based on 
  V4, updates to the new initialization process, as well as ensuring backward compatibility.
* Added the selfie image in the response.
* Added support for an initialization parameter that will enable / disable Location / GPS capture.
* Improved ID capture guidance messages to inform the user to hold still once the document is 
  detected to ensure a higher quality capture.
* Added configuration support to allow selfie capture with the back camera.
* Added support for additional date and timestamp capture as Exif for ID capture and Selfie 
  capture image.
* QR code for the test applications supports the new initialization process.
* Update to support multiple security enhancements including the removal of outdated/unused 
  libraries.
* Enhanced API 34 Support in Android
* Bug fixes and performance improvements.
* Updated all default AI models to the latest versions.

##### v9.6.4.2.07 (February 2024)
* Reduce response callback time for SDK Initialization Method.
* Use the doc-detect model to determine document is ID or Passport.
* Updated all default AI models to the latest versions.
  
##### v9.6.3.2.04 (January 2024)
* Updated SDK support for additional flags (sendProcessedImagesInResponse 
and sendInputImagesInResponse)
* Added ID extracted profession and profession non English data in response
* Updated all default AI models to the latest versions.

##### v9.5.18.2.03 (December 2023)
* Changed default app_name key to sdk_app_name.
* Updated all default AI models to the latest versions.

##### v9.5.15.2.09 (November 2023)
* Enhanced Android SDK to support a new feature for voice capture.
* Enhanced Android SDK to support a new face focus model for improved quality at the time of capture.
* Updated the Android SDK to ensure the user is not prompted for file storage permission for ID capture as no images are stored on the device.
* Updated the Android SDK with new Spanish translations for server response status messages.
* Updated the base URLs used in Android SDK for initialization to ensure they are consistent.
* Updated fingerprint feature libraries to be consistent with SDK 1.0
* Updated all default AI models to the latest versions.

##### v9.5.9.2.05
* UI Changes and bug Fixes for Passport NFC detection
* Removed Firebase Analytics
* Bug fixes and performance improvements.

##### v9.5.7.2.08
* Integrate ID Chip reading ability for passport
* Improvement for real ID detection and bug fixes.

##### v9.5.4.2.02
* Fixed GTE Data upload issue for ID capture

##### v9.5.3.2.04
* Updated all local models

##### v9.5.2.2.06
* Updated focus model to be downloaded from server and updated
* default focus threshold.
* Updated UI elements to allow for customization by integrator - all UI elements are now customizable.
    - Instruction Screen button text and colors
    - Instruction text and colors
* Enhancements added to improve handling of Video ID

##### v9.4.8.2.15

* New IdentityVideoID SDK for capturing a selfie and ID to match against a previous ID validation
  call, and then recording a video instructing the user to speak a customizable phrase.
* Added SignatureCapture support
* Added FingerPrintCapture support

##### v9.3.10.2.9

* Prevent two faces from being captured during selfie capture.
* Model Decryption using latest algorithm(AES/GCM/NoPadding).
* Handle the CAN BC DL barcode XSLT
* Added Spanish language support
* Now fitting instead of filling the camera preview to better support the 600px height requirement.
* Added additional customer response data parameters;  `state` and `postalCode`.
* Updated instruction screen for IDCapture & SelfieCapture
* Bug fixes and performance improvements.

##### v9.3.4.2.8

* Additional document upload and capture feature.
* Added customization of overlay images while capturing ID and selfie.
* Added focus model for better image capture.
* Bug fixes and performance improvements.

##### v9.3.1.7

* Autofill.
* Added SDK UI Customization.
* Instruction screens for selfie and ID capture.
* Bug fixes and performance improvements.

##### v9.2.3.4

* Bug fixes and performance improvements

##### v9.1.7.20

* Enrollment
* Enrollment with Biometrics
* Customer Verification
* ID Validation and face match
