package com.helpshift.conversation.activeconversation.message;

import com.helpshift.conversation.activeconversation.message.input.OptionInput;

public class OptionInputMessageDM extends UserMessageDM {
    public final OptionInput input;
    public final MessageType referredMessageType;

    public OptionInputMessageDM(FAQListMessageWithOptionInputDM fAQListMessageWithOptionInputDM) {
        super(fAQListMessageWithOptionInputDM.body, fAQListMessageWithOptionInputDM.getCreatedAt(), fAQListMessageWithOptionInputDM.getEpochCreatedAtTime(), fAQListMessageWithOptionInputDM.author, MessageType.OPTION_INPUT);
        this.serverId = fAQListMessageWithOptionInputDM.serverId;
        this.input = fAQListMessageWithOptionInputDM.input;
        this.referredMessageType = fAQListMessageWithOptionInputDM.messageType;
        this.conversationLocalId = fAQListMessageWithOptionInputDM.conversationLocalId;
    }

    public OptionInputMessageDM deepClone() {
        return new OptionInputMessageDM(this);
    }

    public OptionInputMessageDM(AdminMessageWithOptionInputDM adminMessageWithOptionInputDM) {
        super(adminMessageWithOptionInputDM.body, adminMessageWithOptionInputDM.getCreatedAt(), adminMessageWithOptionInputDM.getEpochCreatedAtTime(), adminMessageWithOptionInputDM.author, MessageType.OPTION_INPUT);
        this.serverId = adminMessageWithOptionInputDM.serverId;
        this.input = adminMessageWithOptionInputDM.input;
        this.referredMessageType = adminMessageWithOptionInputDM.messageType;
        this.conversationLocalId = adminMessageWithOptionInputDM.conversationLocalId;
    }

    public OptionInputMessageDM(AdminResolutionMessageWithOptions adminResolutionMessageWithOptions) {
        super(adminResolutionMessageWithOptions.body, adminResolutionMessageWithOptions.getCreatedAt(), adminResolutionMessageWithOptions.getEpochCreatedAtTime(), adminResolutionMessageWithOptions.author, MessageType.OPTION_INPUT);
        this.serverId = adminResolutionMessageWithOptions.serverId;
        this.input = adminResolutionMessageWithOptions.input;
        this.referredMessageType = adminResolutionMessageWithOptions.messageType;
        this.conversationLocalId = adminResolutionMessageWithOptions.conversationLocalId;
    }

    public OptionInputMessageDM(OptionInputMessageDM optionInputMessageDM) {
        super(optionInputMessageDM);
        this.input = optionInputMessageDM.input.deepClone();
        this.referredMessageType = optionInputMessageDM.referredMessageType;
    }
}
