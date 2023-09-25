package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class ProductViewVO implements Serializable {
    // 상품 재고
    private Integer productStock;
    // ================================
    private Integer productId; // 상품 id
}
