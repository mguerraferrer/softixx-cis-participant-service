package mx.softixx.cis.cloud.participant.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import lombok.val;

@Configuration
public class MessageSourceConfig {
	
	@Bean
    public LocaleResolver localeResolver() {
        val slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es", "MX"));
        return slr;
    }
	
	@Bean
    public MessageSource messageSource() {
        val messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages", "classpath:validator-messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
	
}