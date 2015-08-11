A config reader Plugin for Cordova
==========================
This plugin will get a configuration variable from the native application depending on the OS that you are on.

Requirements
-------------
- Android 4 or higher / iOS 6 or higher / WP8
- Cordova 3.0 or higher

Installation
-------------
    cordova plugin add https://github.com/AnkRaiza/cordova-plugin-config-reader
    
Usage
------
Android
insert your shared preferences to be read on the js side
	SharedPreferences SharedPref = this.getSharedPreferences("configStrings", Context.MODE_PRIVATE);
	SharedPreferences.Editor editor = SharedPref.edit();
	editor.putString("googleAnalyticsId", "XXXXXX");
	editor.putString("raygunId", "XXXXXX");
	editor.putString("llave", "XXXXXX");
	editor.putString("salt", "XXXXXX");
	editor.commit();
	
WP8
insert your IsolatedStorageSettings to be read on the js side
IsolatedStorageSettings appSettings = IsolatedStorageSettings.ApplicationSettings;
if (!appSettings.Contains("googleAnalyticsId"))
{
	appSettings.Add("googleAnalyticsId", "XXXXXX");
    appSettings.Add("raygunId", "XXXXXX");
    appSettings.Add("llave", "XXXXXX");
    appSettings.Add("salt", "XXXXXX");
    appSettings.Save();
}
IOS
insert you userpref to be read on the js side
NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
[defaults setObject:@"XXXXXX" forKey:@"googleAnalyticsId"];
[defaults setObject:@"XXXXXX" forKey:@"raygunId"];
[defaults setObject:@"XXXXXX" forKey:@"llave"];
[defaults setObject:@"XXXXXX" forKey:@"salt"];
[defaults synchronize];

LICENSE
--------
The MIT License (MIT)

Copyright (c) 2015 ankraiza - pier.castaneda@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
