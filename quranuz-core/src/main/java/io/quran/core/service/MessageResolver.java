package io.quran.core.service;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import java.util.Locale;

@Component
public class MessageResolver {
    private final MessageSource messageSource;

    public MessageResolver(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String code) {
        return this.getMessage(LocaleContextHolder.getLocale(), code, null);
    }

    public String getMessage(String code, Object[] params) {
        return getMessage(LocaleContextHolder.getLocale(), code, params);
    }

    public String getMessage(Locale locale, String code, Object[] params) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return messageSource.getMessage(code, params, locale);
    }
}
