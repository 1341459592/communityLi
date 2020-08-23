package life.liming.community.exception;

public enum  CustomizeErrorCode implements  ICustomizeErrorCode{
    QUESTION_NOT_FOUND(2001,"你找的问题不存在"),
    TARGET_PARAMNOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试"),
    SYS_ERROR(2004,"服务器炸了，请稍后再试试"),
    TYPE_PARAN_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"你回复评论不存在"),
    COMMENT_IS_EMPTY(2007,"输入内容不能为空"),
    READ_NOTIFICATION_FAIL(2008,"您未登录不可以查看信息"),
    NOTIFICATION_NOT_FOUND(2009,"消息不翼而飞"),
    FILE_UPLOAD_FAIL(2010,"图片上传失败"),
    ;
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code,String message) {
        this.message = message;
        this.code = code;
    }
}
