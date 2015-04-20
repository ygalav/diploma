package com.ygalav.spring.service.impl;

import com.ygalav.spring.entity.Registration;
import com.ygalav.spring.repository.RegistrationRepository;
import com.ygalav.spring.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegistrationServiceImpl implements RegistrationService {
@Autowired
private RegistrationRepository registrationRepository;

    @Override
    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration save(Registration registration) {
        return registrationRepository.save(registration);
    }
}
