package com.techsavanna.Church.mappers;

import com.techsavanna.Church.members.models.Member;
import com.techsavanna.Church.sermons.dtos.SermonCreateDto;
import com.techsavanna.Church.sermons.dtos.SermonResponseDto;
import com.techsavanna.Church.sermons.dtos.SermonUpdateDto;
import com.techsavanna.Church.sermons.models.Sermon;

public class SermonMapper {
    public static Sermon toEntity(SermonCreateDto dto, Member preacher) {
        Sermon sermon = new Sermon();
        sermon.setTitle(dto.getTitle());
        sermon.setTheme(dto.getTheme());
        sermon.setSermonDate(dto.getSermonDate());
        sermon.setVideoUrl(dto.getVideoUrl());
        sermon.setPreacher(preacher);
        return sermon;
    }

    public static Sermon toUpdatedEntity(Sermon sermon, SermonUpdateDto dto, Member preacher) {
        sermon.setTitle(dto.getTitle());
        sermon.setTheme(dto.getTheme());
        sermon.setSermonDate(dto.getSermonDate());
        sermon.setVideoUrl(dto.getVideoUrl());
        sermon.setPreacher(preacher);
        return sermon;
    }

    public static SermonResponseDto toResponseDto(Sermon sermon) {
        Member preacher = sermon.getPreacher();
        String preacherName = preacher.getFirstName() + " " + preacher.getLastName();

        SermonResponseDto responseDto = new SermonResponseDto();
        responseDto.setSermonId(sermon.getSermonId());
        responseDto.setTitle(sermon.getTitle());
        responseDto.setTheme(sermon.getTheme());
        responseDto.setSermonDate(sermon.getSermonDate());
        responseDto.setVideoUrl(sermon.getVideoUrl());
        responseDto.setPreacherId(preacher.getMemberId());
        responseDto.setPreacherName(preacherName);

        return responseDto;
    }

}
