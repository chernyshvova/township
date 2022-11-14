package okhttp3.internal.http2;

import androidx.core.internal.view.SupportMenu;

public final class Settings {
    public int set;
    public final int[] values = new int[10];

    public int getInitialWindowSize() {
        return (this.set & 128) != 0 ? this.values[7] : SupportMenu.USER_MASK;
    }

    public Settings set(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.values;
            if (i < iArr.length) {
                this.set = (1 << i) | this.set;
                iArr[i] = i2;
            }
        }
        return this;
    }
}
