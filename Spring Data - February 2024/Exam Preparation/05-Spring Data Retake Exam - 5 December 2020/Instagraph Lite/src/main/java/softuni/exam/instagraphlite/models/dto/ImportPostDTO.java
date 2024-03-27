package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPostDTO {

    @NotNull
    @Size(min = 21)
    @XmlElement
    private String caption;

    @NotNull
    @XmlElement
    private UserNameDTO user;

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class UserNameDTO {
        @NotNull
        @Size(min = 2, max = 18)
        @XmlElement
        private String username;
        public String getUsername() {
            return username;
        }
    }

    @NotNull
    @XmlElement
    private PicturePathDTO picture;

    public static class PicturePathDTO {
        @NotNull
        @XmlElement
        private String path;

        public String getPath() {
            return path;
        }
    }


    public String getCaption() {
        return caption;
    }

    public UserNameDTO getUser() {
        return user;
    }

    public PicturePathDTO getPicture() {
        return picture;
    }
}
