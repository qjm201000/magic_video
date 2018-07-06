package com.magic.video.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.magic.video.po.VideoUser;
@Mapper
public interface VideoUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VideoUser record);

    int insertSelective(VideoUser record);

    VideoUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VideoUser record);

    int updateByPrimaryKey(VideoUser record);
}