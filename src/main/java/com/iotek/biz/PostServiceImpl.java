package com.iotek.biz;

import com.iotek.dao.PostMapper;
import com.iotek.model.Post;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */
@Service
public class PostServiceImpl implements PostService {
    @Resource
    private PostMapper postMapper;

    public boolean insertPost(Post post) {
        return postMapper.insertPost(post);
    }

    public Post selectName(Post post) {
        return postMapper.selectName(post);
    }

    public List<Post> selectDeptid(Post post) {
        return postMapper.selectDeptid(post);
    }

    public Post selectNameandID(Post post) {
        return postMapper.selectNameandID(post);
    }
}
