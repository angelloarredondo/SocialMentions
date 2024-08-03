package SocialMentions.SocialMentions.infraestructure;

import java.util.List;

public class SocialMentionMapper {
    private String facebookAccount;
    private String tweeterAccount;
    private String message;
    private List<String> facebookComments;

    public String getFacebookAccount() {
        return this.facebookAccount;
    }

    public String getTweeterAccount() {
        return this.tweeterAccount;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getFacebookComments() {
        return this.facebookComments;
    }

    public Object getTweeterUrl() {
        return null;
    }

    public void setFacebookAccount(String facebookAccount) {
        this.facebookAccount = facebookAccount;
    }

    public void setFacebookComments(List<String> list) {
        this.facebookComments = list;
    }

    public void setTweeterAccount(String tweeterAccount) {
        this.tweeterAccount = tweeterAccount;
    }
}
