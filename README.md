# Module IDentity SDK

## Introduction

This guide introduces the IDentity iOS SDK within the IDmission product suite. Developers, project managers and QA testers should reference this guide for information on configuration and use of the IDentity SDK on the iOS platform. We recommend reviewing the entire implementation guide to fully understand the IDentity SDK functionality and its respective capabilities.

This guide details processes and procedures for embedding the IDentity SDK into your host application and utilizing its current features. For additional IDentity SDK support, please contact our Customer Support team at support@idmission.com.


## Overview and Key Features

The IDmission IDentity SDK is a comprehensive toolkit that enables the use of any combination of factors of identity to complete digital transformation goals. The goal of the IDentity SDK is to offer seamless integration into an existing digital paradigm where the end-to-end customer experience is still owned and managed in-house.

## Quick Links to get started with IDentity SDK for Android
SDK Flavours Download Links - As per your requirement you can downloads the below IDentitySDK / IDentityMediumSDK / IDentityLiteSDK.

[Download IDentitySDK](https://github.com/Idmission-LLC/Sdk2SampleDemo) - Directly links to the IDentitySDK Sample app on IDmission GitHub Repository <br/>
[Download IDentityMediumSDK](https://github.com/Idmission-LLC/MediumSdk2SampleDemo) - Directly links to the IDentityMediumSDK Sample app on IDmission GitHub Repository
<br/>
[Download IDentityLiteSDK](https://github.com/Idmission-LLC/LiteSdk2SampleDemo) - Directly links to the IDentityLiteSDK Sample app on IDmission GitHub Repository
<br/>

[SDK Documentation](https://demo-documentation.idmission.com/Android-SDK-2/-i-dentity%20-s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/index.html) - Directly links to the Identity Proofing SDK

<br/>

The main features supported in this SDK are:
<br/>
- [Live face Check](https://demo-documentation.idmission.com/Android-SDK-2/-i-dentity%20-s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/live-face-check.html)<br/>
- [ID Validation](https://demo-documentation.idmission.com/Android-SDK-2/-i-dentity%20-s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/id-validation.html)<br/>
- [ID Validation and face match](https://demo-documentation.idmission.com/Android-SDK-2/-i-dentity%20-s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/id-validation-and-match-face.html)<br/>
- [Enrollment](https://demo-documentation.idmission.com/Android-SDK-2/-i-dentity%20-s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/id-validation-andcustomer-enroll.html)<br/>
- [Enrollment with Biometrics](https://demo-documentation.idmission.com/Android-SDK-2/-i-dentity%20-s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/customer-enroll-biometrics.html)<br/>
- [Customer Verification](https://demo-documentation.idmission.com/Android-SDK-2/-i-dentity%20-s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/customer-verification.html)<br/>
- [ID Validation and face match](https://demo-documentation.idmission.com/Android-SDK-2/-i-dentity%20-s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/id-validation-and-match-face.html)<br/><br/>

Additional functions are also detailed in the [SDK Documentation](https://demo-documentation.idmission.com/Android-SDK-2/-i-dentity%20-s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/index.html)


<br/>
Note: When using the IDentity SDK, you do not need to create a request for XML; it is automatically generated by the SDK based on the function that you are calling


## Getting Started

1. Please contact to sales@idmission.com for Login Credentials, which you will later pass to the SDK.

2. Go to your **project-level** build.gradle file, and add the following in the
```
allprojects {  
    repositories {  
        google()  
        jcenter()  
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
    }  
}
```


3.	In your **app-level** build.gradle file, add the following:
```
android {  
    // Java 8 is required for CameraX  
    compileOptions {  
        sourceCompatibility JavaVersion.VERSION_1_8  
        targetCompatibility JavaVersion.VERSION_1_8  
    }  
    kotlinOptions {  
        jvmTarget = '1.8'  
    }  
}

//Full SDK
dependencies {  
     implementation 'com.idmission.sdk2:idmission-sdk:9.2.3.4'     
}

//Medium SDK
dependencies {  
     implementation 'com.idmission.sdk2:idmission-mediumsdk:9.2.3.4'     
}

//Lite SDK
dependencies {  
     implementation 'com.idmission.sdk2:idmission-litesdk:9.2.3.4'     
}
```

4. Sync your project with Gradle
5. You may now use the library. Example usage below:
```
class LaunchActivity : Activity() {    

    private val launcher = IdMissionCaptureLauncher()    
    
    override fun onCreate(savedInstanceState: Bundle?) {  
        super.onCreate(savedInstanceState)  
        setContentView(R.layout.activity_launch)
        
        //SDk initialize call
        init_button.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                var response: Response<InitializeResponse>
                withContext(Dispatchers.IO) {
                    response = IdentityProofingSDK.initialize(
                        applicationContext,
                        initializeApiBaseUrl, 
                        apiBaseUrl, 
                        loginID,
                        password,
                        merchantID,
                        enableDebug,
                        enableGPS,
                        uiCustomizationOptions = UiCustomizationOptions(
                            language = LANGUAGE
                                .valueOf(language!!)
                        ),
                    )
                }
        }
        
    //Call Enroll Service 
        someButton.setOnClickListener {
            IdentityProofingSDK.idValidationAndcustomerEnroll(
                this,
                uniqueNumber = uniqueNumber.text.toString()) 
        }  
        
        // finalSubmit call for submit data to the server
        submitDataButton.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                IdentityProofingSDK.finalSubmit(
                    applicationContext
                )
            }
        }  
     

    // capture result is received in onActivityResult    
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {  
        data ?: return  
        if (requestCode != IdMissionCaptureLauncher.CAPTURE_REQUEST_CODE) return  
        val processedCaptures = launcher.processResult(data)  
        // do whatever you want with the data!  
    } 
```

#### Parameters Used-

#####  SDK initialization-

- [initializeApiBaseUrl] - Base url provided by Idmission to initialize the SDK.
- [apiBaseUrl] - Base url provided by Ismission for API calls.
- [loginId] - LoginId provided by Idmission.
- [password] - Password you have created with loginId.
- [merchantId] - MerchantId provided by idmission.
- [enableDebug] - (Boolean) If you want to enable debug options or not.
- [enableGPS] - (Boolean) If you want to enable GPS options or not.
- [uiCustomizationOptions] - UIcustomization options if you want to add your customized UI details.

##### Service Enroll Call

- [UniqueNumber] - Unique Number required.

## SDK documentation

You can find SDK documentation [here](https://demo-documentation.idmission.com/Android-SDK-2/-i-dentity%20-s-d-k/com.idmission.sdk2.identityproofing/-identity-proofing-s-d-k/index.html)

## SDK Flavours
- Identity SDK
- IdentityMedium SDK
- IdentityLite SDK

## SDK Flavours Supported Features
|  | Identity SDK | IdentityMedium SDK | IdentityLite SDK |
| :---: | :---: | :---: | :---: |
| Document Detect | On Device | On Device |On Device|
| Rotate, crop etc. | On Device | On Server |On Server|
| Document Realness | On Device | On Server |On Server|
| Document Classification | On Device | On Server |On Server|
| MRZ/Barcode reading | On Device | On Device |On Server|
| OCR from front | On Server | On Server |On Server|
| Face detect | On Device | On Device |On Device|
| Liveness detect | On Device | On Device |On Device|
| Detect hats and glasses | On Device | On Server |On Server|

## SDK Version History
##### v9.1.7.20
* Enrollment
* Enrollment with Biometrics
* Customer Verification
* ID Validation and face match

##### v9.2.3.4
* Bug fixes and performance improvements


```
