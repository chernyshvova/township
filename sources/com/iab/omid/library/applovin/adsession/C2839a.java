package com.iab.omid.library.applovin.adsession;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.applovin.p045b.C2841a;
import com.iab.omid.library.applovin.p045b.C2844c;
import com.iab.omid.library.applovin.p045b.C2848f;
import com.iab.omid.library.applovin.p047d.C2860e;
import com.iab.omid.library.applovin.p048e.C2862a;
import com.iab.omid.library.applovin.publisher.AdSessionStatePublisher;
import com.iab.omid.library.applovin.publisher.C2865a;
import com.iab.omid.library.applovin.publisher.C2866b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.applovin.adsession.a */
public class C2839a extends AdSession {

    /* renamed from: a */
    public static final Pattern f3376a = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: b */
    public final AdSessionContext f3377b;

    /* renamed from: c */
    public final AdSessionConfiguration f3378c;

    /* renamed from: d */
    public final List<C2844c> f3379d = new ArrayList();

    /* renamed from: e */
    public C2862a f3380e;

    /* renamed from: f */
    public AdSessionStatePublisher f3381f;

    /* renamed from: g */
    public boolean f3382g = false;

    /* renamed from: h */
    public boolean f3383h = false;

    /* renamed from: i */
    public final String f3384i;

    /* renamed from: j */
    public boolean f3385j;

    /* renamed from: k */
    public boolean f3386k;

    /* renamed from: l */
    public PossibleObstructionListener f3387l;

    public C2839a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f3378c = adSessionConfiguration;
        this.f3377b = adSessionContext;
        this.f3384i = UUID.randomUUID().toString();
        m3263c((View) null);
        this.f3381f = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new C2865a(adSessionContext.getWebView()) : new C2866b(adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f3381f.mo36761a();
        C2841a.m3285a().mo36709a(this);
        this.f3381f.mo36765a(adSessionConfiguration);
    }

    /* renamed from: a */
    private C2844c m3260a(View view) {
        for (C2844c next : this.f3379d) {
            if (next.mo36728a().get() == view) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m3261a(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 50) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
        } else if (!f3376a.matcher(str).matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
    }

    /* renamed from: b */
    public static void m3262b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    /* renamed from: c */
    private void m3263c(View view) {
        this.f3380e = new C2862a(view);
    }

    /* renamed from: d */
    private void m3264d(View view) {
        Collection<C2839a> b = C2841a.m3285a().mo36710b();
        if (b != null && !b.isEmpty()) {
            for (C2839a next : b) {
                if (next != this && next.mo36678e() == view) {
                    next.f3380e.clear();
                }
            }
        }
    }

    /* renamed from: k */
    private void m3265k() {
        if (this.f3385j) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    /* renamed from: l */
    private void m3266l() {
        if (this.f3386k) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    /* renamed from: a */
    public List<C2844c> mo36672a() {
        return this.f3379d;
    }

    /* renamed from: a */
    public void mo36673a(List<C2862a> list) {
        if (mo36675b()) {
            ArrayList arrayList = new ArrayList();
            for (C2862a aVar : list) {
                View view = (View) aVar.get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f3387l.onPossibleObstructionsDetected(this.f3384i, arrayList);
        }
    }

    /* renamed from: a */
    public void mo36674a(@NonNull JSONObject jSONObject) {
        m3266l();
        getAdSessionStatePublisher().mo36773a(jSONObject);
        this.f3386k = true;
    }

    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (!this.f3383h) {
            m3262b(view);
            m3261a(str);
            if (m3260a(view) == null) {
                this.f3379d.add(new C2844c(view, friendlyObstructionPurpose, str));
            }
        }
    }

    /* renamed from: b */
    public boolean mo36675b() {
        return this.f3387l != null;
    }

    /* renamed from: c */
    public void mo36676c() {
        m3265k();
        getAdSessionStatePublisher().mo36781g();
        this.f3385j = true;
    }

    /* renamed from: d */
    public void mo36677d() {
        m3266l();
        getAdSessionStatePublisher().mo36783h();
        this.f3386k = true;
    }

    /* renamed from: e */
    public View mo36678e() {
        return (View) this.f3380e.get();
    }

    public void error(ErrorType errorType, String str) {
        if (!this.f3383h) {
            C2860e.m3379a((Object) errorType, "Error type is null");
            C2860e.m3381a(str, "Message is null");
            getAdSessionStatePublisher().mo36766a(errorType, str);
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    /* renamed from: f */
    public boolean mo36679f() {
        return this.f3382g && !this.f3383h;
    }

    public void finish() {
        if (!this.f3383h) {
            this.f3380e.clear();
            removeAllFriendlyObstructions();
            this.f3383h = true;
            getAdSessionStatePublisher().mo36780f();
            C2841a.m3285a().mo36713c(this);
            getAdSessionStatePublisher().mo36775b();
            this.f3381f = null;
            this.f3387l = null;
        }
    }

    /* renamed from: g */
    public boolean mo36680g() {
        return this.f3382g;
    }

    public String getAdSessionId() {
        return this.f3384i;
    }

    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f3381f;
    }

    /* renamed from: h */
    public boolean mo36681h() {
        return this.f3383h;
    }

    /* renamed from: i */
    public boolean mo36682i() {
        return this.f3378c.isNativeImpressionOwner();
    }

    /* renamed from: j */
    public boolean mo36683j() {
        return this.f3378c.isNativeMediaEventsOwner();
    }

    public void registerAdView(View view) {
        if (!this.f3383h) {
            C2860e.m3379a((Object) view, "AdView is null");
            if (mo36678e() != view) {
                m3263c(view);
                getAdSessionStatePublisher().mo36784i();
                m3264d(view);
            }
        }
    }

    public void removeAllFriendlyObstructions() {
        if (!this.f3383h) {
            this.f3379d.clear();
        }
    }

    public void removeFriendlyObstruction(View view) {
        if (!this.f3383h) {
            m3262b(view);
            C2844c a = m3260a(view);
            if (a != null) {
                this.f3379d.remove(a);
            }
        }
    }

    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.f3387l = possibleObstructionListener;
    }

    public void start() {
        if (!this.f3382g) {
            this.f3382g = true;
            C2841a.m3285a().mo36711b(this);
            this.f3381f.mo36762a(C2848f.m3325a().mo36754d());
            this.f3381f.mo36767a(this, this.f3377b);
        }
    }
}
