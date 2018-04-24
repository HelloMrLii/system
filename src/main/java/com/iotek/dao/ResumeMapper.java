package com.iotek.dao;

import com.iotek.model.Resume;
import com.iotek.model.Users;

import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */
public interface ResumeMapper {
    boolean addResume(Resume resume);
    List<Resume> selectUID(Resume resume);
    boolean delectResume(Resume resume);
    boolean updateState(Resume resume);
    Resume selectTitle(Resume resume);
    Resume selectID(Resume resume);
}
