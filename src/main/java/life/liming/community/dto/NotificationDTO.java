package life.liming.community.dto;

import lombok.Data;

@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String quterTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}