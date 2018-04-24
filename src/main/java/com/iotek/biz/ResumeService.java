package com.iotek.biz;

import com.iotek.model.Resume;

import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */
public interface ResumeService {
    boolean addResume(Resume resume);
    List<Resume> selectUID(Resume resume);
    boolean delectResume(Resume resume);
    boolean updateState(Resume resume);
    Resume selectTitle(Resume resume);
    Resume selectID(Resume resume);

}
