package com.app.mongodb.sb_mongodb_app.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Data
public class Subject {

    private String name;
    @Field(name ="score")
    private BigDecimal marks;
}
