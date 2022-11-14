package com.google.gson.internal;

import java.io.IOException;
import java.io.Writer;

public final class Streams$AppendableWriter extends Writer {
    public final Appendable appendable;
    public final CurrentWrite currentWrite = new CurrentWrite();

    public static class CurrentWrite implements CharSequence {
        public char[] chars;

        public char charAt(int i) {
            return this.chars[i];
        }

        public int length() {
            return this.chars.length;
        }

        public CharSequence subSequence(int i, int i2) {
            return new String(this.chars, i, i2 - i);
        }
    }

    public Streams$AppendableWriter(Appendable appendable2) {
        this.appendable = appendable2;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        CurrentWrite currentWrite2 = this.currentWrite;
        currentWrite2.chars = cArr;
        this.appendable.append(currentWrite2, i, i2 + i);
    }

    public void write(int i) throws IOException {
        this.appendable.append((char) i);
    }
}
