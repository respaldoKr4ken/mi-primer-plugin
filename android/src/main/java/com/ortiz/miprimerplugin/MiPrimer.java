package com.ortiz.miprimerplugin;

import com.getcapacitor.Logger;

public class MiPrimer {

    public String echo(String value) {
        Logger.info("Echo", value);
        return value;
    }
}
