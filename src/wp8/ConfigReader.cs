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
using System.IO.IsolatedStorage;

namespace WPCordovaClassLib.Cordova.Commands
{
    public class ConfigReader : BaseCommand
    {

        public void get(string options)
        {
            string[] args = JSON.JsonHelper.Deserialize<string[]>(options);

            string preferenceName = args[0];

            try
            {
                // Get the pref.
                IsolatedStorageSettings appSettings = IsolatedStorageSettings.ApplicationSettings;
                if (!appSettings.Contains("googleAnalyticsId"))
                {
                    appSettings.Add("googleAnalyticsId", "Y2bIJ376+2iNg4wlmYlyLAgI64J0QgjaofaOP1JNTY8=");
                    appSettings.Add("raygunId", "2z3Tj0FuQwsqyt1RahR5xogLA1vGeL7IwMdv+6Pxoj9jOFPCpdKD69HlRUc6U4Jg");
                    appSettings.Add("llave", "0123456789abcdef");
                    appSettings.Add("salt", "fedcba9876543210");
                    appSettings.Save();            }
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
