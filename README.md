## Setup

* Clone the repo
* Install dependencies `mvn compile`
* Update `*.conf.json` files inside the `src/test/resources/conf` directory to modify the capabilities

## Running your tests

- Upload your Native App (.apk file) to BrowserStack servers using upload API:

  ```
  curl -u "username:accesskey" -X POST "https://api.browserstack.com/app-automate/upload" -F "file=@/path/to/app/file/Application-debug.apk"
  ```

- If you do not have an .apk file and looking to simply try App Automate, [you can download our sample app and upload](https://www.browserstack.com/app-automate/sample-apps/android/WikipediaSample.apk)
to the BrowserStack servers using the above API.
- Update the desired capability "app" with the App URL returned from the above API call
- To run parallel tests, run `mvn test -P parallel`

## Notes
* You can view your test results on the [BrowserStack Automate dashboard](https://www.browserstack.com/automate)
* Refer [Get Started](https://www.browserstack.com/app-automate/get-started#getting-started) document to configure the capabilities

## Additional Resources
* [Getting Started with App Automate](https://www.browserstack.com/app-automate/get-started)
