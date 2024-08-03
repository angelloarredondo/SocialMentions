package SocialMentions.SocialMentions.domain;

public class AnalyzeRisk {
    public String invoke(Platform platform, Double score) {
        if (platform.isFacebook()) {
            if (score == -100d) {
                return "HIGH_RISK";
            } else if (score > -100d && score < 50d) {
                return "MEDIUM_RISK";
            } else if (score >= 50d) {
                return "LOW_RISK";
            }
        }
        if (platform.isTwitter()) {
            if (score >= -1 && score <= -0.5d) {
                return "HIGH_RISK";
            } else if (score > -0.5d && score < 0.7d) {
                return "MEDIUM_RISK";
            } else if (score >= 0.7d) {
                return "LOW_RISK";
            }
        }
        return "LOW_RISK";
    }
}
