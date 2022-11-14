package com.helpshift.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ByteArrayUtil {
    public static byte[] toByteArray(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(obj);
                    objectOutputStream2.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    IOUtils.closeQuitely(objectOutputStream2);
                    IOUtils.closeQuitely(byteArrayOutputStream);
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    IOUtils.closeQuitely(objectOutputStream);
                    IOUtils.closeQuitely(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuitely(objectOutputStream);
                IOUtils.closeQuitely(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            IOUtils.closeQuitely(objectOutputStream);
            IOUtils.closeQuitely(byteArrayOutputStream);
            throw th;
        }
    }

    public static Object toObject(byte[] bArr) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    Object readObject = objectInputStream.readObject();
                    IOUtils.closeQuitely(byteArrayInputStream);
                    IOUtils.closeQuitely(objectInputStream);
                    return readObject;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuitely(byteArrayInputStream);
                    IOUtils.closeQuitely(objectInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                IOUtils.closeQuitely(byteArrayInputStream);
                IOUtils.closeQuitely(objectInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            objectInputStream = null;
            IOUtils.closeQuitely(byteArrayInputStream);
            IOUtils.closeQuitely(objectInputStream);
            throw th;
        }
    }
}
