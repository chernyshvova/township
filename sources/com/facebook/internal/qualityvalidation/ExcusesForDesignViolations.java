package com.facebook.internal.qualityvalidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: ExcusesForDesignViolations.kt */
public @interface ExcusesForDesignViolations {
    Excuse[] value();
}
