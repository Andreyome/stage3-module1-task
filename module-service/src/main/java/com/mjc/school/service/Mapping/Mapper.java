package com.mjc.school.service.Mapping;

import com.mjc.school.repository.models.NewsModel;

import com.mjc.school.service.DTO.NewsDTO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@org.mapstruct.Mapper
public interface Mapper {
    Mapper INSTANCE = Mappers.getMapper(Mapper.class);

    NewsDTO newsToDto(NewsModel newsModel);
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "lastUpdateTime", ignore = true)
    NewsModel newsDtoToModel(NewsDTO newsDTO);
}
