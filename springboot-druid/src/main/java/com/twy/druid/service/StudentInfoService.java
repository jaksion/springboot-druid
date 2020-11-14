package com.twy.druid.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.twy.druid.entity.StudentInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author twy
 * @since 2020-11-13
 */
public interface StudentInfoService extends IService<StudentInfo> {

    List<StudentInfo> getInfoByfirst();

    List<StudentInfo> getInfoBysecond();
}
