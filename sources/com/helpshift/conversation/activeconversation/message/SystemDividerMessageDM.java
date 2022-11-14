package com.helpshift.conversation.activeconversation.message;

public class SystemDividerMessageDM extends SystemMessageDM {
    public final boolean showDividerText;

    public SystemDividerMessageDM(String str, long j, boolean z) {
        super("", str, j, MessageType.SYSTEM_DIVIDER);
        this.showDividerText = z;
    }

    public SystemDividerMessageDM(SystemDividerMessageDM systemDividerMessageDM) {
        super(systemDividerMessageDM);
        this.showDividerText = systemDividerMessageDM.showDividerText;
    }

    public SystemDividerMessageDM deepClone() {
        return new SystemDividerMessageDM(this);
    }
}
