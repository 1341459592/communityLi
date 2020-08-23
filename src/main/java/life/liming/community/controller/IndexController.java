package life.liming.community.controller;

import life.liming.community.cache.HotTagCache;
import life.liming.community.dto.PaginationDTO;
import life.liming.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by codedrinker on 2020/5/1
 */
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private HotTagCache hotTagCache;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name ="page",defaultValue = "1") Integer page,
                        @RequestParam(name ="size",defaultValue = "5") Integer size,
                        @RequestParam(name ="search",required = false) String search,
                        @RequestParam(name = "tag", required = false) String tag,
                        @RequestParam(name = "sort", required = false) String sort) {
        List<String> tags = hotTagCache.getHots();
        PaginationDTO pagination=questionService.list(search, tag, sort, page, size);
        model.addAttribute("pagination", pagination);
        model.addAttribute("search", search);
        model.addAttribute("tag", tag);
        model.addAttribute("tags", tags);
        model.addAttribute("sort", sort);
        return "index";
    }
}
