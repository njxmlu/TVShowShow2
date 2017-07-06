package lingda.controller;

import lingda.model.dto.DownLoadLink;
import lingda.model.dto.TVShowDTO;
import lingda.model.pojo.TVShow;
import lingda.service.crawler.ShowCrawler;
import lingda.service.manager.ShowManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lingda on 25/06/2017.
 */
@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    private ShowManager showManager;

    @Autowired
    private ShowCrawler meijuttShowCrawler;

    @GetMapping
    public List<TVShow> getShowList() {
        return showManager.getShowList();
    }

    @PostMapping("/downloadlinks")
    public List<DownLoadLink> getDownloadLinks(@RequestBody TVShowDTO showDTO) {
        TVShow tvShow = new TVShow(null, showDTO.getName(), showDTO.getEnglishName(), showDTO.getDescription(), showDTO.getSeason(), showDTO.getEpisode());
        return meijuttShowCrawler.searchDownloadLinks(showDTO.getDetailUrl(), tvShow);
    }
}
