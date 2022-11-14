package okhttp3.internal.http2;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.Utility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.p042db.network.tables.UrlMetadataTable;
import com.playrix.gplay.billing.Base64;
import com.vungle.warren.model.CookieDBAdapter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Huffman;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public final class Hpack {
    public static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    public static final Header[] STATIC_HEADER_TABLE = {new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, (String) Utility.URL_SCHEME), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header((String) CookieDBAdapter.CookieColumns.TABLE_NAME, ""), new Header("date", ""), new Header((String) UrlMetadataTable.Columns.ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header((String) FirebaseAnalytics.Param.LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};

    public static final class Reader {
        public Header[] dynamicTable = new Header[8];
        public int dynamicTableByteCount = 0;
        public int headerCount = 0;
        public final List<Header> headerList = new ArrayList();
        public final int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        public int nextHeaderIndex = 7;
        public final BufferedSource source;

        public Reader(int i, Source source2) {
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i;
            this.source = Okio.buffer(source2);
        }

        public final void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        public final int dynamicTableIndex(int i) {
            return this.nextHeaderIndex + 1 + i;
        }

        public final int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        int i3 = this.nextHeaderIndex;
                        System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i2, this.headerCount);
                        this.nextHeaderIndex += i2;
                    } else {
                        Header[] headerArr2 = this.dynamicTable;
                        i -= headerArr2[length].hpackSize;
                        this.dynamicTableByteCount -= headerArr2[length].hpackSize;
                        this.headerCount--;
                        i2++;
                    }
                }
                Header[] headerArr3 = this.dynamicTable;
                int i32 = this.nextHeaderIndex;
                System.arraycopy(headerArr3, i32 + 1, headerArr3, i32 + 1 + i2, this.headerCount);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        public final ByteString getName(int i) throws IOException {
            if (i >= 0 && i <= Hpack.STATIC_HEADER_TABLE.length + -1) {
                return Hpack.STATIC_HEADER_TABLE[i].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    return headerArr[dynamicTableIndex].name;
                }
            }
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Header index too large ");
            outline24.append(i + 1);
            throw new IOException(outline24.toString());
        }

        public final void insertIntoDynamicTable(int i, Header header) {
            this.headerList.add(header);
            int i2 = header.hpackSize;
            if (i != -1) {
                i2 -= this.dynamicTable[(this.nextHeaderIndex + 1) + i].hpackSize;
            }
            int i3 = this.maxDynamicTableByteCount;
            if (i2 > i3) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i2) - i3);
            if (i == -1) {
                int i4 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i5 = this.nextHeaderIndex;
                this.nextHeaderIndex = i5 - 1;
                this.dynamicTable[i5] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[this.nextHeaderIndex + 1 + i + evictToRecoverBytes + i] = header;
            }
            this.dynamicTableByteCount += i2;
        }

        public ByteString readByteString() throws IOException {
            byte readByte = this.source.readByte() & Base64.EQUALS_SIGN_ENC;
            boolean z = (readByte & 128) == 128;
            int readInt = readInt(readByte, 127);
            if (!z) {
                return this.source.readByteString((long) readInt);
            }
            Huffman huffman = Huffman.INSTANCE;
            byte[] readByteArray = this.source.readByteArray((long) readInt);
            if (huffman != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Huffman.Node node = huffman.root;
                byte b = 0;
                int i = 0;
                for (byte b2 : readByteArray) {
                    b = (b << 8) | (b2 & Base64.EQUALS_SIGN_ENC);
                    i += 8;
                    while (i >= 8) {
                        int i2 = i - 8;
                        node = node.children[(b >>> i2) & 255];
                        if (node.children == null) {
                            byteArrayOutputStream.write(node.symbol);
                            i -= node.terminalBits;
                            node = huffman.root;
                        } else {
                            i = i2;
                        }
                    }
                }
                while (i > 0) {
                    Huffman.Node node2 = node.children[(b << (8 - i)) & 255];
                    if (node2.children != null || node2.terminalBits > i) {
                        break;
                    }
                    byteArrayOutputStream.write(node2.symbol);
                    i -= node2.terminalBits;
                    node = huffman.root;
                }
                return ByteString.m2766of(byteArrayOutputStream.toByteArray());
            }
            throw null;
        }

        public int readInt(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                byte readByte = this.source.readByte() & Base64.EQUALS_SIGN_ENC;
                if ((readByte & 128) == 0) {
                    return i2 + (readByte << i4);
                }
                i2 += (readByte & Byte.MAX_VALUE) << i4;
                i4 += 7;
            }
        }
    }

    public static final class Writer {
        public Header[] dynamicTable = new Header[8];
        public int dynamicTableByteCount = 0;
        public boolean emitDynamicTableSizeUpdate;
        public int headerCount = 0;
        public int maxDynamicTableByteCount = 4096;
        public int nextHeaderIndex = 7;
        public final Buffer out;
        public int smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
        public final boolean useCompression = true;

        public Writer(Buffer buffer) {
            this.out = buffer;
        }

        public final void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        public final int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        int i3 = this.nextHeaderIndex;
                        System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i2, this.headerCount);
                        Header[] headerArr2 = this.dynamicTable;
                        int i4 = this.nextHeaderIndex;
                        Arrays.fill(headerArr2, i4 + 1, i4 + 1 + i2, (Object) null);
                        this.nextHeaderIndex += i2;
                    } else {
                        Header[] headerArr3 = this.dynamicTable;
                        i -= headerArr3[length].hpackSize;
                        this.dynamicTableByteCount -= headerArr3[length].hpackSize;
                        this.headerCount--;
                        i2++;
                    }
                }
                Header[] headerArr4 = this.dynamicTable;
                int i32 = this.nextHeaderIndex;
                System.arraycopy(headerArr4, i32 + 1, headerArr4, i32 + 1 + i2, this.headerCount);
                Header[] headerArr22 = this.dynamicTable;
                int i42 = this.nextHeaderIndex;
                Arrays.fill(headerArr22, i42 + 1, i42 + 1 + i2, (Object) null);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        public final void insertIntoDynamicTable(Header header) {
            int i = header.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: long} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeByteString(okio.ByteString r13) throws java.io.IOException {
            /*
                r12 = this;
                boolean r0 = r12.useCompression
                r1 = 127(0x7f, float:1.78E-43)
                r2 = 0
                if (r0 == 0) goto L_0x0084
                okhttp3.internal.http2.Huffman r0 = okhttp3.internal.http2.Huffman.INSTANCE
                r3 = 0
                if (r0 == 0) goto L_0x0083
                r4 = 0
                r6 = r4
                r0 = 0
            L_0x0010:
                int r8 = r13.size()
                r9 = 255(0xff, float:3.57E-43)
                if (r0 >= r8) goto L_0x0026
                byte r8 = r13.getByte(r0)
                r8 = r8 & r9
                byte[] r9 = okhttp3.internal.http2.Huffman.CODE_LENGTHS
                byte r8 = r9[r8]
                long r8 = (long) r8
                long r6 = r6 + r8
                int r0 = r0 + 1
                goto L_0x0010
            L_0x0026:
                r10 = 7
                long r6 = r6 + r10
                r0 = 3
                long r6 = r6 >> r0
                int r0 = (int) r6
                int r6 = r13.size()
                if (r0 >= r6) goto L_0x0084
                okio.Buffer r0 = new okio.Buffer
                r0.<init>()
                okhttp3.internal.http2.Huffman r6 = okhttp3.internal.http2.Huffman.INSTANCE
                if (r6 == 0) goto L_0x0082
                r3 = 0
            L_0x003c:
                int r6 = r13.size()
                if (r2 >= r6) goto L_0x0063
                byte r6 = r13.getByte(r2)
                r6 = r6 & r9
                int[] r7 = okhttp3.internal.http2.Huffman.CODES
                r7 = r7[r6]
                byte[] r8 = okhttp3.internal.http2.Huffman.CODE_LENGTHS
                byte r6 = r8[r6]
                long r4 = r4 << r6
                long r7 = (long) r7
                long r4 = r4 | r7
                int r3 = r3 + r6
            L_0x0053:
                r6 = 8
                if (r3 < r6) goto L_0x0060
                int r3 = r3 + -8
                long r6 = r4 >> r3
                int r7 = (int) r6
                r0.writeByte((int) r7)
                goto L_0x0053
            L_0x0060:
                int r2 = r2 + 1
                goto L_0x003c
            L_0x0063:
                if (r3 <= 0) goto L_0x0070
                int r13 = 8 - r3
                long r4 = r4 << r13
                int r13 = r9 >>> r3
                long r2 = (long) r13
                long r2 = r2 | r4
                int r13 = (int) r2
                r0.writeByte((int) r13)
            L_0x0070:
                okio.ByteString r13 = r0.readByteString()
                byte[] r0 = r13.data
                int r0 = r0.length
                r2 = 128(0x80, float:1.794E-43)
                r12.writeInt(r0, r1, r2)
                okio.Buffer r0 = r12.out
                r0.write((okio.ByteString) r13)
                goto L_0x0090
            L_0x0082:
                throw r3
            L_0x0083:
                throw r3
            L_0x0084:
                int r0 = r13.size()
                r12.writeInt(r0, r1, r2)
                okio.Buffer r0 = r12.out
                r0.write((okio.ByteString) r13)
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.writeByteString(okio.ByteString):void");
        }

        public void writeHeaders(List<Header> list) throws IOException {
            int i;
            int i2;
            if (this.emitDynamicTableSizeUpdate) {
                int i3 = this.smallestHeaderTableSizeSetting;
                if (i3 < this.maxDynamicTableByteCount) {
                    writeInt(i3, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                Header header = list.get(i4);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Integer num = Hpack.NAME_TO_FIRST_INDEX.get(asciiLowercase);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (i2 > 1 && i2 < 8) {
                        if (Util.equal(Hpack.STATIC_HEADER_TABLE[i2 - 1].value, byteString)) {
                            i = i2;
                        } else if (Util.equal(Hpack.STATIC_HEADER_TABLE[i2].value, byteString)) {
                            i = i2;
                            i2++;
                        }
                    }
                    i = i2;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (i2 == -1) {
                    int i5 = this.nextHeaderIndex + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (Util.equal(this.dynamicTable[i5].name, asciiLowercase)) {
                            if (Util.equal(this.dynamicTable[i5].value, byteString)) {
                                i2 = Hpack.STATIC_HEADER_TABLE.length + (i5 - this.nextHeaderIndex);
                                break;
                            } else if (i == -1) {
                                i = (i5 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i2 != -1) {
                    writeInt(i2, 127, 128);
                } else if (i == -1) {
                    this.out.writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else {
                    ByteString byteString2 = Header.PSEUDO_PREFIX;
                    if (asciiLowercase == null) {
                        throw null;
                    } else if (!asciiLowercase.rangeEquals(0, byteString2, 0, byteString2.size()) || Header.TARGET_AUTHORITY.equals(asciiLowercase)) {
                        writeInt(i, 63, 64);
                        writeByteString(byteString);
                        insertIntoDynamicTable(header);
                    } else {
                        writeInt(i, 15, 0);
                        writeByteString(byteString);
                    }
                }
            }
        }

        public void writeInt(int i, int i2, int i3) {
            if (i < i2) {
                this.out.writeByte(i | i3);
                return;
            }
            this.out.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.out.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.out.writeByte(i4);
        }
    }

    static {
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (i < headerArr.length) {
                if (!linkedHashMap.containsKey(headerArr[i].name)) {
                    linkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
                }
                i++;
            } else {
                NAME_TO_FIRST_INDEX = Collections.unmodifiableMap(linkedHashMap);
                return;
            }
        }
    }

    public static ByteString checkLowercase(ByteString byteString) throws IOException {
        int size = byteString.size();
        int i = 0;
        while (i < size) {
            byte b = byteString.getByte(i);
            if (b < 65 || b > 90) {
                i++;
            } else {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("PROTOCOL_ERROR response malformed: mixed case name: ");
                outline24.append(byteString.utf8());
                throw new IOException(outline24.toString());
            }
        }
        return byteString;
    }
}
