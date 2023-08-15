package com.mjc.school.service.Mapping;

import com.mjc.school.repository.models.NewsModel;

import com.mjc.school.service.dto.NewsDtoObject;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@org.mapstruct.Mapper
public interface Mapper {
    Mapper INSTANCE = Mappers.getMapper(Mapper.class);

    NewsDtoObject newsToDto(NewsModel newsModel);
    NewsModel newsDtoToModelCreate(NewsDtoObject newsDto);
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "lastUpdateTime", ignore = true)
    NewsModel newsDtoToModel(NewsDtoObject newsDTO);
}
