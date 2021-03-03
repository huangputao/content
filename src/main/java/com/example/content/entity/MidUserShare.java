package com.example.content.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChaosBear
 * @since 2021-03-03
 */
@Data
@ApiModel(value="MidUserShare对象", description="")
public class MidUserShare implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer shareId;

    private Integer userId;


    public static final String ID = "id";

    public static final String SHARE_ID = "share_id";

    public static final String USER_ID = "user_id";

}
