package com.iotek.biz;

import com.iotek.dao.ResumeMapper;
import com.iotek.model.Resume;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */
@Service
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeMapper resumeMapper;

    public boolean addResume(Resume resume) {
        return resumeMapper.addResume(resume);
    }

    public List<Resume> selectUID(Resume resume) {
        return resumeMapper.selectUID(resume);
    }

    public boolean delectResume(Resume resume) {
        return resumeMapper.delectResume(resume);
    }

    public boolean updateState(Resume resume) {
        return resumeMapper.updateState(resume);
    }

    public Resume selectTitle(Resume resume) {
        return resumeMapper.selectTitle(resume);
    }

    public Resume selectID(Resume resume) {
        return resumeMapper.selectID(resume);
    }
}
