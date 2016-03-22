package com.sprapp.oval;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@net.sf.oval.configuration.annotation.Constraint(checkWith = UpperCaseCheck.class)
public @interface UpperCase {

}
