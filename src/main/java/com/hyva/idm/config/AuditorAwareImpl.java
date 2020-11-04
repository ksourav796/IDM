package com.hyva.idm.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Created by tnataraj on 1/15/18.
 */
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "Azgar";
        // Can use Spring Security to return currently logged in user
        // return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
    }
}