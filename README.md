# Arkademi
Go Learn with the Real World

## Instructions
  With this application being our very first experience in using both Android Studio and Kotlin, we decided to create two separate projects. One for testing ARCore, and one for creating the frame and layout of Arkademi. We decided to later merge this project but we had lots of major problems regarding that. That's why we have 2 applications for you to test.
  
  For Google ARCore to play, you will need an ARCore supported device which we will link below. There are some articles on how to use ARCore apps on a non-supported device but we still haven't tried that so we don't recommend you to try it.
  
  **ARCore Supported Devices:**
  https://developers.google.com/ar/discover/supported-devices
  
  **Arkademi.apk** - This contains the entire app minus the AR lessons. Can run on any device running Android 7.0 or later.
  
  **AR_kademi.apk** - This contains the sample AR lessons we've created for this prototype. An ARCore supported device is required.
  

## Known Issues
1. When the menu button is opened and then closed. The fragment are unclickable. You can't scroll or tap the buttons. However you can still click the buttons above to change fragments.
2. In the navigation drawer menu, once you've clicked the Data Saver button. It would stay checked forever.
3. When tried in an Android Device with an API level of 22 (Lollipop 5.1). The intro video wouldn't load, some images are stretched, and eventually the app crashes. Because of this we set the minimum API level to 24(Nougat 7.0).
