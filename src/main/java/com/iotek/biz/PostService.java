package com.iotek.biz;

import com.iotek.model.Post;

import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */
public interface PostService {
    boolean insertPost(Post post);
    Post selectName(Post post);
    List<Post> selectDeptid(Post post);
}
