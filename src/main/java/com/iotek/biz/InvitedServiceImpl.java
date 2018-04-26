package com.iotek.biz;

import com.iotek.dao.InvitedMapper;
import com.iotek.model.Invited;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */
@Service
public class InvitedServiceImpl implements InvitedService {
    @Resource
    private InvitedMapper invitedMapper;
    public boolean insertInvited(Invited invited) {
        return invitedMapper.insertInvited(invited);
    }

    public List<Invited> selectInvited(Invited invited) {
        return invitedMapper.selectInvited(invited);
    }

    public boolean updateState(Invited invited) {
        return invitedMapper.updateState(invited);
    }

    public List<Invited> selectInviteda() {
        return invitedMapper.selectInviteda();
    }
}
