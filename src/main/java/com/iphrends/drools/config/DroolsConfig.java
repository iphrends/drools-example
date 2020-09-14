package com.iphrends.drools.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

import static org.springframework.util.ResourceUtils.FILE_URL_PREFIX;

@Configuration
@Slf4j
public class DroolsConfig {

    private static final String RULES_PATH = new StringBuilder(FILE_URL_PREFIX).append("/tmp/rules/").toString();

    @Bean
    public KieFileSystem kieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = getKieServices().newKieFileSystem();
        Resource[] ruleFiles = getRuleFiles();
        if (ArrayUtils.isEmpty(ruleFiles)) {
            log.warn("no rule files present at {}", RULES_PATH);
        }
        for (Resource file : ruleFiles) {
            kieFileSystem.write(ResourceFactory.newFileResource(ResourceUtils.getFile(file.getURL()).getAbsolutePath()));
        }
        return kieFileSystem;
    }

    private Resource[] getRuleFiles() throws IOException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        return resourcePatternResolver.getResources(RULES_PATH + "**/*.drl");
    }

    @Bean
    public KieContainer kieContainer() throws IOException {
        final KieRepository kieRepository = getKieServices().getRepository();
        kieRepository.addKieModule(kieRepository::getDefaultReleaseId);
        KieBuilder kieBuilder = getKieServices().newKieBuilder(kieFileSystem());
        kieBuilder.buildAll();
        return getKieServices().newKieContainer(kieRepository.getDefaultReleaseId());
    }

    private KieServices getKieServices() {
        return KieServices.Factory.get();
    }
}
