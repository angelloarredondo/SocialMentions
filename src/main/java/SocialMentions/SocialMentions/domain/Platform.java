package SocialMentions.SocialMentions.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Platform {
    private final String facebookAccount;
    private final String tweeterAccount;
    private List<String> facebookComments = new ArrayList<>();

    public Platform(String facebookAccount, String tweeterAccount) {
        this.facebookAccount = facebookAccount;
        this.tweeterAccount = tweeterAccount;
        guard_valid();
    }

    private void guard_valid() {
        if(isTwitter() || isFacebook()) return;
        throw new InvalidSocialMention("Error, Tweeter or Facebook account must be present");
    }

    public boolean isFacebook() {
        return this.facebookAccount != null;
    }

    public boolean isTwitter() {
        return this.tweeterAccount != null;
    }

    public List<String> getFacebookComments() {
       return this.facebookComments;
    }

    public String getFacebookAccount() {
        return  this.facebookAccount;
    }

    public String getTweeterAccount() {
        return this.tweeterAccount;
    }
}
