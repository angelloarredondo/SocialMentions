package SocialMentions.SocialMentions.application;

import SocialMentions.SocialMentions.domain.*;

public class AnalyzeSocialMention {

    private final RepositorySocialMentions repositorySocialMentions;

    private AnalyzeRisk analyzeRisk;

    public AnalyzeSocialMention(RepositorySocialMentions repositorySocialMentions) {
        this.repositorySocialMentions = repositorySocialMentions;
        this.analyzeRisk = new AnalyzeRisk();
    }

    public String invoke(Platform platform, Message message, AnalyzerSocialMentionsService analyzer) {

        SocialMention socialMention = new SocialMention(platform, message);

        Double score = analyzer.calculateScore(socialMention);

        socialMention.updateScore(score);

        this.repositorySocialMentions.save(socialMention);

       return this.analyzeRisk.invoke(platform, score);

    }
}
