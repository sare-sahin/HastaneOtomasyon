package com.sare.mapper;

import com.sare.dto.request.DoktorEkleRequestDto;
import com.sare.entity.Doktor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface DoktorMapper {

    DoktorMapper INSTANCE = Mappers.getMapper(DoktorMapper.class);
    Doktor fromDoktorEkleRequestDto(DoktorEkleRequestDto dto);

}
