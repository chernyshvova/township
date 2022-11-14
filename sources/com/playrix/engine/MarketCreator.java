package com.playrix.engine;

import com.playrix.engine.EngineBilling;
import com.playrix.gplay.Billing;

public class MarketCreator {
    public static EngineBilling.IBilling create(String str) {
        return new Billing(str);
    }
}
