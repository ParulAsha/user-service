package com.codebuffer.userservice.service;

import com.codebuffer.userservice.VO.Department;
import com.codebuffer.userservice.VO.ResponseTemplateVO;
import com.codebuffer.userservice.entity.User;
import com.codebuffer.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public User saveUsers(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("inside getUserWithDepartment");
        ResponseTemplateVO responseTemplateVO=new ResponseTemplateVO();
        User user=userRepository.findByUserId(userId);

        Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        responseTemplateVO.setDepartment(department);
        responseTemplateVO.setUser(user);
        return responseTemplateVO;

    }
}
