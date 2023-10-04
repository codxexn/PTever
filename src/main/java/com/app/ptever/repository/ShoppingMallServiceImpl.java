package com.app.ptever.repository;

import com.app.ptever.dao.ShoppingMallDAO;
import com.app.ptever.domain.dto.ShoppingMallDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ShoppingMallServiceImpl implements ShoppingMallService {
    private final ShoppingMallDAO shoppingMallDAO;
    @Override
    public List<ShoppingMallDTO> findProductAll() {
        return shoppingMallDAO.readProductAll();
    }
}
