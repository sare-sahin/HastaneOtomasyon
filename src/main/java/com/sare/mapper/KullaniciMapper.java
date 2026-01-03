package com.sare.mapper;

import com.sare.dto.request.RegisterRequestDto;
import com.sare.entity.Kullanici;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface KullaniciMapper {

    KullaniciMapper INSTANCE = Mappers.getMapper(KullaniciMapper.class);
    Kullanici fromRegisterRequestDto(RegisterRequestDto dto);

}
