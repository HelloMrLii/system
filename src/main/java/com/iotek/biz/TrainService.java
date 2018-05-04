package com.iotek.biz;

import com.iotek.model.Train;

import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */
public interface TrainService {
    boolean addTrain(Train train);
    List<Train> selectAll();
    boolean updatetrain(Train train);
    boolean delecttrain(Train train);
}
