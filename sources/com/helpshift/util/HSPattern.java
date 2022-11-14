package com.helpshift.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HSPattern {
    public static final int EMAIL_LIMIT = 256;
    public static final int IDENTIFIER_LIMIT = 750;
    public static Pattern customPropertyPattern;
    public static Pattern domainNamePattern;
    public static Pattern emailPattern;
    public static Pattern ipPattern;
    public static Pattern mimePattern;
    public static Pattern namePattern;
    public static Pattern positiveNumbersPattern;
    public static Pattern propertyKeyPattern;
    public static Pattern specialCharPattern;
    public static Pattern timeStampPattern;
    public static Pattern urlPattern;

    public static boolean checkIpv4Address(String str) {
        if (ipPattern == null) {
            ipPattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");
        }
        if (!(str == null || str.trim().length() == 0)) {
            Matcher matcher = ipPattern.matcher(str.trim());
            if (matcher.matches()) {
                for (int i = 1; i < matcher.groupCount(); i++) {
                    Integer valueOf = Integer.valueOf(Integer.parseInt(matcher.group(i)));
                    if (valueOf.intValue() < 0 || valueOf.intValue() > 255) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static Pattern getComponentPlaceHolderPattern(String str) {
        return Pattern.compile("^[\\p{L}\\p{N}-]+_" + str + "_\\d{17}-[0-9a-z]{15}$");
    }

    public static Pattern getEmailPattern() {
        if (emailPattern == null) {
            emailPattern = Pattern.compile("(?i)^[\\p{L}\\p{N}\\p{M}\\p{S}\\p{Po}A-Z0-9._%'-]{1,64}(\\+.*)?@[\\p{L}\\p{M}\\p{N}\\p{S}A-Z0-9'.-]{1,246}\\.[\\p{L}\\p{M}\\p{N}\\p{S}A-Z]{2,8}[^\\s]*$");
        }
        return emailPattern;
    }

    public static Pattern getMimePattern() {
        if (mimePattern == null) {
            mimePattern = Pattern.compile("^.*[a-zA-Z]+.*/.*[a-zA-Z]+.*$");
        }
        return mimePattern;
    }

    public static Pattern getPositiveNumbersPattern() {
        if (positiveNumbersPattern == null) {
            positiveNumbersPattern = Pattern.compile("^[+]?\\p{N}+(\\.\\p{N}+)?$");
        }
        return positiveNumbersPattern;
    }

    public static Pattern getPropertyKeyPattern() {
        if (propertyKeyPattern == null) {
            propertyKeyPattern = Pattern.compile("^[\\p{L}\\p{N}][\\p{L}\\p{N}\\p{Pd}\\p{Pc}]*[\\p{L}\\p{N}]$");
        }
        return propertyKeyPattern;
    }

    public static Pattern getTimeStampPattern() {
        if (timeStampPattern == null) {
            timeStampPattern = Pattern.compile("^\\d+.\\d{3}$");
        }
        return timeStampPattern;
    }

    public static Pattern getUrlPattern() {
        if (urlPattern == null) {
            urlPattern = Pattern.compile("[^\\p{Z}\\n\\p{Ps}]+://[^\\p{Z}\\n\\p{Pe}.]+(\\.[^\\p{Z}\\n\\p{Pe}.]+)*");
        }
        return urlPattern;
    }

    public static boolean hasOnlySpecialCharacters(String str) {
        if (specialCharPattern == null) {
            specialCharPattern = Pattern.compile("\\W+");
        }
        return specialCharPattern.matcher(str.trim()).matches();
    }

    public static boolean isPositiveNumber(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return getPositiveNumbersPattern().matcher(str).matches();
    }

    public static boolean isValidEmail(String str) {
        if (str == null) {
            return false;
        }
        return getEmailPattern().matcher(str.trim()).matches();
    }

    public static boolean isValidLoginEmail(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        if (str.length() == str.trim().length() && str.length() <= 256) {
            return getEmailPattern().matcher(str).matches();
        }
        return false;
    }

    public static boolean isValidLoginIdentifier(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        if (str.length() == str.trim().length() && str.length() <= 750) {
            return true;
        }
        return false;
    }

    public static boolean isValidMime(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return getMimePattern().matcher(str.trim()).matches();
    }

    public static boolean isValidName(String str) {
        if (namePattern == null) {
            namePattern = Pattern.compile("^[\\p{L}\\p{M}\\p{N}].*");
        }
        return namePattern.matcher(str.trim()).matches();
    }

    public static String sanitiseCustomPropertyKey(String str) {
        if (customPropertyPattern == null) {
            customPropertyPattern = Pattern.compile("^[A-Za-z0-9_]+$");
        }
        String replace = str.trim().replace("-", "_").replace(" ", "_");
        if (!customPropertyPattern.matcher(replace).matches()) {
            return null;
        }
        return replace;
    }
}
