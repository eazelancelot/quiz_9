package com.example.quiz_9.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@EnableCaching
@Configuration
public class CaffeineCacheConfig {

	@Bean
	public CacheManager cacheManager() {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
		cacheManager.setCaffeine(Caffeine.newBuilder()
				// �]�w�L���ɶ��F�C���B�z(�g��Ū)��A�T�w�ɶ������A���ʧ@�A�֨���ƴN�|����
				.expireAfterAccess(600, TimeUnit.SECONDS)
				// ��l���w�s�Ŷ��j�p
				.initialCapacity(100)
				// �w�s���̤j����
				.maximumSize(500));
		return cacheManager;
	}

}
