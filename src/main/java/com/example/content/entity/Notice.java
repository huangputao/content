package com.example.content.entity;

import java.time.LocalDateTime;
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
@ApiModel(value="Notice对象", description="")
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String content;

    private Boolean showFlag;

    private LocalDateTime createTime;


    public static final String ID = "id";

    public static final String CONTENT = "content";

    public static final String SHOW_FLAG = "show_flag";

    public static final String CREATE_TIME = "create_time";

}
