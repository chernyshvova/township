package com.helpshift.conversation.activeconversation.message;

import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.util.HSCloneable;

public class Author implements HSCloneable {
    public final String authorId;
    public String authorName;
    public String localAvatarImagePath;
    public final AuthorRole role;

    public enum AuthorRole {
        AGENT("a"),
        BOT("b"),
        SYSTEM(AnalyticsEventKey.SEARCH_QUERY),
        LOCAL_USER("local_user");
        
        public final String roleName;

        /* access modifiers changed from: public */
        AuthorRole(String str) {
            this.roleName = str;
        }

        public static AuthorRole getEnum(String str) {
            for (AuthorRole authorRole : values()) {
                if (authorRole.roleName.equals(str)) {
                    return authorRole;
                }
            }
            return SYSTEM;
        }

        public String getValue() {
            return this.roleName;
        }
    }

    public Author(String str, String str2, AuthorRole authorRole) {
        this.authorName = str;
        this.authorId = str2;
        this.role = authorRole;
    }

    public boolean equals(Object obj) {
        Author author = (Author) obj;
        return author != null && author.authorName.equals(this.authorName) && author.authorId.equals(this.authorId) && author.role == this.role;
    }

    public Author deepClone() {
        return new Author(this);
    }

    public Author(Author author) {
        this.authorName = author.authorName;
        this.authorId = author.authorId;
        this.role = author.role;
        this.localAvatarImagePath = author.localAvatarImagePath;
    }
}
