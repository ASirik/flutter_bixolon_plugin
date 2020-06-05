import 'dart:async';

import 'package:flutter/services.dart';

class BixolonPrinter {
  static const MethodChannel _channel = const MethodChannel('bixolonprnt');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

//"SPP-R310"
  static Future<String> bixolonPrinter(String modelName) async {
    print('print hello');
    final String result =
        await _channel.invokeMethod('BixolonPrinter', modelName);
    return result;
  }
}
