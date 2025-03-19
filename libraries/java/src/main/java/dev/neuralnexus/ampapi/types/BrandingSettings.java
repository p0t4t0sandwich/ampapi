/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * Branding information
 *
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
public record BrandingSettings(
        String BackgroundURL,
        String BrandingMessage,
        String CompanyName,
        Boolean DisplayBranding,
        String ForgotPasswordURL,
        String LogoURL,
        String PageTitle,
        String ShortBrandingMessage,
        String SplashFrameURL,
        String SubmitTicketURL,
        String SupportText,
        String SupportURL,
        String URL,
        String WelcomeMessage) {}
