package life.liming.community.cache;

import life.liming.community.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TagCache {
    public static List<TagDTO> get(){
        List<TagDTO> TagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("游戏名称");
        program.setTags(Arrays.asList("lol","dnf","cf"));
        TagDTOS.add(program);

        TagDTO framework = new TagDTO();
        framework.setCategoryName("游戏公司");
        framework.setTags(Arrays.asList("tx","网易","暴雪","完美世界"));
        TagDTOS.add(framework);

        TagDTO server = new TagDTO();
        server.setCategoryName("游戏种类");
        server.setTags(Arrays.asList("MOBA","动作","射击","竞速","休闲"));
        TagDTOS.add(server);

        TagDTO db = new TagDTO();
        db.setCategoryName("游戏类型");
        db.setTags(Arrays.asList("手游","网络游戏","单机游戏","网页游戏"));
        TagDTOS.add(db);

        TagDTO tool = new TagDTO();
        tool.setCategoryName("游戏平台");
        tool.setTags(Arrays.asList("wegame","steam","4339"));
        TagDTOS.add(tool);

        return TagDTOS;
    }
    public static String filterInvalid(String tags){
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = get();

        //faltMap可以多层遍历数组
        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }
}
