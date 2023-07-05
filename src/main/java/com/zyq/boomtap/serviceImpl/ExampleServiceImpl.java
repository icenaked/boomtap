package com.zyq.boomtap.serviceImpl;

import com.zyq.boomtap.dao.ExampleRepository;
import com.zyq.boomtap.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service包括了@Component
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    ExampleRepository exampleRepository;
}
