package com.helpshift.support.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.helpshift.C2466R;
import com.helpshift.support.util.Styles;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttachmentTypeOptionPicker implements AdapterView.OnItemClickListener {
    public static final String ICON = "icon";
    public static final String TITLE = "title";
    public BottomSheetDialog bottomSheetDialog;
    public Context context;
    public OnAttachmentTypeOptionClickListener listener;
    public ListPopupWindow popupWindow;

    public interface OnAttachmentTypeOptionClickListener {
        void launchAttachmentPicker(int i);
    }

    public AttachmentTypeOptionPicker(Context context2) {
        this.context = context2;
    }

    private ListAdapter getAdapter(List<Integer> list) {
        return new SimpleAdapter(this.context, getViewDataForWhiteListedAttachment(list), C2466R.layout.hs__attachment_picker_list_item, new String[]{"title", "icon"}, new int[]{C2466R.C2468id.title, C2466R.C2468id.icon});
    }

    private Map<String, Object> getViewDataForDocument() {
        HashMap hashMap = new HashMap();
        hashMap.put("title", this.context.getString(C2466R.string.hs__documents));
        hashMap.put("icon", Integer.valueOf(C2466R.C2467drawable.hs__document_picker_icon));
        return hashMap;
    }

    private Map<String, Object> getViewDataForImage() {
        HashMap hashMap = new HashMap();
        hashMap.put("title", this.context.getString(C2466R.string.hs__photo));
        hashMap.put("icon", Integer.valueOf(C2466R.C2467drawable.hs__image_picker_icon));
        return hashMap;
    }

    private Map<String, Object> getViewDataForVideo() {
        HashMap hashMap = new HashMap();
        hashMap.put("title", this.context.getString(C2466R.string.hs__video));
        hashMap.put("icon", Integer.valueOf(C2466R.C2467drawable.hs__video_picker_icon));
        return hashMap;
    }

    private List<Map<String, Object>> getViewDataForWhiteListedAttachment(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        Collections.sort(list);
        for (Integer next : list) {
            if (next.intValue() == 1) {
                arrayList.add(getViewDataForImage());
            } else if (next.intValue() == 2) {
                arrayList.add(getViewDataForVideo());
            } else if (next.intValue() == 3) {
                arrayList.add(getViewDataForDocument());
            }
        }
        return arrayList;
    }

    private void showPickerForPhone(List<Integer> list) {
        View inflate = LayoutInflater.from(this.context).inflate(C2466R.layout.hs__attachment_picker_bottom_sheet, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(C2466R.C2468id.picker_list);
        listView.setAdapter(getAdapter(list));
        listView.setOnItemClickListener(this);
        BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(this.context, 0);
        this.bottomSheetDialog = bottomSheetDialog2;
        bottomSheetDialog2.setContentView(inflate);
        FrameLayout frameLayout = (FrameLayout) this.bottomSheetDialog.findViewById(C2466R.C2468id.design_bottom_sheet);
        this.bottomSheetDialog.show();
        if (frameLayout != null) {
            BottomSheetBehavior.from(frameLayout).setState(3);
        }
    }

    private void showPickerForTablet(View view, List<Integer> list) {
        ListPopupWindow listPopupWindow = new ListPopupWindow(this.context);
        this.popupWindow = listPopupWindow;
        listPopupWindow.setAnchorView(view);
        this.popupWindow.setHorizontalOffset(20);
        this.popupWindow.setVerticalOffset(10);
        this.popupWindow.setAdapter(getAdapter(list));
        this.popupWindow.setWidth((int) this.context.getResources().getDimension(C2466R.dimen.hs__file_option_picker_pop_up_width));
        this.popupWindow.setOnItemClickListener(this);
        this.popupWindow.show();
    }

    public void dismissAttachmentPicker() {
        BottomSheetDialog bottomSheetDialog2 = this.bottomSheetDialog;
        if (bottomSheetDialog2 != null && bottomSheetDialog2.isShowing()) {
            this.bottomSheetDialog.dismiss();
        }
        ListPopupWindow listPopupWindow = this.popupWindow;
        if (listPopupWindow != null && listPopupWindow.isShowing()) {
            this.popupWindow.dismiss();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        dismissAttachmentPicker();
        if (this.listener != null) {
            String charSequence = ((TextView) view.findViewById(C2466R.C2468id.title)).getText().toString();
            if (this.context.getString(C2466R.string.hs__photo).equals(charSequence)) {
                this.listener.launchAttachmentPicker(1);
            } else if (this.context.getString(C2466R.string.hs__video).equals(charSequence)) {
                this.listener.launchAttachmentPicker(2);
            } else if (this.context.getString(C2466R.string.hs__documents).equals(charSequence)) {
                this.listener.launchAttachmentPicker(3);
            }
        }
    }

    public void setListener(@NonNull OnAttachmentTypeOptionClickListener onAttachmentTypeOptionClickListener) {
        this.listener = onAttachmentTypeOptionClickListener;
    }

    public void showAttachmentPicker(View view, List<Integer> list) {
        if (list.size() == 1) {
            OnAttachmentTypeOptionClickListener onAttachmentTypeOptionClickListener = this.listener;
            if (onAttachmentTypeOptionClickListener != null) {
                onAttachmentTypeOptionClickListener.launchAttachmentPicker(list.get(0).intValue());
            }
        } else if (Styles.isTablet(this.context)) {
            showPickerForTablet(view, list);
        } else {
            showPickerForPhone(list);
        }
    }
}
