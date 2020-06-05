package com.bixolonprnt;

import android.content.Context;
import android.graphics.Bitmap;

import com.bixolon.commonlib.BXLCommonConst;
import com.bixolon.commonlib.log.LogService;

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

public class BixolonPrinter {

    private Context context = null;
    private BXLConfigLoader bxlConfigLoader = null;
    private POSPrinter posPrinter = null;

    public BixolonPrinter(MethodCall call, Context context) throws Exception {
        this.context = context;

        String modelName = call.argument("modelName");
        posPrinter = new POSPrinter(this.context);
        posPrinter.open("SPP-R310");
        posPrinter.claim(3000);
        posPrinter.setDeviceEnabled(true);
        posPrinter.printNormal(POSPrinterConst.PTR_S_RECEIPT, "Hello World");
    }
}
