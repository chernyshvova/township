package com.helpshift.support.fragments;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.helpshift.C2466R;
import com.helpshift.CoreApi;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.support.ContactUsFilter;
import com.helpshift.support.HSSearch;
import com.helpshift.support.activities.ParentActivity;
import com.helpshift.support.compositions.FaqFragment;
import com.helpshift.support.compositions.SectionPagerFragment;
import com.helpshift.support.contracts.SupportScreenView;
import com.helpshift.support.controllers.FaqFlowController;
import com.helpshift.support.controllers.SupportController;
import com.helpshift.support.conversations.AuthenticationFailureFragment;
import com.helpshift.support.conversations.BaseConversationFragment;
import com.helpshift.support.conversations.ConversationalFragment;
import com.helpshift.support.conversations.NewConversationFragment;
import com.helpshift.support.conversations.messages.AvatarImageLoader;
import com.helpshift.support.conversations.usersetup.ConversationSetupFragment;
import com.helpshift.support.fragments.AttachmentPreviewFragment;
import com.helpshift.support.util.FragmentUtil;
import com.helpshift.support.util.SnackbarUtil;
import com.helpshift.support.widget.AttachmentPicker;
import com.helpshift.util.FetchDataFromThread;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.LocaleContextUtil;
import com.helpshift.util.StringUtils;
import com.helpshift.util.Styles;
import com.helpshift.views.CircleImageView;
import com.helpshift.views.HSMenuItemCompat;
import com.helpshift.views.HSTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SupportFragment extends MainFragment implements View.OnClickListener, SupportScreenView, FetchDataFromThread<Integer, Integer>, AttachmentPicker.AttachmentPickerListener, MenuItem.OnMenuItemClickListener, IToolbarMenuItemRenderer {
    public static final String SUPPORT_MODE = "support_mode";
    public static final String TAG = "Helpshift_SupportFrag";
    public MenuItem attachImageMenuItem;
    public FrameLayout bottomSheetContainer;
    public MenuItem contactUsMenuItem;
    public MenuItem doneMenuItem;
    public int embeddedToolbarId;
    public Toolbar embeddedToolbarView;
    public int embeddedToolbarViewImportanceForAccessibility;
    public boolean faqLoaded;
    public List<Integer> fragmentMenuItems;
    public boolean handleNewIntent;
    public Toolbar hsToolbarView;
    public AttachmentPicker imagePicker;
    public boolean isEmbedded;
    public boolean isForeground;
    public boolean isNoOpMode;
    public WeakReference<IMenuItemEventListener> menuItemEventListener;
    public boolean menuItemsPrepared;
    public Bundle newIntentData;
    public int newMessageCount = 0;
    public MenuItem searchMenuItem;
    public SearchView searchView;
    public MenuItem startNewConversationMenuItem;
    public SupportController supportController;
    public LinearLayout supportUIContainer;
    public View viewFaqsLoadError;
    public View viewFaqsLoading;
    public View viewNoFaqs;
    public final List<String> visibleFragments = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.helpshift.support.fragments.SupportFragment$3 */
    public static /* synthetic */ class C28093 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$support$fragments$HSMenuItemType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.helpshift.support.fragments.HSMenuItemType[] r0 = com.helpshift.support.fragments.HSMenuItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$support$fragments$HSMenuItemType = r0
                r1 = 1
                com.helpshift.support.fragments.HSMenuItemType r2 = com.helpshift.support.fragments.HSMenuItemType.START_NEW_CONVERSATION     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$helpshift$support$fragments$HSMenuItemType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.support.fragments.HSMenuItemType r2 = com.helpshift.support.fragments.HSMenuItemType.SCREENSHOT_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.fragments.SupportFragment.C28093.<clinit>():void");
        }
    }

    public static class SupportModes {
        public static final int CONVERSATION = 1;
        public static final int DYNAMIC_FORM = 4;
        public static final int FAQ_SECTION = 2;
        public static final int SINGLE_QUESTION = 3;
    }

    private void animateViewBottomMarginChange(final View view, final int i, int i2) {
        C28082 r0 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                layoutParams.bottomMargin = (int) (((float) i) * f);
                SupportFragment.this.supportUIContainer.setLayoutParams(layoutParams);
            }
        };
        r0.setDuration((long) i2);
        this.supportUIContainer.startAnimation(r0);
    }

    private void attachMenuListeners(Menu menu) {
        MenuItem findItem = menu.findItem(C2466R.C2468id.hs__search);
        this.searchMenuItem = findItem;
        this.searchView = (SearchView) HSMenuItemCompat.getActionView(findItem);
        MenuItem findItem2 = menu.findItem(C2466R.C2468id.hs__contact_us);
        this.contactUsMenuItem = findItem2;
        findItem2.setTitle(C2466R.string.hs__contact_us_btn);
        this.contactUsMenuItem.setOnMenuItemClickListener(this);
        HSMenuItemCompat.getActionView(this.contactUsMenuItem).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SupportFragment supportFragment = SupportFragment.this;
                supportFragment.onMenuItemClick(supportFragment.contactUsMenuItem);
            }
        });
        MenuItem findItem3 = menu.findItem(C2466R.C2468id.hs__action_done);
        this.doneMenuItem = findItem3;
        findItem3.setOnMenuItemClickListener(this);
        MenuItem findItem4 = menu.findItem(C2466R.C2468id.hs__start_new_conversation);
        this.startNewConversationMenuItem = findItem4;
        findItem4.setOnMenuItemClickListener(this);
        MenuItem findItem5 = menu.findItem(C2466R.C2468id.hs__attach_screenshot);
        this.attachImageMenuItem = findItem5;
        findItem5.setOnMenuItemClickListener(this);
        this.menuItemsPrepared = true;
        setSearchListeners((FaqFlowController) null);
        refreshMenu();
    }

    private Toolbar findToolbarViewInViewHierarchy(int i) {
        Toolbar toolbar;
        if (i == 0) {
            return null;
        }
        Toolbar toolbar2 = (Toolbar) getActivity(this).findViewById(i);
        if (toolbar2 != null) {
            return toolbar2;
        }
        Fragment parentFragment = getParentFragment();
        int i2 = 5;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0 || parentFragment == null) {
                return null;
            }
            View view = parentFragment.getView();
            if (view != null && (toolbar = (Toolbar) view.findViewById(i)) != null) {
                return toolbar;
            }
            parentFragment = parentFragment.getParentFragment();
            i2 = i3;
        }
        return null;
    }

    private ActionBar getHSActivityActionBar() {
        ParentActivity hSSupportActivity = getHSSupportActivity();
        if (hSSupportActivity != null) {
            return hSSupportActivity.getSupportActionBar();
        }
        return null;
    }

    private ParentActivity getHSSupportActivity() {
        FragmentActivity activity = getActivity();
        if (activity instanceof ParentActivity) {
            return (ParentActivity) activity;
        }
        return null;
    }

    private String getHeaderTitle() {
        SDKConfigurationDM sDKConfigurationDM = HelpshiftContext.getCoreApi().getSDKConfigurationDM();
        return StringUtils.isEmpty(sDKConfigurationDM.getCustomHeaderTitle()) ? getResources().getString(C2466R.string.hs__conversation_header) : sDKConfigurationDM.getCustomHeaderTitle();
    }

    private synchronized AttachmentPicker getImagePicker() {
        if (this.imagePicker == null) {
            this.imagePicker = new AttachmentPicker(HelpshiftContext.getApplicationContext(), HelpshiftContext.getPlatform().getDevice(), this, HelpshiftContext.getCoreApi().getSDKConfigurationDM());
        }
        return this.imagePicker;
    }

    private int getMenuResourceId() {
        return C2466R.C2470menu.hs__support_fragment;
    }

    private void hideAllMenuItems() {
        this.searchMenuItem.setVisible(false);
        this.contactUsMenuItem.setVisible(false);
        this.doneMenuItem.setVisible(false);
        this.startNewConversationMenuItem.setVisible(false);
        this.attachImageMenuItem.setVisible(false);
    }

    private boolean isConversationFragmentVisible() {
        ConversationalFragment conversationalFragment = (ConversationalFragment) this.supportController.getFragmentManager().findFragmentByTag(ConversationalFragment.FRAGMENT_TAG);
        if (conversationalFragment != null) {
            return conversationalFragment.isResumed();
        }
        return false;
    }

    public static SupportFragment newInstance(Bundle bundle) {
        SupportFragment supportFragment = new SupportFragment();
        supportFragment.setArguments(bundle);
        return supportFragment;
    }

    private void quitSupportFragment() {
        Activity activity = getActivity(this);
        if (activity instanceof ParentActivity) {
            activity.finish();
        } else {
            ((AppCompatActivity) activity).getSupportFragmentManager().beginTransaction().remove(this).commit();
        }
    }

    private void restoreConversationFragmentMenu() {
        setRetainSearchFragmentState(true);
        setSearchMenuVisible(false);
        setContactUsMenuVisible(false);
        BaseConversationFragment baseConversationFragment = (BaseConversationFragment) getRetainedChildFragmentManager().findFragmentByTag(NewConversationFragment.FRAGMENT_TAG);
        if (baseConversationFragment == null) {
            baseConversationFragment = (BaseConversationFragment) getRetainedChildFragmentManager().findFragmentByTag(ConversationalFragment.FRAGMENT_TAG);
        }
        if (baseConversationFragment != null) {
            this.doneMenuItem.setVisible(false);
        }
    }

    private void restoreSearchMenuItem() {
        SearchFragment searchFragment;
        FaqFlowFragment faqFlowFragment = FragmentUtil.getFaqFlowFragment(getRetainedChildFragmentManager());
        if (!(faqFlowFragment == null || (searchFragment = FragmentUtil.getSearchFragment(faqFlowFragment.getRetainedChildFragmentManager())) == null)) {
            setSearchMenuQuery(searchFragment.getCurrentQuery());
        }
        setContactUsMenuVisible(ContactUsFilter.showContactUs(ContactUsFilter.LOCATION.ACTION_BAR));
        setRetainSearchFragmentState(false);
    }

    private void restoreSingleQuestionDoneModeFragmentMenu() {
        this.doneMenuItem.setVisible(true);
    }

    private void sendMenuEventClickEvent(HSMenuItemType hSMenuItemType) {
        WeakReference<IMenuItemEventListener> weakReference = this.menuItemEventListener;
        if (weakReference != null && weakReference.get() != null) {
            ((IMenuItemEventListener) this.menuItemEventListener.get()).onMenuItemClicked(hSMenuItemType);
        }
    }

    private void setMenuItemColors() {
        Context context = getContext();
        Styles.setActionButtonIconColor(context, this.searchMenuItem.getIcon());
        Styles.setActionButtonIconColor(context, this.contactUsMenuItem.getIcon());
        Styles.setActionButtonIconColor(context, ((TextView) HSMenuItemCompat.getActionView(this.contactUsMenuItem).findViewById(C2466R.C2468id.hs__notification_badge)).getBackground());
        Styles.setActionButtonIconColor(context, this.doneMenuItem.getIcon());
        Styles.setActionButtonIconColor(context, this.startNewConversationMenuItem.getIcon());
        Styles.setActionButtonIconColor(context, this.attachImageMenuItem.getIcon());
    }

    private void setRetainSearchFragmentState(boolean z) {
        FaqFlowFragment faqFlowFragment = (FaqFlowFragment) getRetainedChildFragmentManager().findFragmentByTag(FaqFlowFragment.FRAGMENT_TAG);
        if (faqFlowFragment != null && faqFlowFragment.getFaqFlowController() != null) {
            faqFlowFragment.getFaqFlowController().setRetainSearchFragmentState(z);
        }
    }

    private void setupEmbeddedToolbarView() {
        int i;
        if (this.isEmbedded && (i = this.embeddedToolbarId) != 0) {
            Toolbar findToolbarViewInViewHierarchy = findToolbarViewInViewHierarchy(i);
            this.embeddedToolbarView = findToolbarViewInViewHierarchy;
            if (findToolbarViewInViewHierarchy == null) {
                HSLogger.m3241e(TAG, "Unable to retrieve toolbarView from dev provided toolbarId via ApiConfig");
                return;
            }
            Menu menu = findToolbarViewInViewHierarchy.getMenu();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < menu.size(); i2++) {
                arrayList.add(Integer.valueOf(menu.getItem(i2).getItemId()));
            }
            this.embeddedToolbarView.inflateMenu(getMenuResourceId());
            attachMenuListeners(this.embeddedToolbarView.getMenu());
            Menu menu2 = this.embeddedToolbarView.getMenu();
            this.fragmentMenuItems = new ArrayList();
            for (int i3 = 0; i3 < menu2.size(); i3++) {
                int itemId = menu2.getItem(i3).getItemId();
                if (!arrayList.contains(Integer.valueOf(itemId))) {
                    this.fragmentMenuItems.add(Integer.valueOf(itemId));
                }
            }
        }
    }

    private void setupHSToolbarView(View view) {
        if (!this.isEmbedded) {
            Toolbar toolbar = (Toolbar) view.findViewById(C2466R.C2468id.hs__toolbar);
            this.hsToolbarView = toolbar;
            toolbar.setVisibility(0);
            ParentActivity hSSupportActivity = getHSSupportActivity();
            if (hSSupportActivity != null) {
                hSSupportActivity.setSupportActionBar(this.hsToolbarView);
                ActionBar supportActionBar = hSSupportActivity.getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setDisplayHomeAsUpEnabled(true);
                }
            }
        }
    }

    private void showDynamicFormFragmentMenu() {
        setRetainSearchFragmentState(true);
        setContactUsMenuVisible(false);
        setSearchMenuVisible(false);
    }

    private void showFaqFragmentMenu() {
        setSearchMenuVisible(this.faqLoaded);
        setContactUsMenuVisible(ContactUsFilter.showContactUs(ContactUsFilter.LOCATION.ACTION_BAR));
    }

    private void showQuestionListFragmentMenu() {
        setSearchMenuVisible(this.faqLoaded);
        setContactUsMenuVisible(ContactUsFilter.showContactUs(ContactUsFilter.LOCATION.ACTION_BAR));
    }

    private void showSectionPagerFragmentMenu() {
        setSearchMenuVisible(true);
        setContactUsMenuVisible(ContactUsFilter.showContactUs(ContactUsFilter.LOCATION.ACTION_BAR));
    }

    private void showSingleQuestionFragmentMenu() {
        if (!isScreenLarge()) {
            setRetainSearchFragmentState(true);
            setSearchMenuVisible(false);
        }
        setContactUsMenuVisible(ContactUsFilter.showContactUs(ContactUsFilter.LOCATION.QUESTION_ACTION_BAR));
    }

    @TargetApi(21)
    private void showToolbarElevationLollipop(boolean z) {
        float dpToPx = z ? Styles.dpToPx(getContext(), 4.0f) : 0.0f;
        if (this.isEmbedded) {
            Toolbar toolbar = this.embeddedToolbarView;
            if (toolbar != null) {
                toolbar.setElevation(dpToPx);
                return;
            }
            return;
        }
        ActionBar hSActivityActionBar = getHSActivityActionBar();
        if (hSActivityActionBar != null) {
            hSActivityActionBar.setElevation(dpToPx);
        }
    }

    private void showToolbarElevationPreLollipop(boolean z) {
        FrameLayout frameLayout = (FrameLayout) getActivity(this).findViewById(C2466R.C2468id.flow_fragment_container);
        if (frameLayout == null) {
            return;
        }
        if (z) {
            frameLayout.setForeground(getResources().getDrawable(C2466R.C2467drawable.hs__actionbar_compat_shadow));
        } else {
            frameLayout.setForeground(new ColorDrawable(0));
        }
    }

    private void startLiveUpdates() {
        ConversationalFragment conversationalFragment = (ConversationalFragment) getRetainedChildFragmentManager().findFragmentByTag(ConversationalFragment.FRAGMENT_TAG);
        if (conversationalFragment != null) {
            conversationalFragment.startLiveUpdates();
        }
    }

    private void stopLiveUpdates() {
        ConversationalFragment conversationalFragment = (ConversationalFragment) getRetainedChildFragmentManager().findFragmentByTag(ConversationalFragment.FRAGMENT_TAG);
        if (conversationalFragment != null) {
            conversationalFragment.stopLiveUpdates();
        }
    }

    private void updateBadgeIcon() {
        View actionView;
        MenuItem menuItem = this.contactUsMenuItem;
        if (menuItem != null && menuItem.isVisible() && (actionView = HSMenuItemCompat.getActionView(this.contactUsMenuItem)) != null) {
            TextView textView = (TextView) actionView.findViewById(C2466R.C2468id.hs__notification_badge);
            View findViewById = actionView.findViewById(C2466R.C2468id.hs__notification_badge_padding);
            int i = this.newMessageCount;
            if (i != 0) {
                textView.setText(String.valueOf(i));
                findViewById.setVisibility(8);
                textView.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
            findViewById.setVisibility(0);
        }
    }

    private void updateMessageBatchCount(Integer num) {
        this.newMessageCount = num.intValue();
        updateBadgeIcon();
    }

    public void addVisibleFragment(String str) {
        this.visibleFragments.add(str);
        refreshMenu();
    }

    public void askForReadStoragePermission() {
        BaseConversationFragment baseConversationFragment = (BaseConversationFragment) getRetainedChildFragmentManager().findFragmentByTag(ConversationalFragment.FRAGMENT_TAG);
        if (baseConversationFragment == null) {
            baseConversationFragment = (BaseConversationFragment) getRetainedChildFragmentManager().findFragmentByTag(NewConversationFragment.FRAGMENT_TAG);
        }
        if (baseConversationFragment != null) {
            baseConversationFragment.requestPermission(true, 2);
        }
    }

    public void exitSdkSession() {
        if (getActivity() instanceof ParentActivity) {
            getActivity().finish();
        } else {
            FragmentUtil.removeFragment(getActivity().getSupportFragmentManager(), this);
        }
    }

    public SupportController getSupportController() {
        return this.supportController;
    }

    public void hideBottomSheetViewContainer() {
        if (this.bottomSheetContainer.getVisibility() != 8) {
            HSLogger.m3237d(TAG, "hideBottomSheetViewContainer called");
            this.bottomSheetContainer.removeAllViews();
            this.bottomSheetContainer.setVisibility(8);
            animateViewBottomMarginChange(this.supportUIContainer, 0, 300);
        }
    }

    public boolean isParentViewBottomSheetDialogFragment() {
        if (!this.isEmbedded) {
            return false;
        }
        Fragment parentFragment = getParentFragment();
        int i = 5;
        while (true) {
            int i2 = i - 1;
            if (i <= 0 || parentFragment == null) {
                return false;
            }
            if (parentFragment instanceof BottomSheetDialogFragment) {
                return true;
            }
            parentFragment = parentFragment.getParentFragment();
            i = i2;
        }
        return false;
    }

    public void launchAttachmentPicker(Bundle bundle) {
        getImagePicker().launchPicker(bundle);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if ((i == 1 || i == 2) && intent != null && i2 == -1) {
            getImagePicker().onAttachmentPickRequestResult(i, intent);
        }
    }

    public void onAttach(Context context) {
        try {
            super.onAttach(context);
            HelpshiftContext.getPlatform().setUIContext(getContext());
            setRetainInstance(true);
            SupportController supportController2 = this.supportController;
            if (supportController2 == null) {
                this.supportController = new SupportController(HelpshiftContext.getApplicationContext(), this, getRetainedChildFragmentManager(), getArguments());
            } else {
                supportController2.onFragmentManagerUpdate(getRetainedChildFragmentManager());
            }
            if (!isChangingConfigurations()) {
                HelpshiftContext.getCoreApi().getConversationInboxPoller().startAppPoller(true);
            }
        } catch (Exception e) {
            Log.e(TAG, "Caught exception in SupportFragment.onAttach()", e);
            this.isNoOpMode = true;
        }
    }

    public void onAttachmentPickerResultFailure(int i, Long l) {
        if (i == -5) {
            SnackbarUtil.showSnackbar(getView(), C2466R.string.hs__screenshot_upload_error_msg, 0);
        } else if (i == -4) {
            SnackbarUtil.showSnackbar(getView(), C2466R.string.hs__network_error_msg, 0);
        } else if (i == -3) {
            SnackbarUtil.showSnackbar(getView(), (CharSequence) String.format(getResources().getString(C2466R.string.hs__screenshot_limit_error), new Object[]{Float.valueOf(((float) l.longValue()) / 1048576.0f)}), 0);
        } else if (i == -2) {
            SnackbarUtil.showSnackbar(getView(), C2466R.string.hs__file_type_unsupported, 0);
        } else if (i == -1) {
            SnackbarUtil.showSnackbar(getView(), C2466R.string.hs__screenshot_cloud_attach_error, 0);
        }
    }

    public void onAttachmentPickerResultSuccess(AttachmentPickerFile attachmentPickerFile, Bundle bundle) {
        getSupportController().startScreenshotPreviewFragment(attachmentPickerFile, bundle, AttachmentPreviewFragment.LaunchSource.GALLERY_APP);
    }

    public boolean onBackPressed() {
        List<Fragment> fragments = getRetainedChildFragmentManager().getFragments();
        if (fragments != null) {
            Iterator<Fragment> it = fragments.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Fragment next = it.next();
                if (next != null && next.isVisible()) {
                    if ((next instanceof FaqFlowFragment) || (next instanceof BaseConversationFragment)) {
                        FragmentManager childFragmentManager = next.getChildFragmentManager();
                        if (childFragmentManager.getBackStackEntryCount() > 0) {
                            childFragmentManager.popBackStack();
                            return true;
                        } else if (next instanceof ConversationalFragment) {
                            ConversationalFragment conversationalFragment = (ConversationalFragment) next;
                            if (conversationalFragment.onBackPressed()) {
                                return true;
                            }
                            conversationalFragment.stopLiveUpdates();
                        }
                    } else if (next instanceof AttachmentPreviewFragment) {
                        ((AttachmentPreviewFragment) next).deleteAttachmentLocalCopy();
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public void onClick(View view) {
        FaqFlowFragment faqFlowFragment;
        if (view.getId() == C2466R.C2468id.button_retry && (faqFlowFragment = FragmentUtil.getFaqFlowFragment(getRetainedChildFragmentManager())) != null) {
            faqFlowFragment.retryGetSections();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.embeddedToolbarId = arguments.getInt(MainFragment.TOOLBAR_ID);
            this.isEmbedded = arguments.getBoolean(SupportFragmentConstants.IS_EMBEDDED, false);
        }
        if (this.embeddedToolbarId == 0) {
            setHasOptionsMenu(true);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(getMenuResourceId(), menu);
        attachMenuListeners(menu);
        WeakReference<IMenuItemEventListener> weakReference = this.menuItemEventListener;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((IMenuItemEventListener) this.menuItemEventListener.get()).onCreateOptionMenuCalled();
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2466R.layout.hs__support_fragment, viewGroup, false);
    }

    public void onDestroyView() {
        SnackbarUtil.hideSnackbar(getView());
        Toolbar toolbar = this.embeddedToolbarView;
        if (!(toolbar == null || this.fragmentMenuItems == null)) {
            Menu menu = toolbar.getMenu();
            for (Integer intValue : this.fragmentMenuItems) {
                menu.removeItem(intValue.intValue());
            }
        }
        this.viewFaqsLoadError = null;
        this.viewFaqsLoading = null;
        this.viewNoFaqs = null;
        super.onDestroyView();
    }

    public void onDetach() {
        if (this.isNoOpMode) {
            super.onDetach();
            return;
        }
        HelpshiftContext.getPlatform().setUIContext((Object) null);
        LocaleContextUtil.restoreApplicationLocale();
        if (!isChangingConfigurations()) {
            HelpshiftContext.getCoreApi().getConversationInboxPoller().startAppPoller(true);
        }
        super.onDetach();
    }

    public void onFailure(Integer num) {
    }

    public void onFaqsLoaded() {
        this.faqLoaded = true;
        if (!this.menuItemsPrepared) {
            return;
        }
        if (this.visibleFragments.contains(FaqFragment.class.getName()) || this.visibleFragments.contains(QuestionListFragment.class.getName())) {
            setSearchMenuVisible(true);
        }
    }

    public void onFocusChanged(boolean z) {
        List<Fragment> fragments = getRetainedChildFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment next : fragments) {
                if (next instanceof ConversationalFragment) {
                    ((ConversationalFragment) next).onFocusChanged(z);
                }
            }
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C2466R.C2468id.hs__contact_us) {
            this.supportController.onContactUsClicked((String) null);
            return true;
        } else if (itemId == C2466R.C2468id.hs__action_done) {
            this.supportController.actionDone();
            return true;
        } else if (itemId == C2466R.C2468id.hs__start_new_conversation) {
            sendMenuEventClickEvent(HSMenuItemType.START_NEW_CONVERSATION);
            return true;
        } else if (itemId != C2466R.C2468id.hs__attach_screenshot) {
            return false;
        } else {
            sendMenuEventClickEvent(HSMenuItemType.SCREENSHOT_ATTACHMENT);
            return true;
        }
    }

    public void onNewIntent(Bundle bundle) {
        if (this.isForeground) {
            this.supportController.onNewIntent(bundle);
        } else {
            this.newIntentData = bundle;
        }
        this.handleNewIntent = !this.isForeground;
    }

    public void onPause() {
        if (!getActivity(this).isChangingConfigurations()) {
            stopLiveUpdates();
        }
        super.onPause();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        List<Fragment> fragments = getRetainedChildFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment next : fragments) {
                if (next != null && next.isVisible() && (next instanceof BaseConversationFragment)) {
                    next.onRequestPermissionsResult(i, strArr, iArr);
                    return;
                }
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onResume() {
        super.onResume();
        this.supportController.start();
        setToolbarTitle(getString(C2466R.string.hs__help_header));
        showToolbarElevation(true);
        HelpshiftContext.getCoreApi().getConversationController().fetchConversationUpdatesListenerReference = new AtomicReference<>(this);
        startLiveUpdates();
        updateMessageBatchCount(Integer.valueOf(HelpshiftContext.getCoreApi().getNotificationCountSync()));
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        SupportController supportController2 = this.supportController;
        if (supportController2 != null) {
            supportController2.onSaveInstanceState(bundle);
        }
        getImagePicker().onSaveInstanceState(bundle);
    }

    public void onStart() {
        AnalyticsEventType analyticsEventType;
        super.onStart();
        if (getArguments() == null) {
            quitSupportFragment();
            return;
        }
        if (!isChangingConfigurations()) {
            HSLogger.m3237d(TAG, "Helpshift session began.");
            HSSearch.init();
            if (getArguments().getInt(SUPPORT_MODE, 0) == 0) {
                analyticsEventType = AnalyticsEventType.LIBRARY_OPENED;
            } else {
                analyticsEventType = AnalyticsEventType.LIBRARY_OPENED_DECOMP;
            }
            HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(analyticsEventType);
            if (this.handleNewIntent) {
                this.supportController.onNewIntent(this.newIntentData);
                this.handleNewIntent = false;
            }
            HelpshiftContext.getCoreApi().onSDKSessionStarted();
        }
        this.isForeground = true;
    }

    public void onStop() {
        if (!isChangingConfigurations()) {
            HSLogger.m3237d(TAG, "Helpshift session ended.");
            CoreApi coreApi = HelpshiftContext.getCoreApi();
            HSSearch.deinit();
            coreApi.getAnalyticsEventDM().pushEvent(AnalyticsEventType.LIBRARY_QUIT);
            this.isForeground = false;
            coreApi.sendAnalyticsEvent();
            coreApi.onSDKSessionEnded();
        }
        HelpshiftContext.getCoreApi().getConversationController().fetchConversationUpdatesListenerReference = null;
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.viewNoFaqs = view.findViewById(C2466R.C2468id.view_no_faqs);
        this.viewFaqsLoading = view.findViewById(C2466R.C2468id.view_faqs_loading);
        this.viewFaqsLoadError = view.findViewById(C2466R.C2468id.view_faqs_load_error);
        ((Button) view.findViewById(C2466R.C2468id.button_retry)).setOnClickListener(this);
        if (HelpshiftContext.getCoreApi().getSDKConfigurationDM().isHelpshiftBrandingDisabled()) {
            ((ImageView) view.findViewById(C2466R.C2468id.hs_logo)).setVisibility(8);
        }
        this.bottomSheetContainer = (FrameLayout) view.findViewById(C2466R.C2468id.hs__bottom_sheet_container);
        this.supportUIContainer = (LinearLayout) view.findViewById(C2466R.C2468id.hs__support_ui_parent_container);
        if (this.isEmbedded) {
            setupEmbeddedToolbarView();
        } else {
            setupHSToolbarView(view);
        }
    }

    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            SupportController supportController2 = this.supportController;
            if (supportController2 != null) {
                supportController2.onViewStateRestored(bundle);
            }
            getImagePicker().onViewStateRestored(bundle);
        }
    }

    public void refreshMenu() {
        if (this.menuItemsPrepared) {
            hideAllMenuItems();
            setMenuItemColors();
            synchronized (this.visibleFragments) {
                for (String next : this.visibleFragments) {
                    if (next.equals(FaqFragment.class.getName())) {
                        showFaqFragmentMenu();
                    } else if (next.equals(SearchFragment.class.getName())) {
                        restoreSearchMenuItem();
                    } else {
                        if (next.equals(SingleQuestionFragment.class.getName() + 1)) {
                            showSingleQuestionFragmentMenu();
                        } else if (next.equals(SectionPagerFragment.class.getName())) {
                            showSectionPagerFragmentMenu();
                        } else if (next.equals(QuestionListFragment.class.getName())) {
                            showQuestionListFragmentMenu();
                        } else {
                            if (!next.equals(NewConversationFragment.class.getName())) {
                                if (!next.equals(ConversationalFragment.class.getName())) {
                                    if (next.equals(SingleQuestionFragment.class.getName() + 2)) {
                                        restoreSingleQuestionDoneModeFragmentMenu();
                                    } else if (next.equals(DynamicFormFragment.class.getName())) {
                                        showDynamicFormFragmentMenu();
                                    } else if (next.equals(ConversationSetupFragment.class.getName()) || next.equals(AuthenticationFailureFragment.class.getName())) {
                                        setRetainSearchFragmentState(true);
                                        setSearchMenuVisible(false);
                                        setContactUsMenuVisible(false);
                                    }
                                }
                            }
                            restoreConversationFragmentMenu();
                        }
                    }
                }
            }
        }
    }

    public void registerToolbarMenuEventsListener(IMenuItemEventListener iMenuItemEventListener) {
        this.menuItemEventListener = new WeakReference<>(iMenuItemEventListener);
    }

    public void removeHSToolbarHeader(View view) {
        View findViewById;
        if (view != null && (findViewById = view.findViewById(C2466R.C2468id.custom_header_layout)) != null) {
            findViewById.setVisibility(8);
        }
    }

    public void removeVisibleFragment(String str) {
        this.visibleFragments.remove(str);
    }

    public void resetNewMessageCount() {
        updateMessageBatchCount(0);
    }

    public void resetToolbarImportanceForAccessibility() {
        if (this.isEmbedded) {
            Toolbar toolbar = this.embeddedToolbarView;
            if (toolbar != null) {
                toolbar.setImportantForAccessibility(this.embeddedToolbarViewImportanceForAccessibility);
                return;
            }
            return;
        }
        Toolbar toolbar2 = this.hsToolbarView;
        if (toolbar2 != null) {
            toolbar2.setImportantForAccessibility(0);
        }
    }

    public void setContactUsMenuVisible(boolean z) {
        if (HSMenuItemCompat.isActionViewExpanded(this.searchMenuItem)) {
            this.contactUsMenuItem.setVisible(false);
        } else {
            this.contactUsMenuItem.setVisible(z);
        }
        updateBadgeIcon();
    }

    public void setSearchListeners(FaqFlowController faqFlowController) {
        FaqFlowFragment faqFlowFragment;
        if (this.menuItemsPrepared) {
            if (faqFlowController == null && (faqFlowFragment = FragmentUtil.getFaqFlowFragment(getRetainedChildFragmentManager())) != null) {
                faqFlowController = faqFlowFragment.getFaqFlowController();
            }
            if (faqFlowController != null) {
                HSMenuItemCompat.setOnActionExpandListener(this.searchMenuItem, faqFlowController);
                this.searchView.setOnQueryTextListener(faqFlowController);
            }
        }
    }

    public void setSearchMenuQuery(String str) {
        if (!HSMenuItemCompat.isActionViewExpanded(this.searchMenuItem)) {
            HSMenuItemCompat.expandActionView(this.searchMenuItem);
        }
        if (!TextUtils.isEmpty(str)) {
            this.searchView.setQuery(str, false);
        }
    }

    public void setSearchMenuVisible(boolean z) {
        if (HSMenuItemCompat.isActionViewExpanded(this.searchMenuItem) && !this.visibleFragments.contains(SearchFragment.class.getName())) {
            HSMenuItemCompat.collapseActionView(this.searchMenuItem);
        }
        this.searchMenuItem.setVisible(z);
    }

    public void setToolbarImportanceForAccessibility(int i) {
        if (this.isEmbedded) {
            Toolbar toolbar = this.embeddedToolbarView;
            if (toolbar != null) {
                this.embeddedToolbarViewImportanceForAccessibility = toolbar.getImportantForAccessibility();
                this.embeddedToolbarView.setImportantForAccessibility(i);
                return;
            }
            return;
        }
        Toolbar toolbar2 = this.hsToolbarView;
        if (toolbar2 != null) {
            toolbar2.setImportantForAccessibility(i);
        }
    }

    public void setToolbarTitleAndHeader(String str) {
        if (this.isEmbedded) {
            Toolbar toolbar = this.embeddedToolbarView;
            if (toolbar != null) {
                toolbar.setTitle((CharSequence) str);
                return;
            }
            return;
        }
        ActionBar hSActivityActionBar = getHSActivityActionBar();
        if (hSActivityActionBar == null) {
            return;
        }
        if (isConversationFragmentVisible()) {
            hSActivityActionBar.setTitle((CharSequence) getHeaderTitle());
            setUpHSToolbarHeader(getView());
            return;
        }
        removeHSToolbarHeader(getView());
        hSActivityActionBar.setTitle((CharSequence) str);
    }

    public void setUpHSToolbarHeader(View view) {
        SDKConfigurationDM sDKConfigurationDM = HelpshiftContext.getCoreApi().getSDKConfigurationDM();
        View findViewById = view.findViewById(C2466R.C2468id.custom_header_layout);
        if (isConversationFragmentVisible()) {
            ((HSTextView) view.findViewById(C2466R.C2468id.hs__header_title)).setText(getHeaderTitle());
            if (sDKConfigurationDM.isConversationHeaderEnabled()) {
                String conversationHeaderImageLocalPath = sDKConfigurationDM.getConversationHeaderImageLocalPath();
                AvatarImageLoader.loadConversationHeaderAvatarImage(HelpshiftContext.getApplicationContext(), (CircleImageView) view.findViewById(C2466R.C2468id.hs__header_avatar_image), conversationHeaderImageLocalPath);
                findViewById.setVisibility(0);
                return;
            }
            findViewById.setVisibility(8);
            return;
        }
        findViewById.setVisibility(8);
    }

    public boolean shouldRefreshMenu() {
        return false;
    }

    public void showBottomSheetViewContainer(View view, int i) {
        if (view == null || i < 0) {
            HSLogger.m3237d(TAG, "showBottomSheetViewContainer called with invalid data");
            return;
        }
        HSLogger.m3237d(TAG, "showBottomSheetViewContainer called");
        this.bottomSheetContainer.removeAllViews();
        this.bottomSheetContainer.addView(view);
        this.bottomSheetContainer.setVisibility(0);
        animateViewBottomMarginChange(this.supportUIContainer, i, 300);
    }

    public void showToolbarElevation(boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            showToolbarElevationLollipop(z);
        } else {
            showToolbarElevationPreLollipop(z);
        }
    }

    public void unRegisterSearchListener() {
        if (this.menuItemsPrepared) {
            HSMenuItemCompat.setOnActionExpandListener(this.searchMenuItem, null);
            this.searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) null);
        }
    }

    public void unRegisterToolbarMenuEventsListener(IMenuItemEventListener iMenuItemEventListener) {
        WeakReference<IMenuItemEventListener> weakReference = this.menuItemEventListener;
        if (weakReference != null && weakReference.get() == iMenuItemEventListener) {
            this.menuItemEventListener = null;
        }
    }

    public void updateFaqLoadingUI(int i) {
        this.viewNoFaqs.setVisibility(8);
        this.viewFaqsLoading.setVisibility(8);
        this.viewFaqsLoadError.setVisibility(8);
        if (i == 0) {
            this.viewFaqsLoading.setVisibility(0);
        } else if (i == 2) {
            this.viewNoFaqs.setVisibility(0);
        } else if (i == 3) {
            this.viewFaqsLoadError.setVisibility(0);
        }
    }

    public void updateMenuItemVisibility(HSMenuItemType hSMenuItemType, boolean z) {
        MenuItem menuItem;
        int ordinal = hSMenuItemType.ordinal();
        if (ordinal == 0) {
            MenuItem menuItem2 = this.startNewConversationMenuItem;
            if (menuItem2 != null) {
                menuItem2.setVisible(z);
            }
        } else if (ordinal == 1 && (menuItem = this.attachImageMenuItem) != null) {
            menuItem.setVisible(z);
        }
    }

    public void onDataFetched(Integer num) {
        updateMessageBatchCount(num);
    }
}
