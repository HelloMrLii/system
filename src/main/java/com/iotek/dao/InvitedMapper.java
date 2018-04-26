package com.iotek.dao;

import com.iotek.model.Invited;

import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */
public interface InvitedMapper {
    boolean insertInvited(Invited invited);
    List<Invited> selectInvited(Invited invited);
    boolean updateState(Invited invited);
    List<Invited> selectInviteda();
}
