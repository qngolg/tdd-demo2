package com.test.game;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Documented
public @interface NotIn {
}
