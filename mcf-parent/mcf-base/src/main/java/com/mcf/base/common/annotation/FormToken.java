package com.mcf.base.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:19:55
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FormToken {

	boolean save() default false;

	boolean remove() default false;
}
