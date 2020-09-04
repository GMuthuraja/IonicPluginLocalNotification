# IonicPluginLocalNotification 

# cordova-plugin-estaff-localnotification


## Installation
    ionic cordova plugin add cordova-plugin-estaff-localnotification (or)
    ionic cordova plugin add https://github.com/GMuthuraja/IonicPluginLocalNotification.git

## Supported Platforms
- Android

### How to Use
```
declare var LocalNotification: any; //paste it below the import section

let options = {
  "title": 'Title goes here',
  "message": 'Message goes here',
};

//Display local notification
LocalNotification.invoke(options, (res) => {
  console.log(res);
}, (err) => {
  console.log(err);
});
```