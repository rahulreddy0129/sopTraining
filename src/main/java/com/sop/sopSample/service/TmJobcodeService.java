package com.sop.sopSample.service;

import com.sop.sopSample.model.Tm;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TmJobcodeService {
    public void creataTmJobcodes(Tm tm, List<Long> jobCodeIds, LocalDate fromDate) {
//        List<TmJobCode> tmJcList = new ArrayList<TmJobCode>();
//        for (Long jobCodeId : jobCodeIds) {
//            TmJobCode tjc = new TmJobCode();
//            tjc.setTm(tm);
//            tjc.setJobCodeId(jobCodeId);
//            tjc.setFromDate(fromDate);
//            tjc.setThruDate(fromDate.plusYears(20));
//            tmJcList.add(tjc);
//        }
//        tmJobCodeRepository.saveAll(tmJcList);
    }
}
