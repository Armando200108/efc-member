package cn.pdteam.efc.member.domain.logic.handler;

import com.alibaba.fastjson2.JSON;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pdteam.efc.member.domain.entity.student.StudentBaseInfo;
import cn.pdteam.efc.member.domain.logic.handler.base.BaseHandler;
import cn.pdteam.efc.member.domain.model.Student;
import cn.pdteam.efc.member.domain.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RegisterStudentHandler extends BaseHandler<Student,Long> {

    @Autowired
    private StudentRepository repository;

    public Long handle(String studentId) {
        // TODO 从oracle服务器获取外部数据

        // TODO 组装实体，组装聚合根

        // TODO 调用doHandle方法
        return doHandle(() -> repository.findByKey(1L));
    }

    /**
     * 处理
     *
     * @param supplier 提供的参数
     */
    @Override
    protected Long doHandle(Supplier<Student> supplier) {
        Student student = supplier.get();
        log.info("Student Domain Handler => Register Student Start! Student: {}", JSON.toJSONString(student));
        return repository.save(student).getId();
    }

}
