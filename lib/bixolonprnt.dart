import 'dart:async';

import 'package:flutter/services.dart';

class Bixolonprnt {
  static const MethodChannel _channel = const MethodChannel('bixolonprnt');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

//"SPP-R310"
  static Future<String> getSamplePrint(String modelName) async {
    final String result =
        await _channel.invokeMethod('getSamplePrint', modelName);
    return result;
  }
}
