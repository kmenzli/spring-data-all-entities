package org.training.springboot.data.rdv.rdvdemo.model.heritage.joined;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name  ="Email_NOTIF")
public class EmailNotification extends Notification {
    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailAddress;
}
