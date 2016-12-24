package org.eagle.security.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class RedisInitializer extends AbstractHttpSessionApplicationInitializer {
	public RedisInitializer() {
		super(RedisConfig.class);
	}
}
