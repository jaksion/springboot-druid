package com.twy.druid.controller;

import com.twy.druid.entity.StudentInfo;
import com.twy.druid.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author twy
 * @since 2020-11-13
 */
@RestController
@RequestMapping("/druid/studentinfo")
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;

    @GetMapping("/getInfoByfirst")
    public List<StudentInfo> getInfoByfirst(){
        List<StudentInfo> studentInfos = studentInfoService.getInfoByfirst();
        return studentInfos;
    }

    @GetMapping("/getInfoBysecond")
    public List<StudentInfo> getInfoBysecond(){
        List<StudentInfo> studentInfos = studentInfoService.getInfoBysecond();
        return studentInfos;
    }
}

