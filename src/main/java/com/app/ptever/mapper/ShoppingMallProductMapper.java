package com.app.ptever.mapper;

import com.app.ptever.domain.dto.ShoppingMallDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingMallProductMapper {
    public List<ShoppingMallDTO> selectProduct();
}
