package com.example.common;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class ParamsPage {
    private String searchValue;
    private Integer pageSize;
    private Integer currentPage;
}
