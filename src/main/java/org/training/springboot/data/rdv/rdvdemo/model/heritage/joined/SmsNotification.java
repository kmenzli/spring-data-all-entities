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
@Table(name  ="SMS_NAOTIF")
public class SmsNotification extends Notification {

    @Column(
            name = "phone_number",
            nullable = false
    )
    private String phoneNumber;
}
