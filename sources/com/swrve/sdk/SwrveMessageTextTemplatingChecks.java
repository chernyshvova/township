package com.swrve.sdk;

import com.swrve.sdk.exceptions.SwrveSDKTextTemplatingException;
import com.swrve.sdk.messaging.SwrveActionType;
import com.swrve.sdk.messaging.SwrveButton;
import com.swrve.sdk.messaging.SwrveImage;
import com.swrve.sdk.messaging.SwrveMessage;
import com.swrve.sdk.messaging.SwrveMessageFormat;
import java.util.Iterator;
import java.util.Map;

public class SwrveMessageTextTemplatingChecks {
    public static boolean checkImageUrlTemplating(SwrveMessage swrveMessage, Map<String, String> map) {
        try {
            for (SwrveMessageFormat next : swrveMessage.getFormats()) {
                for (SwrveImage next2 : next.getImages()) {
                    String dynamicImageUrl = next2.getDynamicImageUrl();
                    if (SwrveHelper.isNotNullOrEmpty(dynamicImageUrl) && SwrveHelper.isNullOrEmpty(next2.getFile())) {
                        String apply = SwrveTextTemplating.apply(dynamicImageUrl, map);
                        if (SwrveHelper.isNullOrEmpty(apply)) {
                            SwrveLogger.m2755i(" Dynamic image url text template could not be resolved: " + dynamicImageUrl + " in given properties.", new Object[0]);
                            return false;
                        } else if (SwrveTextTemplating.hasPatternMatch(apply)) {
                            SwrveLogger.m2755i("Not showing personalized image / without personalization info provided.", new Object[0]);
                            return false;
                        }
                    }
                }
                Iterator<SwrveButton> it = next.getButtons().iterator();
                while (true) {
                    if (it.hasNext()) {
                        SwrveButton next3 = it.next();
                        String dynamicImageUrl2 = next3.getDynamicImageUrl();
                        if (SwrveHelper.isNotNullOrEmpty(dynamicImageUrl2) && SwrveHelper.isNullOrEmpty(next3.getImage())) {
                            String apply2 = SwrveTextTemplating.apply(dynamicImageUrl2, map);
                            if (SwrveHelper.isNullOrEmpty(apply2)) {
                                SwrveLogger.m2755i("Dynamic button image url text template could not be resolved: " + dynamicImageUrl2 + " in given properties.", new Object[0]);
                                return false;
                            } else if (SwrveTextTemplating.hasPatternMatch(apply2)) {
                                SwrveLogger.m2755i("Not showing personalized image / without personalization info provided.", new Object[0]);
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        } catch (SwrveSDKTextTemplatingException e) {
            SwrveLogger.m2753e("Not showing campaign, error with personalization", e, new Object[0]);
            return false;
        }
    }

    public static boolean checkTextTemplating(SwrveMessage swrveMessage, Map<String, String> map) {
        try {
            for (SwrveMessageFormat next : swrveMessage.getFormats()) {
                for (SwrveImage text : next.getImages()) {
                    String text2 = text.getText();
                    if (!SwrveHelper.isNullOrEmpty(text2)) {
                        String apply = SwrveTextTemplating.apply(text2, map);
                        if (SwrveHelper.isNullOrEmpty(apply)) {
                            SwrveLogger.m2755i("Text template could not be resolved: " + text2 + " in given properties.", new Object[0]);
                            return false;
                        } else if (SwrveTextTemplating.hasPatternMatch(apply)) {
                            SwrveLogger.m2755i("Not showing campaign with personalization outside of Message Center / without personalization info provided.", new Object[0]);
                            return false;
                        }
                    }
                }
                Iterator<SwrveButton> it = next.getButtons().iterator();
                while (true) {
                    if (it.hasNext()) {
                        SwrveButton next2 = it.next();
                        String text3 = next2.getText();
                        if (!SwrveHelper.isNullOrEmpty(text3)) {
                            String apply2 = SwrveTextTemplating.apply(text3, map);
                            if (SwrveHelper.isNullOrEmpty(apply2)) {
                                SwrveLogger.m2755i("Text template could not be resolved: " + text3 + " in given properties.", new Object[0]);
                                return false;
                            } else if (SwrveTextTemplating.hasPatternMatch(apply2)) {
                                SwrveLogger.m2755i("Not showing campaign with personalization outside of Message Center / without personalization info provided.", new Object[0]);
                                return false;
                            }
                        }
                        String action = next2.getAction();
                        if ((next2.getActionType() == SwrveActionType.Custom || next2.getActionType() == SwrveActionType.CopyToClipboard) && !SwrveHelper.isNullOrEmpty(action)) {
                            String apply3 = SwrveTextTemplating.apply(action, map);
                            if (SwrveHelper.isNullOrEmpty(apply3)) {
                                SwrveLogger.m2755i("Button action template could not be resolved: " + next2.getAction() + " in given properties.", new Object[0]);
                                return false;
                            } else if (SwrveTextTemplating.hasPatternMatch(apply3)) {
                                SwrveLogger.m2755i("Not showing campaign with personalization outside of Message Center / without personalization info provided.", new Object[0]);
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        } catch (SwrveSDKTextTemplatingException e) {
            SwrveLogger.m2753e("Not showing campaign, error with personalization", e, new Object[0]);
            return false;
        }
    }
}
