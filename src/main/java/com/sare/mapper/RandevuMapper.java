package com.sare.mapper;

import com.sare.dto.request.RandevuEkleRequestDto;
import com.sare.entity.Randevu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface RandevuMapper {

    RandevuMapper INSTANCE = Mappers.getMapper(RandevuMapper.class);
    Randevu fromRandevuEkleRequestDto(RandevuEkleRequestDto dto);

}
