package com.payment.module.sys.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Document(indexName = "sysUser")
public class UserModel implements Serializable {
    @Id
    private Long userId;
    private Long orgId;
    private String username;
}
