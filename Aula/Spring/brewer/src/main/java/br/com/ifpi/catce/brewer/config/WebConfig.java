package br.com.ifpi.catce.brewer.config;

import br.com.ifpi.catce.brewer.controller.CervejasController;
import br.com.ifpi.catce.brewer.controller.converter.EstiloConverter;
import br.com.ifpi.catce.brewer.repository.Cervejas;
import br.com.ifpi.catce.brewer.thymeleaf.processor.BrewerDialect;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.thymeleaf.spring6.ISpringTemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;


import java.math.BigDecimal;
import java.time.Duration;
import java.util.Locale;

@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@ComponentScan(basePackageClasses = Cervejas.class)
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public ISpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolver());

        engine.addDialect(new LayoutDialect());
        engine.addDialect(new BrewerDialect());
        return engine;
    }

    private ITemplateResolver templateResolver(){
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

    }

    @Bean
    public FormattingConversionService mvcConversionService(){
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new EstiloConverter());

        NumberStyleFormatter bigDecimalFormatter = new NumberStyleFormatter("#,##0.00");
        conversionService.addFormatterForFieldType(BigDecimal.class, bigDecimalFormatter);

        NumberStyleFormatter integerFormatter = new NumberStyleFormatter("#,##0");
        conversionService.addFormatterForFieldType(Integer.class, integerFormatter);

        return conversionService;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new FixedLocaleResolver(new Locale("pt", "BR"));
    }
}
