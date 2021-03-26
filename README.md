# Arkademi
Go Learn with the Real World

## Instructions
  With this application being our very first experience in using both Android Studio, we decided to create two separate projects. One for testing ARCore, and one for creating the frame and layout of Arkademi. We decided to later merge this project but we had lots of major problems regarding that. That's why we have 2 applications for you to test.
  
  For Google ARCore to play, you will need an ARCore supported device which we will link below. There are some articles on how to use ARCore apps on a non-supported device but we still haven't tried that so we don't recommend you to try it.
  
  **Arkademi.apk** - This contains the entire app minus the AR lessons. Can run on any device running Android 7.0 or later.
  
  **AR_kademi.apk** - This contains the sample AR lessons we've created for this prototype. An ARCore supported device is required.
  
  ## Interactables
   **Discover Section** - You can tap the images and a ripple effect will show. It won't open any AR lessons because it is in the separate apk file.
   **Browse Section** - This section is hardcoded. You can only view what this section could look like in the final version.
   **Profile Section** - The bottom part is also hardcoded. But in the middle, the toggle switch is interactable. You can also press the learn more button that will take you to another activity.
   
   **AR App** - The layout from the Discover Section is also present here. You can tap the images to load an AR sample. There is no back button so you need to restart the app to try out the other AR samples.

## Known Issues
1. When the menu button is opened and then closed. The fragment are unclickable. You can't scroll or tap the buttons. However you can still click the buttons above to change fragments.
2. In the navigation drawer menu, once you've clicked the Data Saver button. It would stay checked forever.
3. **This app was only tested on a device with 16:9 aspect ratio. There might be some UI design flaws when a phone with a tall aspect ratio is used.**
4. When tried in an Android Device with an API level of 22 (Lollipop 5.1). The intro video wouldn't load, some images are stretched, and eventually the app crashes. Because of this we set the minimum API level to 24(Nougat 7.0).

## Accessing Our Android Studio Project
  **Arkademi.apk** - To access our android studio project for this, go to the master branch and you will see the project there.
  
  **AR_kademi.apk** - Since Android Studio is taking a long time processing 3D models for adding to GitHub. We've decided to get the root folder containing all the Codes and UI elements. You can see it above named as **AR Kademi(AR Project).zip** Download it and unzip to access our project.
  
   ## ARCore Supported Devices:
  https://developers.google.com/ar/discover/supported-devices
