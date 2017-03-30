package graffiti.controller;

import graffiti.data.Picture;
import graffiti.dto.PictureForm;
import graffiti.repo.PictureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by WagnerMestrinho on 3/3/17.
 */
@Controller
public class PictureController {

    @Autowired
    PictureRepo pictureRepo;

    @Value("${upload.location}")
    private String uploadLocation;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model mapOfDataForJsp){
        String dest = "/index";
        // find all pictures
        Iterable<Picture> album = pictureRepo.findAll();
        mapOfDataForJsp.addAttribute("pictures", album);
        return dest;
    }

    @RequestMapping(path = "/wall/delete", method = RequestMethod.GET)
    public String deleteMovie(Model mapOfDataForJsp, @RequestParam Long id){
        pictureRepo.delete(id);
        // find by
        mapOfDataForJsp.addAttribute("success_msg", "Picture Deleted.");
        return "forward:/wall";
    }

    @RequestMapping(path = "/posting", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE)
    public String createPost(Model dataToJsp, PictureForm myFavoritePic) throws Exception {
        String dest = "/index";

        Picture saveToDB = null;
        // only do copy work if local file was uploaded
        if (!myFavoritePic.getPictureFile().getOriginalFilename().isEmpty()) {
            String uploadedFileName = System.currentTimeMillis() + "_" + myFavoritePic.getPictureFile().getOriginalFilename();
            // copy from input stream to computer disk
            Files.copy(myFavoritePic.getPictureFile().getInputStream(), Paths.get(uploadLocation + uploadedFileName));
            saveToDB = new Picture(myFavoritePic, uploadedFileName);
        }
         else {
            // no copy work, could be edit or just new with poster URL
            saveToDB = new Picture(myFavoritePic);
            // we need to re-fetch poster file name (local file name) if this
            // is an edit AND they have not provided a poster URL
            if (saveToDB.getId() != 0 &&
                    (saveToDB.getPictureUrl() == null || saveToDB.getPictureUrl().isEmpty())) {
                // need to ensure uploaded file name is not overridden
                Picture tmp = pictureRepo.findOne(saveToDB.getId());
                saveToDB.setPictureFileName(tmp.getPictureFileName());
            }

        }
        // save to database
        pictureRepo.save(saveToDB);
        // if successful save, add message
        Iterable<Picture> album = pictureRepo.findAll();
        dataToJsp.addAttribute("pictures", album);
        return dest;
        //TODO put it into a list
    }
}