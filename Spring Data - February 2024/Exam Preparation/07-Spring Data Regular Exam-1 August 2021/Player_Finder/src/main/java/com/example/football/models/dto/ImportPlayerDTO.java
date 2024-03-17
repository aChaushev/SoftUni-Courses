package com.example.football.models.dto;

import com.example.football.models.entity.PlayerPosition;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPlayerDTO {

    //        <first-name>L</first-name>
    //        <last-name>Smallbone</last-name>
    //        <email>lsmallbone0@hubpages.com</email>
    //        <birth-date>21/02/1979</birth-date>
    //        <position>ATT</position>

    @XmlElement(name = "first-name")
    @Size(min = 2)
    private String firstName;

    @XmlElement(name = "last-name")
    @Size(min = 2)
    private String lastName;

    @XmlElement
    @Email
    private String email;

    //  dd/MM/yyyy
    @XmlElement(name = "birth-date")
    private String birthDate;

    @XmlElement
    private PlayerPosition position;

    //        <town>
    //            <name>Kazan</name>
    //        </town>
    //        <team>
    //            <name>McGlynn</name>
    //        </team>
    //        <stat>
    //            <id>53</id>
    //        </stat>

    @XmlElement(name = "town")
    private NameDTO town;
    @XmlElement(name = "team")
    private NameDTO team;

    @XmlElement(name = "stat")
    private StatIdDTO stat;


    public ImportPlayerDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String  getBirthDate() {
        return birthDate;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public NameDTO getTown() {
        return town;
    }

    public NameDTO getTeam() {
        return team;
    }

    public StatIdDTO getStat() {
        return stat;
    }
}
