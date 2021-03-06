package life.liming.community.dto;

import lombok.Data;

@Data
public class HotTagDTO implements Comparable {
    private String name;
    private Integer priority;

    @Override
    public int compareTo(Object o) {
        return this.getPriority() - ((life.liming.community.dto.HotTagDTO) o).getPriority();
    }
}
