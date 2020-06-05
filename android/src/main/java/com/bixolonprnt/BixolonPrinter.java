package com.bixolonprnt;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;

import com.bixolon.commonlib.BXLCommonConst;
import com.bixolon.commonlib.log.LogService;
import com.bixolon.sample.CashDrawerFragment;
import com.bixolon.sample.DirectIOFragment;
import com.bixolon.sample.MainActivity;
import com.bixolon.sample.MsrFragment;
import com.bixolon.sample.PageModeFragment;
import com.bixolon.sample.TextFragment;
import com.bixolon.sample.ImageFragment;
import com.bixolon.sample.BarcodeFragment;

import java.nio.ByteBuffer;

import jpos.CashDrawer;
import jpos.JposConst;
import jpos.JposException;
import jpos.LocalSmartCardRW;
import jpos.MSR;
import jpos.MSRConst;
import jpos.POSPrinter;
import jpos.POSPrinterConst;
import jpos.SmartCardRW;
import jpos.SmartCardRWConst;
import jpos.config.JposEntry;
import jpos.events.DataEvent;
import jpos.events.DataListener;
import jpos.events.DirectIOEvent;
import jpos.events.DirectIOListener;
import jpos.events.ErrorEvent;
import jpos.events.ErrorListener;
import jpos.events.OutputCompleteEvent;
import jpos.events.OutputCompleteListener;
import jpos.events.StatusUpdateEvent;
import jpos.events.StatusUpdateListener;

import com.bxl.config.editor.BXLConfigLoader;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class BixolonPrinter implements ErrorListener, OutputCompleteListener, StatusUpdateListener, DirectIOListener, DataListener {

    private static Context context;

    public BixolonPrinter(Context context) {
        String modelName = call.argument("modelName");
        POSPrinter posPrinter = new POSPrinter(context);
        posPrinter.open(modelName);
        posPrinter.claim(3000);
        posPrinter.setDeviceEnabled(true);
        posPrinter.printNormal(POSPrinterConst.PTR_S_RECEIPT, "Hello World");
    }
}
