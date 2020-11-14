package com.twy.druid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twy.druid.config.datasource.DBTypeEnum;
import com.twy.druid.config.datasource.DataSource;
import com.twy.druid.dao.StudentInfoDAO;
import com.twy.druid.entity.StudentInfo;
import com.twy.druid.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author twy
 * @since 2020-11-13
 */
@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoDAO, StudentInfo> implements StudentInfoService {

    /**
     * 默认数据源first获取数据
     * @return
     */
    @Override
    public List<StudentInfo> getInfoByfirst() {
        List<StudentInfo> studentInfos = this.list();
        return studentInfos;
    }

    /**
     * 使用注解切换到second数据源获取数据
     * @return
     */
    @Override
    @DataSource(DBTypeEnum.second)
    public List<StudentInfo> getInfoBysecond() {
        List<StudentInfo> studentInfos = this.list();
        return studentInfos;
    }
}
