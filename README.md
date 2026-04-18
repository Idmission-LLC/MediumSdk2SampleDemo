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

SDK Flavours Download Links - As per your requirement you can downloads the below IDentitySDK /
IDentityMediumSDK / IDentityLiteSDK / IDentityVideoIDSDK.

[Download IDentitySDK](https://github.com/Idmission-LLC/Sdk2SampleDemo) - Directly links to the
IDentitySDK Sample app on IDmission GitHub Repository <br/>
[Download IDentityMediumSDK](https://github.com/Idmission-LLC/MediumSdk2SampleDemo) - Directly links
to the IDentityMediumSDK Sample app on IDmission GitHub Repository
<br/>
[Download IDentityMediumSDKWithoutModels](https://github.com/Idmission-LLC/MediumSdk2WithoutModelsSampleDemo) - Directly links
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
  Final Submit</a><br/><br/>

### Technical Prerequisites

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
<uses-feature android:name="android.hardware.nfc" android:required="false" />

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
<uses-permission android:name="android.permission.NFC" />
```

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
         implementation 'com.idmission.sdk2:idmission-mediumsdk:11.1.07.2.20'     
    }

    //IdentityMediumWithoutModels SDK
    dependencies {  
         implementation 'com.idmission.sdk2:idmission-mediumsdkwithoutmodels:11.1.07.2.20'     
    }
    
    //IdentityLite SDK
    dependencies {  
         implementation 'com.idmission.sdk2:idmission-litesdk:11.1.07.2.20'     
    }

    //IdentityLiteWithoutModels SDK
    dependencies {  
         implementation 'com.idmission.sdk2:idmission-litesdkwithoutmodels:11.1.07.2.20'     
    }
    
    //IdentityLiveness SDK
    dependencies {  
    implementation 'com.idmission.sdk2:idmission-livenesssdk:11.1.07.2.20'     
    }

    //IdentityLivenessWithoutModels SDK
    dependencies {  
        implementation 'com.idmission.sdk2:idmission-livenesssdkwithoutmodels:11.1.07.2.20'     
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
         implementation 'com.idmission.sdk2:signatureLib:11.01.07.04'    
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

| Field | Type | Description |
| :--- | :--- | :--- |
| `language` | Enum | Application default language (EN, ES, FR, HI, etc.). |
| `bothCameraToggle` | Boolean | Enable camera toggle for both selfie and document camera. |
| `documentCameraToggle` | Boolean| Enable camera toggle button specifically in document view. |
| `liveFaceCameraToggle` | Boolean | Enable camera toggle button specifically in Selfie view. |
| `defaultLiveFaceCamera`| Enum | Default camera facing for Selfie (`FRONT` or `BACK`). |
| `defaultDocumentCamera`| Enum | Default camera facing for Document (`FRONT` or `BACK`). |
| `documentCameraOrientation`| Enum | Capture orientation (`PORTRAIT` or `LANDSCAPE`). |
| `isDebugMode` | Boolean | Toggles display of debug information overlay during capture. |
| `isScreenRecordingEnabled`| Boolean| Toggles permission for screen recording and screenshots. |

#### Sub-Option Modules
The main class also hosts specialized customization blocks for each workflow:
- `idCaptureCustomizationOptions`: Logic and UI for identity documents.
- `selfieCaptureCustomizationOptions`: Logic and UI for liveness and face capture.
- `documentCaptureCustomizationOptions`: Settings for generic document capture.
- `signatureCaptureCustomizationOptions`: Settings for signature pad screens.
- `voiceCaptureCustomizationOptions`: Settings for voice recording/biometrics.
- `autoFillCaptureCustomizationOptions`: Settings for automated data extraction flows.

---

### 2. ID Capture Technical Reference (`IDCaptureCustomizationOptions`)

The `IDCaptureCustomizationOptions` class contains settings specific to the document scanning workflow.

#### 2.1 General ID Capture Settings

| Field | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `enableRealIDDetection` | Boolean | true | Toggles real ID detection logic. |
| `enableUploadIDData` | Boolean | true | Toggles uploading ID data to the GTE service. |
| `enableIDCapture4K` | Boolean | false | Toggles 4K resolution for ID capture. |
| `enableIdInstructionScreen` | Boolean | false | Toggles the instruction screen before ID capture. |
| `enableDocumentInstructionScreen` | Boolean | false | Toggles instruction screen for generic documents. |
| `enablePassportNfc` | Boolean | false | Toggles NFC scanning for passports (VideoID only). |
| `performIdCaptureBeforeSelfie` | Boolean | false | Forces ID capture before Selfie. |
| `isSecondaryID` | Boolean | false | Marks the capture as a secondary ID. |

#### 2.2 ID Capture Core Logic (`IDCaptureOptions`)

| Field | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `documentFrameWidthRatio` | Float | 1.428 | Target aspect ratio for the document frame. |
| `frontRealnessThreshold` | Float | 0.8 | Threshold for front ID realness detection. |
| `backRealnessThreshold` | Float | 0.8 | Threshold for back ID realness detection. |
| `frontDocumentConfidence` | Float | 0.7 | Classification confidence for front ID. |
| `backDocumentConfidence` | Float | 0.7 | Classification confidence for back ID. |
| `lowerWidthThresholdTolerance` | Float | 0.2 | Min width tolerance for auto-capture. |
| `upperWidthThresholdTolerance` | Float | 0.05 | Max width tolerance for auto-capture. |
| `focusThreshold` | Float | 0.98 | Minimum focus probability required. |
| `fingerDetectionThreshold` | Float | 0.30 | Sensitivity for finger detection. |
| `glareDetectionThreshold` | Float | 0.20 | Sensitivity for glare detection. |
| `minMrzConfidence` | Float | 0.50 | Minimum MRZ reading confidence. |
| `minBarcodeConfidence` | Float | 0.50 | Minimum barcode reading confidence. |
| `documentBackComponentConfidence` | Float | 0.70 | Back component detection confidence. |
| `allowOverrideWrongDocumentTypeAfterMs` | Long | 8000 | Timeout before allowing mismatch override. |
| `wrongDocumentTypeHandlingMode` | Enum | MANUAL | `MANUAL_CAPTURE` or `AUTO_CAPTURE` logic. |
| `wrongDocumentTypeWarningDelayInSec` | Int | 5 | Seconds before showing the warning label. |
| `separateIdCardCaptureSequence` | Boolean | false | Toggles separate ID card preview flow. |

#### 2.2 ID Strings & Prompts (`IDStringOptions`)

| Field | Description |
| :--- | :--- |
| `captureScreenFrontIDLabel` | Custom label for "Scan the Front of your ID". |
| `captureScreenBackIDLabel` | Custom label for "Scan the Back of your ID". |
| `captureScreenBarcodeLabel` | Custom label for "Scan the Barcode on the Back...". |
| `captureScreenDocumentCaptureLabel` | Custom label for generic "Frame Your Document" screens. |
| `captureScreenError` | Toast message shown when face/text detection fails. |
| `captureScreenBarcodeError` | Toast message shown when barcode detection fails. |
| `moveCloser` / `moveAway` | Feedback prompts for document distance adjustment. |
| `alignRectangle` | Prompt for manual alignment inside the capture frame. |
| `useFront` / `useBack` | Orientation prompts for the document sides. |
| `makeSurePhotoTextVisible` | General visibility instruction text. |
| `scanBarcode` / `makeSureBarcodeVisible` | Specific instructions for barcode capture fallback. |
| `frontBackMismatch` | Mismatch warning header text. |
| `flipToBack` | Prompt text instructing the user to flip the ID. |
| `tooMuchGlare` / `tooMuchDark` / `tooBlurry` | Real-time quality feedback prompts. |
| `retryScreenLabelText` | Main error message on the Retry screen. |
| `retryButtonText` | Label for the retry action button. |
| `retryScreenCancelButtonText` | Label for the cancel/exit button on retry screen. |
| `idInstructionText` | Title/Header on the pre-capture instruction screen. |
| `idInstructionScreenButtonText` | Label for the "Continue" button on instruction screen. |
| `documentInstructionText` | Alternative instruction text for document flows. |
| `captureScreenCancelBtnText` | Toolbar cancel button text. |
| `documentDetectedIdHoldText` | Post-detection "Hold still" instruction. |
| `incorrectDocumentSideBackText` | Alert message when identifying a Front when Back is expected. |
| `incorrectDocumentSideFrontText`| Alert message when identifying a Back when Front is expected. |
| `autofillInstructionsText` | Guidance for the autofill/OCR data extraction sequence. |
| `alignDocumentText` | Persistent instruction to align the document. |
| `fingerDetectedOnIdText` | Floating warning when a finger obscures the ID. |
| `glareDetectedOnIdText` | Floating warning when light glare obscures the ID. |
| `idCaptureWarningMessage` | Message shown on the yellow tooltip for side-mismatch. |
| `idCaptureFrontWarningMessage` | Message specifically for unexpected front side detection. |
| `captureAnywayButtonText` | Override button text in manual mismatch handling mode. |
| `previewScreenTitleIdFront` | Navigation title shown after successful Front ID capture. |
| `previewScreenTitleIdBack` | Navigation title shown after successful Back ID capture. |
| `previewScreenRetryBtnText` | Text for the retry action on confirmation screen. |
| `previewScreenDoneBtnText` | Text for the "Proceed/Done" action on confirmation screen. |

#### 2.3 ID Visuals & Colors (`IDColorOptions`)

| Field | Description |
| :--- | :--- |
| `captureScreenBgColor` | Main capture screen background color (Hex). |
| `captureScreenTopBarBgColor` | Toolbar background color (Hex). |
| `captureScreenCancelBtnTintColor` | Tint for the top-bar cancel button icon. |
| `captureScreenFrontIDLabelColor` | Color for front-side specific instruction text. |
| `captureScreenBackIDLabelColor` | Color for back-side specific instruction text. |
| `captureScreenDocumentCaptureLabelColor`| Color for generic document instruction text. |
| `topBarCancelBtnTextColor` | Color for the cancel button text label. |
| `captureScreenErrorTextBgColor` | Background color for floating error tooltips. |
| `captureScreenErrorTextColor` | Text color for floating error tooltips. |
| `captureScreenSuccessTextBgColor` | Background color for floating success tooltips. |
| `captureScreenSuccessTextColor` | Text color for floating success tooltips. |
| `captureScreenInfoTextBgColor` | Background for non-critical info tooltips. |
| `captureScreenInfoTextColor` | Text color for non-critical info tooltips. |
| `instructionScreenBackgroundColor` | Overall background for the instruction screen. |
| `instructionScreenLabelTextColor` | Text color for instruction body labels. |
| `instructionScreenButtonTextColor` | Text color for the primary instruction button. |
| `instructionScreenLabelTextBgColor` | Background card color for instruction text. |
| `instructionScreenButtonBackgroundColor`| Background color for the primary instruction button. |
| `instructionScreenBackButtonTintColor` | Tint for the navigation back button on instructions. |
| `retryScreenBackgroundColor` | Overall background for the retry screen. |
| `retryScreenLabelTextColor` | Text color for error messages on retry screen. |
| `retryScreenImageTintColor` | Color tint for retry-related illustrations. |
| `retryScreenDoneButtonTextColor` | Text color for the "Done/Exit" button on retry. |
| `retryScreenRetryButtonTextColor` | Text color for the "Retry" button on retry screen. |
| `retryScreenDoneButtonBgColor` | Background for the "Done/Exit" button on retry. |
| `retryScreenRetryButtonBgColor` | Background for the "Retry" button on retry screen. |
| `warningLabelBackgroundColor` | Background color for side-mismatch yellow alerts. |
| `warningLabelTextColor` | Text color for side-mismatch yellow alerts. |
| `captureAnywayButtonColor` | Background color for the mismatch override button. |
| `captureAnywayButtonTextColor` | Text color for the mismatch override button. |
| `progressBarColor` | Color for the animated auto-capture progress circle. |
| `previewScreenBackgroundColor` | Overall background of the post-capture preview screen. |
| `previewScreenTopViewBgColor` | Toolbar background on the preview screen. |
| `previewScreenTitleLabelTextColor` | Navigation title color on the preview screen. |
| `previewScreenRetryBtnBackgroundColor` | Background for retry button on confirmation screen. |
| `previewScreenRetryBtnTextColor` | Text color for retry button on confirmation screen. |
| `previewScreenDoneBtnBackgroundColor` | Background for done button on confirmation screen. |
| `previewScreenDoneBtnTextColor` | Text color for done button on confirmation screen. |

#### 2.4 ID Typography (`IDFontOptions`)

| Field | Description |
| :--- | :--- |
| `captureScreenFrontIDTextFont` | Font resource (`R.font.*`) for front side labels. |
| `captureScreenFrontIDTextFontSize` | Font size (SP) for front side labels. |
| `captureScreenBackIDTextFont` | Font resource (`R.font.*`) for back side labels. |
| `captureScreenBackIDTextFontSize` | Font size (SP) for back side labels. |
| `captureScreenDocumentCaptureTextFont` | Font resource (`R.font.*`) for document labels. |
| `captureScreenDocumentCaptureTextFontSize`| Font size (SP) for document labels. |
| `labelFont` / `labelFontSize` | Default typography for instruction text. |
| `labelPromptFont` / `FontSize` | Default typography for floating user prompts. |
| `instructionScreenLabelFont` / `Size` | Typography for body text on instruction screen. |
| `instructionScreenButtonFont` / `Size` | Typography for the primary button on instructions. |
| `retryScreenLabelTextFont` / `Size` | Typography for main error labels on retry screens. |
| `retryScreenDoneButtonFont` / `Size` | Typography for the "Done" button on retry screens. |
| `retryScreenRetryButtonFont` / `Size` | Typography for the "Retry" button on retry screens. |
| `warningLabelFont` / `FontSize` | Typography for side-mismatch floating alerts. |
| `captureAnywayButtonTextFont` / `Size`| Typography for the override button text. |
| `previewScreenTitleFont` / `FontSize` | Typography for the post-capture success title. |
| `previewScreenRetryBtnFont` / `Size` | Typography for the confirmation retry button. |
| `previewScreenDoneBtnFont` / `Size` | Typography for the confirmation done button. |

#### 2.5 ID Images & Icons (`IDImageOptions`)

- **Retry Illustration**: `retryScreenImage`
- **ID Silhouettes**: `captureScreenIdFrontOverlayImage`, `captureScreenIdBackOverlayImage`
- **Instruction Images**: `idInstructionImageResId`, `idInstructionBackImageResId`, `documentInstructionImageResId`
- **Toolbars**: `captureBottomBarImage`, `captureScreenCancelBtnImage`
- **Preview Icons**: `previewScreenToolbarBackIcon`, `previewScreenToolbarBackIconTintColor`

#### 2.6 ID Layout & Visibility (`IDLayoutOptions`)

- **Alignment**: `captureLabelGravity` (CENTER/TOP/BOTTOM), `topBarCancelButtonGravity` (START/END).
- **Background Drawables**: `instructionContinueBtnBg`, `retryScreenDoneBtnBg`, `retryScreenRetryBtnBg`, `previewScreenRetryBtnBg`, `previewScreenDoneBtnBg`.
- **Visibility Toggles**: `instructionBackBtnHide`, `previewScreenToolbarBackIconHide`, `isCaptureScreenToolbarTitleHide`.
- **Advanced Layout**: `instructionLabelTextBgCardElevation`, `isIdCaptureProgressBarEnabled`, `idCaptureProgressBarLineWidth`.

---

### 3. Selfie Capture Technical Reference (`SelfieCaptureCustomizationOptions`)

#### 3.1 Selfie Capture Logic (`SelfieCaptureOptions`)

| Field | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `minFaceWidth` | Float | 0.6 | Min face width relative to the frame for capture. |
| `eyeOpenProbability` | Float | 0.4 | Detection threshold for eyes open/closed prompts. |
| `minHeadEulerAngle` | Float | -10 | Min head tilt threshold for pose validation. |
| `maxHeadEulerAngle` | Float | 10 | Max head tilt threshold for pose validation. |
| `minRelativeNoseHeight` | Float | 0.48 | Min nose vertical limit to ensure face centering. |
| `maxRelativeNoseHeight` | Float | 0.67 | Max nose vertical limit to ensure face centering. |
| `labelsConfidenceThreshold` | Float | 0.79 | Detection confidence for accessories like glasses. |
| `faceMaskProbabilityThreshold` | Float | 0.98 | Detection confidence for face masks. |
| `liveFaceProbabilityThreshold` | Float | 0.9 | Critical threshold for liveness/realness grading. |
| `consecutiveFakeFaceLimit` | Int | 10 | Failed attempts allowed before showing retry. |
| `lightIntensityThreshold` | Float | 0.05 | Sensitivity for shadow and over-exposure detection. |
| `capture4K` | Boolean | false | Toggles 4K resolution capture for selfie. |
| `uploadFaceData` | Boolean | true | Toggles uploading captured face to GTE servers. |
| `focusFaceThreshold` | Float | 0.20 | Focus sensitivity for selfie capture verification. |

#### 3.2 Selfie Strings & Prompts (`SelfieStringOptions`)

| Field | Description |
| :--- | :--- |
| `captureScreenToolbarTitleText` | Custom title for the selfie capture toolbar. |
| `captureScreenLabel` | Instructional prompt to frame the face. |
| `captureScreenError` | Generic error message for detection failure. |
| `moveCloser` / `moveAway` | Feedback prompts for face distance adjustments. |
| `alignInsideOval` | Instruction to center the face within the UI oval. |
| `capturingFace` | Message shown exactly during the capture event. |
| `realFace` / `fakeFace` | Real-time liveness verification feedback markers. |
| `leftEyeClosed` / `rightEyeClosed` | Specific eye-status feedback prompts. |
| `faceMaskDetected` | Shown when detection is obscured by a mask. |
| `tooMuchLight` / `tooDark` | Quality feedback regarding ambient environment. |
| `straightenHead` / `eyesClosed` | Specific pose correction instructions. |
| `multipleFaces` | Alert when more than one face is in the frame. |
| `moveFaceDown` / `moveFaceUp` | Specific vertical adjustment instructions. |
| `glassesDetected` / `hatDetected` | Instruction to remove obscuring accessories. |
| `handDetected` | Shown when common gestures cover the face. |
| `scarfDetected` / `maskDetected` | Accessory-specific detection alerts. |
| `retryScreenLabelText` | Main error message on the Selfie Retry screen. |
| `retryButtonText` | Label for the "Retry" action button. |
| `retryCancelButtonText` | Label for the "Cancel/Exit" action button. |
| `selfieInstructionText` | Body text for pre-capture selfie instructions. |
| `selfieInstructionScreenButtonText` | Continue button label for selfie instructions. |
| `faceNotInFocus` | Alert when focus quality is insufficient for capture. |
| `liveFaceNotDetected` | Refined liveness failure prompt for the user. |

#### 3.3 Selfie Visuals, Typography & Images (Summary)

Configuring Selfie specifics follows the same detailed inheritance pattern as `IDCapture`:
- **Colors**: `topBarTitleTextColor`, `captureScreenBgColor`, `captureScreenTopBarBgColor`, `captureScreenToolbarTitleTextColor`, `captureScreenCancelBtnTintColor`, `captureScreenErrorTextBgColor`, `captureScreenSuccessTextBgColor`, `captureScreenInfoTextBgColor`, `instructionScreenBackgroundColor`, `retryScreenBackgroundColor`.
- **Fonts**: `labelFont`, `labelPromptFont`, `captureScreenToolbarTitleTextFont`, `instructionScreenLabelFont`, `instructionScreenButtonFont`, `retryScreenLabelTextFont`, `retryScreenDoneButtonFont`, `retryScreenRetryButtonFont`.
- **Images**: `captureSilhouetteImage`, `retryScreenImage`, `selfieInstructionImageResId`, `selfieInstructionBackImageResId`, `captureBottomBarImage`, `captureScreenCancelBtnImage`.
- **Layout**: `captureLabelGravity`, `topBarCancelButtonGravity`, `instructionContinueBtnBg`, `retryScreenDoneBtnBg`, `retryScreenRetryBtnBg`, `instructionBackBtnHide`, `isCaptureScreenToolbarTitleHide`.

---

### 4. Comprehensive Usage Example (Kotlin)

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
documentation <a href="./-i-dentity--s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/index.html">
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
| Detect hats and glasses |       On Device        |       On Server       |      On Server      |        On Device        |
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
#### v11.1.07.2.20 (28th April 2026)
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
