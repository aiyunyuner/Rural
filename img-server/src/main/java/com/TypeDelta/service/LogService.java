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

    public List<LogMe> pieMoules() {
        return logMapper.pieMoules();
    }

    public List<LogMe> sightsPV7() {

        return logMapper.sightsPV7();
    }

    public List<LogMe> emPV7() {
        return logMapper.emPV7();
    }

    public List<LogMe> agPV7() {
        return logMapper.agPV7();
    }

    public List<LogMe> ruPV7() {
        return logMapper.ruPV7();
    }

    public List<LogMe> userTOP5() {
        return logMapper.userTOP5();
    }

    public List<LogMe> dayPV() {
        return logMapper.dayPV();
    }
}
