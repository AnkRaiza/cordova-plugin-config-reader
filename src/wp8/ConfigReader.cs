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

            string aliasCurrentCommandCallbackId = args[2];

            try
            {
                // Get the file.
                StorageFile file = await Windows.Storage.StorageFile.GetFileFromPathAsync(args[0]);

                // Launch the bug query file.
                await Windows.System.Launcher.LaunchFileAsync(file);

                DispatchCommandResult(new PluginResult(PluginResult.Status.OK, "{result:\"data\"}"));
            }
            catch (Exception)
            {
                DispatchCommandResult(new PluginResult(PluginResult.Status.ERROR), aliasCurrentCommandCallbackId);
            }
        }
    }
}
