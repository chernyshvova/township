package com.playrix.engine;

import java.util.Iterator;
import java.util.UUID;
import java.util.Vector;

public class BlockingManager {
    public static Vector<UUID> mBlockers = new Vector<>();
    public static Vector<IBlockingSectionListener> mBlockingListeners = new Vector<>();
    public static boolean mIsBlocked = false;

    public interface IBlockingSectionListener {
        void onEnterBlockingSection();

        void onLeaveBlockingSection();
    }

    public static void addBlockingListener(IBlockingSectionListener iBlockingSectionListener) {
        if (!mBlockingListeners.contains(iBlockingSectionListener)) {
            mBlockingListeners.add(iBlockingSectionListener);
        }
    }

    public static UUID block() {
        UUID randomUUID = UUID.randomUUID();
        mBlockers.add(randomUUID);
        reevalState();
        return randomUUID;
    }

    public static void enterBlockingSection() {
        mIsBlocked = true;
        Iterator<IBlockingSectionListener> it = mBlockingListeners.iterator();
        while (it.hasNext()) {
            it.next().onEnterBlockingSection();
        }
    }

    public static boolean isBlocked() {
        return mIsBlocked;
    }

    public static void leaveBlockingSection() {
        mIsBlocked = false;
        Iterator<IBlockingSectionListener> it = mBlockingListeners.iterator();
        while (it.hasNext()) {
            it.next().onLeaveBlockingSection();
        }
    }

    public static void reevalState() {
        boolean z = mBlockers.size() > 0;
        boolean z2 = mIsBlocked;
        if (z2 == z) {
            return;
        }
        if (z2) {
            leaveBlockingSection();
        } else {
            enterBlockingSection();
        }
    }

    public static void removeBlockingListener(IBlockingSectionListener iBlockingSectionListener) {
        mBlockingListeners.remove(iBlockingSectionListener);
    }

    public static void unblock(UUID uuid) {
        if (mBlockers.contains(uuid)) {
            mBlockers.remove(uuid);
            reevalState();
        }
    }
}
