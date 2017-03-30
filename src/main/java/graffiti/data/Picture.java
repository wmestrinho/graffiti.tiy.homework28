package graffiti.data;

import graffiti.dto.PictureForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by WagnerMestrinho on 3/3/17.
 */
@Entity
public class Picture {

    @Id @GeneratedValue
    private long id;
    private String pictureUrl;
    private String pictureFileName;

    public Picture() {
    }

    public Picture(PictureForm dataFromForm) {
        this.pictureUrl = pictureUrl;
    }

    public Picture(PictureForm dataFromForm, String pictureFileName) {
        this.pictureUrl = dataFromForm.getPictureUrl();
        this.pictureFileName = pictureFileName;
    }

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

    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }
}
