package com.app.ptever.dao;

import com.app.ptever.domain.dto.ShoppingMallDTO;
import com.app.ptever.mapper.ShoppingMallProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class ShoppingMallDAO {
    private final ShoppingMallProductMapper shoppingMallProductMapper;

    public List<ShoppingMallDTO> readProductAll() {return shoppingMallProductMapper.selectProduct();}
}
