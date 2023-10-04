package com.app.ptever.repository;

import com.app.ptever.domain.dto.ShoppingMallDTO;

import java.util.List;

public interface ShoppingMallService {

    public List<ShoppingMallDTO> findProductAll();

}
