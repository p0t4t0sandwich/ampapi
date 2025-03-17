package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Branding information
 * @param BackgroundURL The background URL
 * @param BrandingMessage The branding message
 * @param CompanyName The company name
 * @param DisplayBranding Whether to display branding
 * @param ForgotPasswordURL The forgot password URL
 * @param LogoURL The logo URL
 * @param PageTitle The page title
 * @param ShortBrandingMessage The short branding message
 * @param SplashFrameURL The splash frame URL
 * @param SubmitTicketURL The submit ticket URL
 * @param SupportText The support text
 * @param SupportURL The support URL
 * @param URL The URL
 * @param WelcomeMessage The welcome message
 */
public record BrandingSettings(String BackgroundURL, String BrandingMessage, String CompanyName, Boolean DisplayBranding, String ForgotPasswordURL, String LogoURL, String PageTitle, String ShortBrandingMessage, String SplashFrameURL, String SubmitTicketURL, String SupportText, String SupportURL, String URL, String WelcomeMessage) {}
