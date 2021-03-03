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
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Share对象", description="")
public class Share implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private String title;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean isOriginal;

    private String author;

    private String cover;

    private String summary;

    private Integer price;

    private String downloadUrl;

    private Integer buyCount;

    private Boolean showFlag;

    private String auditStatus;

    private String reason;


    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String TITLE = "title";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String IS_ORIGINAL = "is_original";

    public static final String AUTHOR = "author";

    public static final String COVER = "cover";

    public static final String SUMMARY = "summary";

    public static final String PRICE = "price";

    public static final String DOWNLOAD_URL = "download_url";

    public static final String BUY_COUNT = "buy_count";

    public static final String SHOW_FLAG = "show_flag";

    public static final String AUDIT_STATUS = "audit_status";

    public static final String REASON = "reason";

}
