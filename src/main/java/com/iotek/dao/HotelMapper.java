package com.iotek.dao;

import com.iotek.model.Hotel;

import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */
public interface HotelMapper {
    List<Hotel> selectHotel();
    Hotel selectHotpost(Hotel hotel);
    boolean addHotel(Hotel hotel);
    boolean delecthotel(Hotel hotel);
    boolean updatehotel(Hotel hotel);
}
