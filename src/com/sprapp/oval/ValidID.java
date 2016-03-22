/**
 * 
 */
package com.sprapp.oval;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author mohamed.ezz
 * @version 1.0
 * @since 2.0.2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@net.sf.oval.configuration.annotation.Constraint(checkWith = ValidIDCheck.class)
public @interface ValidID {
}
