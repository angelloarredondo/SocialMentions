package SocialMentions.SocialMentions.infraestructure;

import SocialMentions.SocialMentions.application.AnalyzeSocialMention;
import SocialMentions.SocialMentions.domain.InvalidSocialMention;
import SocialMentions.SocialMentions.domain.Message;
import SocialMentions.SocialMentions.domain.Platform;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialMentionsController {

    private final AnalyzeSocialMention analyzeSocialMention;

    public SocialMentionsController() {
        this.analyzeSocialMention = new AnalyzeSocialMention(new RepositorySocialMentionsInMemory());
    }


    @PostMapping("/AnalyzeSocialMention")
    public String analyze(@RequestBody SocialMentionMapper socialMention) {
        try {
            Platform platform = new Platform(socialMention.getFacebookAccount(), socialMention.getTweeterAccount());
            Message message = new Message(socialMention.getMessage());

            return this.analyzeSocialMention.invoke(platform, message, MapperAnalyzerSocialMentions.invoke(platform));

        } catch (InvalidSocialMention invalidSocialMention) {
            return invalidSocialMention.getMessage();
        }
    }
}
