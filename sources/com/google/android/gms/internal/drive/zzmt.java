package com.google.android.gms.internal.drive;

public final class zzmt {
    public static String zzc(zzjc zzjc) {
        zzmu zzmu = new zzmu(zzjc);
        StringBuilder sb = new StringBuilder(zzmu.size());
        for (int i = 0; i < zzmu.size(); i++) {
            byte zzs = zzmu.zzs(i);
            if (zzs == 34) {
                sb.append("\\\"");
            } else if (zzs == 39) {
                sb.append("\\'");
            } else if (zzs != 92) {
                switch (zzs) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (zzs >= 32 && zzs <= 126) {
                            sb.append((char) zzs);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((zzs >>> 6) & 3) + 48));
                            sb.append((char) (((zzs >>> 3) & 7) + 48));
                            sb.append((char) ((zzs & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
