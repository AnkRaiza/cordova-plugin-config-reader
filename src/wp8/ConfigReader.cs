using System;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using Microsoft.Phone.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Media;
using Windows.Storage;
using System.Diagnostics;
using System.IO;

namespace WPCordovaClassLib.Cordova.Commands
{
    public class ConfigReader : BaseCommand
    {

        public async void get(string options)
        {
            string[] args = JSON.JsonHelper.Deserialize<string[]>(options);

            string preferenceName = args[0];

            try
            {
                // Get the pref.
                IsolatedStorageSettings appSettings = IsolatedStorageSettings.ApplicationSettings;
                string val = (string)appSettings[preferenceName];

                DispatchCommandResult(new PluginResult(PluginResult.Status.OK, val));
            }
            catch (Exception)
            {
                DispatchCommandResult(new PluginResult(PluginResult.Status.ERROR), "error");
            }
        }
    }
}
