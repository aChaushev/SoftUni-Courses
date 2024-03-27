package softuni.exam.instagraphlite.models.dto;

import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ImportUserDTO {

    @NotNull
    @Size(min = 2, max = 18)
    private String username;

    @NotNull
    @Size(min = 4)
    private String password;
    
    @NotNull
    @SerializedName(value = "profilePicture")
    private String profilePicturePath;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }
}
