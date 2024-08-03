package SocialMentions.SocialMentions.infraestructure;

import SocialMentions.SocialMentions.domain.AnalyzerSocialMentionsService;
import SocialMentions.SocialMentions.domain.SocialMention;

public class FacebookAnalyzer implements AnalyzerSocialMentionsService {
    public static double calculateFacebookCommentsScore(String substring) {
        return 0;
    }

    public static Double analyzePost(String message, String facebookAccount) {
        return null;
    }

    @Override
    public double calculateScore(SocialMention socialMention) {
        Double facebookScore = 0d;
        facebookScore = analyzeComments(socialMention, facebookScore);
        facebookScore = analyzeScore(socialMention, facebookScore);
        return  facebookScore;

    }

    private static Double analyzeScore(SocialMention socialMention, Double facebookScore) {
        if (facebookScore > -100) {
            facebookScore = FacebookAnalyzer.analyzePost(
                    socialMention.getMessage(),
                    socialMention.getFacebookAccount()

            );
        }
        return facebookScore;
    }

    private static Double analyzeComments(SocialMention socialMention, Double facebookScore) {
        double facebookCommentsScore;
        if (socialMention.getMessage().contains("comments:")) {
            facebookCommentsScore = FacebookAnalyzer.calculateFacebookCommentsScore(
                    socialMention
                            .getMessage()

                            .substring(socialMention.getMessage().indexOf("comments:"))

            );
            if (facebookCommentsScore < 50d){
                facebookScore = Double.sum(facebookScore, -100d);
            }
        }
        return facebookScore;
    }
}
