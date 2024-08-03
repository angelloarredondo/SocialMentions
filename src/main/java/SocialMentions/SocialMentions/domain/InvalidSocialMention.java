package SocialMentions.SocialMentions.domain;

public class InvalidSocialMention extends RuntimeException {
    public InvalidSocialMention(String message) {
        super(message);
    }
}
