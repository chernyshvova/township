package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
public class ViewUtilsApi21 extends ViewUtilsApi19 {
    public static final String TAG = "ViewUtilsApi21";
    public static Method sSetAnimationMatrixMethod;
    public static boolean sSetAnimationMatrixMethodFetched;
    public static Method sTransformMatrixToGlobalMethod;
    public static boolean sTransformMatrixToGlobalMethodFetched;
    public static Method sTransformMatrixToLocalMethod;
    public static boolean sTransformMatrixToLocalMethodFetched;

    private void fetchSetAnimationMatrix() {
        if (!sSetAnimationMatrixMethodFetched) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("setAnimationMatrix", new Class[]{Matrix.class});
                sSetAnimationMatrixMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i(TAG, "Failed to retrieve setAnimationMatrix method", e);
            }
            sSetAnimationMatrixMethodFetched = true;
        }
    }

    private void fetchTransformMatrixToGlobalMethod() {
        if (!sTransformMatrixToGlobalMethodFetched) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[]{Matrix.class});
                sTransformMatrixToGlobalMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i(TAG, "Failed to retrieve transformMatrixToGlobal method", e);
            }
            sTransformMatrixToGlobalMethodFetched = true;
        }
    }

    private void fetchTransformMatrixToLocalMethod() {
        if (!sTransformMatrixToLocalMethodFetched) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[]{Matrix.class});
                sTransformMatrixToLocalMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i(TAG, "Failed to retrieve transformMatrixToLocal method", e);
            }
            sTransformMatrixToLocalMethodFetched = true;
        }
    }

    public void setAnimationMatrix(@NonNull View view, Matrix matrix) {
        fetchSetAnimationMatrix();
        Method method = sSetAnimationMatrixMethod;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (InvocationTargetException unused) {
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    public void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        fetchTransformMatrixToGlobalMethod();
        Method method = sTransformMatrixToGlobalMethod;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    public void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        fetchTransformMatrixToLocalMethod();
        Method method = sTransformMatrixToLocalMethod;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }
}
