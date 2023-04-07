package com.TypeDelta.service;

import com.TypeDelta.mapper.LogMapper;
import com.TypeDelta.pojo.LogMe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    LogMapper logMapper;

    public Integer insertLog(LogMe logMe) {

        return logMapper.insertLog(logMe);
    }

    public List<LogMe> PV7() {
        return logMapper.PV7();
    }
}
