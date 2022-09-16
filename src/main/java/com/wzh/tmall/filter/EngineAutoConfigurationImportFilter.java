package com.wzh.tmall.filter;


import com.wzh.tmall.constant.RegistrationCenterConstants;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.autoconfigure.AutoConfigurationImportFilter;
import org.springframework.boot.autoconfigure.AutoConfigurationMetadata;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EngineAutoConfigurationImportFilter implements AutoConfigurationImportFilter, EnvironmentAware {

    private Environment environment;

    @Override
    public boolean[] match(String[] autoConfigurationClasses, AutoConfigurationMetadata autoConfigurationMetadata) {
        //获取配置的注册中心，默认为nacos
        String registryType = environment.getProperty("registry.type", RegistrationCenterConstants.NACOS);
        boolean[] match = new boolean[autoConfigurationClasses.length];
        //当自定义标识为eureka，则排除nacos的自动装配，反之同理；
        if (registryType.equals(RegistrationCenterConstants.EUREKA)) {
            for (int i = 0; i < autoConfigurationClasses.length; i++) {
                match[i] = !StringUtils.isNotBlank(autoConfigurationClasses[i]) ||
                        !autoConfigurationClasses[i].equals(RegistrationCenterConstants.NACOS_SERVICE_REGISTRY_AUTO_CONFIGURATION);
            }
        } else {
            for (int i = 0; i < autoConfigurationClasses.length; i++) {
                if (StringUtils.isNotBlank(autoConfigurationClasses[i])) {
                    match[i] = !RegistrationCenterConstants.EUREKA_DISCOVERY_CLIENT_CONFIGURATION.equals(autoConfigurationClasses[i])
                            && !RegistrationCenterConstants.EUREKA_AUTO_CONFIGURATION_CLASSES.equals(autoConfigurationClasses[i]);
                }

            }
        }
        return match;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}