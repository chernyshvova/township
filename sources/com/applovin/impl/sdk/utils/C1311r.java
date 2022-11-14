package com.applovin.impl.sdk.utils;

import android.util.Xml;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* renamed from: com.applovin.impl.sdk.utils.r */
public class C1311r {

    /* renamed from: a */
    public final C1314v f2567a;

    /* renamed from: b */
    public Stack<C1313a> f2568b;

    /* renamed from: c */
    public StringBuilder f2569c;

    /* renamed from: d */
    public long f2570d;

    /* renamed from: e */
    public C1313a f2571e;

    /* renamed from: com.applovin.impl.sdk.utils.r$a */
    public static class C1313a extends C1310q {
        public C1313a(String str, Map<String, String> map, C1310q qVar) {
            super(str, map, qVar);
        }

        /* renamed from: a */
        public void mo11368a(C1310q qVar) {
            if (qVar != null) {
                this.f2563c.add(qVar);
                return;
            }
            throw new IllegalArgumentException("None specified.");
        }

        /* renamed from: d */
        public void mo11369d(String str) {
            this.f2562b = str;
        }
    }

    public C1311r(C1188m mVar) {
        if (mVar != null) {
            this.f2567a = mVar.mo10922B();
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    /* renamed from: a */
    public static C1310q m2643a(String str, C1188m mVar) throws SAXException {
        return new C1311r(mVar).mo11356a(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m2647a(Attributes attributes) {
        if (attributes == null) {
            return Collections.emptyMap();
        }
        int length = attributes.getLength();
        HashMap hashMap = new HashMap(length);
        for (int i = 0; i < length; i++) {
            hashMap.put(attributes.getQName(i), attributes.getValue(i));
        }
        return hashMap;
    }

    /* renamed from: a */
    public C1310q mo11356a(String str) throws SAXException {
        if (str != null) {
            this.f2569c = new StringBuilder();
            this.f2568b = new Stack<>();
            this.f2571e = null;
            Xml.parse(str, new ContentHandler() {
                public void characters(char[] cArr, int i, int i2) {
                    String trim = new String(Arrays.copyOfRange(cArr, i, i2)).trim();
                    if (StringUtils.isValidString(trim)) {
                        C1311r.this.f2569c.append(trim);
                    }
                }

                public void endDocument() {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - C1311r.this.f2570d;
                    C1314v a = C1311r.this.f2567a;
                    a.mo11372b("XmlParser", "Finished parsing in " + seconds + " seconds");
                }

                public void endElement(String str, String str2, String str3) {
                    C1311r rVar = C1311r.this;
                    C1313a unused = rVar.f2571e = (C1313a) rVar.f2568b.pop();
                    C1311r.this.f2571e.mo11369d(C1311r.this.f2569c.toString().trim());
                    C1311r.this.f2569c.setLength(0);
                }

                public void endPrefixMapping(String str) {
                }

                public void ignorableWhitespace(char[] cArr, int i, int i2) {
                }

                public void processingInstruction(String str, String str2) {
                }

                public void setDocumentLocator(Locator locator) {
                }

                public void skippedEntity(String str) {
                }

                public void startDocument() {
                    C1311r.this.f2567a.mo11372b("XmlParser", "Begin parsing...");
                    long unused = C1311r.this.f2570d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                }

                public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
                    C1313a aVar = null;
                    try {
                        if (!C1311r.this.f2568b.isEmpty()) {
                            aVar = (C1313a) C1311r.this.f2568b.peek();
                        }
                        C1313a aVar2 = new C1313a(str2, C1311r.this.m2647a(attributes), aVar);
                        if (aVar != null) {
                            aVar.mo11368a(aVar2);
                        }
                        C1311r.this.f2568b.push(aVar2);
                    } catch (Exception e) {
                        C1311r.this.f2567a.mo11373b("XmlParser", GeneratedOutlineSupport.outline17("Unable to process element <", str2, ">"), e);
                        throw new SAXException("Failed to start element", e);
                    }
                }

                public void startPrefixMapping(String str, String str2) {
                }
            });
            C1313a aVar = this.f2571e;
            if (aVar != null) {
                return aVar;
            }
            throw new SAXException("Unable to parse XML into node");
        }
        throw new IllegalArgumentException("Unable to parse. No XML specified.");
    }
}
