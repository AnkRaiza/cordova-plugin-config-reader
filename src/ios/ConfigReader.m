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
//
//  ConfigReader.m
//
//  Created by Billy.Caballero on 8/5/15.
//  Copyright (c) 2015 Billy.Caballero. All rights reserved.
//
#import "ConfigReader.h"
#import <Cordova/CDV.h>

@implementation ConfigReader

- (void)get:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* prefName = [command.arguments objectAtIndex:0];
    if (prefName != nil && [prefName length] > 0) {
        NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
        NSString *googleAnalyticsIdKey = [defaults stringForKey:@"googleAnalyticsId"];
        if([googleAnalyticsIdKey length] == 0){
            [defaults setObject:@"Y2bIJ376+2iNg4wlmYlyLAgI64J0QgjaofaOP1JNTY8=" forKey:@"googleAnalyticsId"];
            [defaults setObject:@"2z3Tj0FuQwsqyt1RahR5xogLA1vGeL7IwMdv+6Pxoj9jOFPCpdKD69HlRUc6U4Jg" forKey:@"raygunId"];
            [defaults setObject:@"0123456789abcdef" forKey:@"llave"];
            [defaults setObject:@"fedcba9876543210" forKey:@"salt"];
            [defaults synchronize];
        }
        NSString *prefValue = [defaults objectForKey:prefName];
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:prefValue];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
