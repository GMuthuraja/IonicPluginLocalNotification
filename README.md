# IonicPluginLocalNotification 

---
title: Ionic Local Notification 
description: Display local notification
---

# cordova-plugin-estaff-localnotification


## Installation
    ionic cordova plugin add cordova-plugin-estaff-localnotification (or)
    ionic cordova plugin add https://github.com/GMuthuraja/IonicPluginLocalNotification.git

## Supported Platforms
- Android

### How to Use
```
declare var LocalNotification: any; //paste it below the import section

//button onclick function 
openCam() { 
LocalNotification.showNotification("", (response) => {
      console.log(response); //captured image file path
    }, (error => {
      console.log(error);
})
}
```