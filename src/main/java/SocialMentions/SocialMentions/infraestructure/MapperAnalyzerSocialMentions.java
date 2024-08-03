package SocialMentions.SocialMentions.infraestructure;

import SocialMentions.SocialMentions.domain.AnalyzerSocialMentionsService;
import SocialMentions.SocialMentions.domain.Platform;

public class MapperAnalyzerSocialMentions {
    public static AnalyzerSocialMentionsService invoke(Platform platform) {
        if(platform.isFacebook()) return new FacebookAnalyzer();
        return new TweeterAnalyzer();
    }
}
