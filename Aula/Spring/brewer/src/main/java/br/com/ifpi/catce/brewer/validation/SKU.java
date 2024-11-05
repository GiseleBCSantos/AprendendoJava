package br.com.ifpi.catce.brewer.validation;

import jakarta.validation.Constraint;
import jakarta.validation.OverridesAttribute;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "([a-zA-Z]{2}\\d{4})?", message = "Sku deve seguir o padrão XX9999")
public @interface SKU {

    @OverridesAttribute(constraint = Pattern.class, name = "message")
    String message() default "Sku deve seguir o padrão XX9999";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
