package com.iotek.biz;

import com.iotek.dao.TrainMapper;
import com.iotek.model.Train;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */
@Service
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainMapper trainMapper;
    public boolean addTrain(Train train) {
        return trainMapper.addTrain(train);
    }

    public List<Train> selectAll() {
        return trainMapper.selectAll();
    }

    public boolean updatetrain(Train train) {
        return trainMapper.updatetrain(train);
    }

    public boolean delecttrain(Train train) {
        return trainMapper.delecttrain(train);
    }
}
