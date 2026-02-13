package com.sare.mapper;

import com.sare.dto.request.RegisterRequestDto;
import com.sare.entity.Hasta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface HastaMapper {

    HastaMapper INSTANCE = Mappers.getMapper(HastaMapper.class);
    Hasta fromRegisterRequestDto(RegisterRequestDto dto);

}
