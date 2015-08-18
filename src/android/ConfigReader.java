/*
The MIT License (MIT)
Copyright (c) 2013 pwlin - pwlin05@gmail.com
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
*/
package io.github.pwlin.cordova.plugins.configreader;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
//import android.util.Log;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaResourceApi;

public class ConfigReader extends CordovaPlugin {

	/**
	 * Executes the request and returns a boolean.
	 * 
	 * @param action
	 *            The action to execute.
	 * @param args
	 *            JSONArry of arguments for the plugin.
	 * @param callbackContext
	 *            The callback context used when calling back into JavaScript.
	 * @return boolean.
	 */
	SharedPreferences SharedPref;
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("get")) {
			this._get(args.getString(0), callbackContext);
		}
		else {
			JSONObject errorObj = new JSONObject();
			errorObj.put("status", PluginResult.Status.INVALID_ACTION.ordinal());
			errorObj.put("message", "Invalid action");
			callbackContext.error(errorObj);
		}
		return true;
	}

	private void _get(String PreferenceName, CallbackContext callbackContext) throws JSONException {
		String KeyVal;
		Context context = cordova.getActivity();
		SharedPref = context.getSharedPreferences("configStrings", Context.MODE_PRIVATE);
		if(!SharedPref.contains(PreferenceName)){
			SharedPreferences.Editor editor = SharedPref.edit();
			editor.putString("googleAnalyticsId", "Y2bIJ376+2iNg4wlmYlyLAgI64J0QgjaofaOP1JNTY8=");
			editor.putString("raygunId", "2z3Tj0FuQwsqyt1RahR5xogLA1vGeL7IwMdv+6Pxoj9jOFPCpdKD69HlRUc6U4Jg");
			editor.putString("llave", "0123456789abcdef");
			editor.putString("salt", "fedcba9876543210");
			editor.commit();
		}
		
		try{				
			if(SharedPref.contains(PreferenceName)){
				KeyVal = SharedPref.getString(PreferenceName, "nada");
				callbackContext.success(KeyVal);
			}else{
				callbackContext.error("No data");
			}
		}catch (Exception e){
			callbackContext.error("Could Not Retreive " + PreferenceName + e);
		}
	}
	
}
