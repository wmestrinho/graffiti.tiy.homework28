package graffiti.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by WagnerMestrinho on 3/3/17.
 */
public class PictureForm {
    private long id;
    private String pictureUrl;
    private MultipartFile pictureFile;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public MultipartFile getPictureFile() {
        return pictureFile;
    }

    public void setPictureFile(MultipartFile pictureFile) {
        this.pictureFile = pictureFile;
    }
}
