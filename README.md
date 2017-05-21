# Companion For PUBG
##### The unofficial PUBG Companion App.

### What is it?
Companion For PUBG is an unofficial companion Android app for PlayerUnknown's Battlegrounds. Its community 
driven to provide players with the latest and most up to date information on maps, items,
vehicles and news.

### How to contribute
Submit pull requests here. Help us review pull requests and most importantly help keep our data 
and images up to date. **Most of our data is unfinished with placeholders. Any help updating it would be most appreciated!** We also have a (somewhat) organized list of tasks we need help with, they can be seen in the Projects tab above.

Data json files can be found here: https://github.com/ZafraniTechLLC/Companion-For-PUBG-Android/tree/master/app/src/main/assets

Images and map tiles can be found here: https://github.com/ZafraniTechLLC/Companion-For-PUBG-Images

### How to build
1. Clone/Download the repository and open in Android Studio
2. Add a file inside of `PUBG-Companion/app/src/main/res/values/` called `local-strings.xml`
3. Paste the following inside of it:
    ```xml
    <resources>
        <string name="local_maps_api_key">GOOGLE_MAPS_API_KEY</string>
    </resources>
    ```
4. Go to https://console.developers.google.com/apis/api/maps_android_backend/overview
5. Create a project. It will take a minute or two to finish. Upon creation enable `Google Maps Android API`
7. Create credentials for an API key. Assuming you will only test this locally, you don't need to restrict the key.
7. In `local-strings.xml` replace GOOGLE_MAPS_API_KEY with the API key you created.

### Reach out
Contact us with feedback, ideas and requests via email - support@zafrani.tech 
