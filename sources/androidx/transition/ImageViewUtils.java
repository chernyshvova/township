package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ImageViewUtils {
    public static final String TAG = "ImageViewUtils";
    public static Method sAnimateTransformMethod;
    public static boolean sAnimateTransformMethodFetched;

    public static void animateTransform(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT < 21) {
            imageView.setImageMatrix(matrix);
            return;
        }
        fetchAnimateTransformMethod();
        Method method = sAnimateTransformMethod;
        if (method != null) {
            try {
                method.invoke(imageView, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    public static void fetchAnimateTransformMethod() {
        if (!sAnimateTransformMethodFetched) {
            try {
                Method declaredMethod = ImageView.class.getDeclaredMethod("animateTransform", new Class[]{Matrix.class});
                sAnimateTransformMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i(TAG, "Failed to retrieve animateTransform method", e);
            }
            sAnimateTransformMethodFetched = true;
        }
    }

    public static void reserveEndAnimateTransform(final ImageView imageView, Animator animator) {
        if (Build.VERSION.SDK_INT < 21) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    ImageView.ScaleType scaleType = (ImageView.ScaleType) imageView.getTag(C0509R.C0511id.save_scale_type);
                    imageView.setScaleType(scaleType);
                    imageView.setTag(C0509R.C0511id.save_scale_type, (Object) null);
                    if (scaleType == ImageView.ScaleType.MATRIX) {
                        ImageView imageView = imageView;
                        imageView.setImageMatrix((Matrix) imageView.getTag(C0509R.C0511id.save_image_matrix));
                        imageView.setTag(C0509R.C0511id.save_image_matrix, (Object) null);
                    }
                    animator.removeListener(this);
                }
            });
        }
    }

    public static void startAnimateTransform(ImageView imageView) {
        if (Build.VERSION.SDK_INT < 21) {
            ImageView.ScaleType scaleType = imageView.getScaleType();
            imageView.setTag(C0509R.C0511id.save_scale_type, scaleType);
            ImageView.ScaleType scaleType2 = ImageView.ScaleType.MATRIX;
            if (scaleType == scaleType2) {
                imageView.setTag(C0509R.C0511id.save_image_matrix, imageView.getImageMatrix());
            } else {
                imageView.setScaleType(scaleType2);
            }
            imageView.setImageMatrix(MatrixUtils.IDENTITY_MATRIX);
        }
    }
}
