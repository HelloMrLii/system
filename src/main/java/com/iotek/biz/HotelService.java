package com.iotek.biz;

import com.iotek.model.Hotel;

import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */
public interface HotelService {
    List<Hotel> selectHotel();
    Hotel selectHotpost(Hotel hotel);
    boolean addHotel(Hotel hotel);
    boolean delecthotel(Hotel hotel);
    boolean updatehotel(Hotel hotel);
}
