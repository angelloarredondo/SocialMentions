package SocialMentions.SocialMentions.application;

import SocialMentions.SocialMentions.application.AnalyzeSocialMention;
import SocialMentions.SocialMentions.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AnalyzeSocialMentionTest {

    @Mock
    private RepositorySocialMentions repositorySocialMentions;

    @Mock
    private AnalyzerSocialMentionsService analyzerSocialMentionsService;

    @InjectMocks
    private AnalyzeSocialMention analyzeSocialMention;

    private Platform facebookPlatform;
    private Platform twitterPlatform;
    private Message message;

    @BeforeEach
    void setUp() {
        facebookPlatform = new Platform("Facebook",  null);
        twitterPlatform = new Platform(null,"Twitter");
        message = new Message("Test message");
    }

    @Test
    void testInvokeForFacebookHighRisk() {
        Double score = -100d;

        when(analyzerSocialMentionsService.calculateScore(any(SocialMention.class))).thenReturn(score);

        String result = analyzeSocialMention.invoke(facebookPlatform, message, analyzerSocialMentionsService);

        assertEquals("HIGH_RISK", result);
        verify(repositorySocialMentions).save(any(SocialMention.class));
    }

    @Test
    void testInvokeForFacebookMediumRisk() {
        Double score = 25d;

        when(analyzerSocialMentionsService.calculateScore(any(SocialMention.class))).thenReturn(score);

        String result = analyzeSocialMention.invoke(facebookPlatform, message, analyzerSocialMentionsService);

        assertEquals("MEDIUM_RISK", result);
        verify(repositorySocialMentions).save(any(SocialMention.class));
    }

    @Test
    void testInvokeForTwitterHighRisk() {
        Double score = -0.7d;

        when(analyzerSocialMentionsService.calculateScore(any(SocialMention.class))).thenReturn(score);

        String result = analyzeSocialMention.invoke(twitterPlatform, message, analyzerSocialMentionsService);

        assertEquals("HIGH_RISK", result);
        verify(repositorySocialMentions).save(any(SocialMention.class));
    }

    @Test
    void testInvokeForTwitterLowRisk() {
        Double score = 0.8d;

        when(analyzerSocialMentionsService.calculateScore(any(SocialMention.class))).thenReturn(score);

        String result = analyzeSocialMention.invoke(twitterPlatform, message, analyzerSocialMentionsService);

        assertEquals("LOW_RISK", result);
        verify(repositorySocialMentions).save(any(SocialMention.class));
    }
}
