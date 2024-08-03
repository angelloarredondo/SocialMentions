package SocialMentions.SocialMentions.domain;

import java.util.Arrays;

public class SocialMention {
    private final Platform platform;
    private Message message;
    private String tweeterUrl;
    private Double score;

    public SocialMention(Platform platform, Message message) {

        this.platform = platform;
        this.message = message;

        processMessage();
    }

    public void processMessage() {
        if(platform.isFacebook()) {
            String updateMessage = "facebookMessage: " + message.get();
            String comments = platform
                    .getFacebookComments().stream()
                    .reduce("", (h, c) -> h + " " + c);
            this.message = new Message(updateMessage + " || comments: " +
                    comments);
        } else if(platform.isTwitter()) {
            this.message = new Message("tweeterMessage: " + message.get());
        }
    }

    public String getMessage() {
        return this.message.getValue();
    }

    public String getFacebookAccount() {
        return this.platform.getFacebookAccount();
    }

    public String getTweeterUrl() {
        return this.tweeterUrl;
    }

    public String getTweeterAccount() {
        return this.platform.getTweeterAccount();
    }

    public void updateScore(Double score) {
        this.score = score;
    }
}
