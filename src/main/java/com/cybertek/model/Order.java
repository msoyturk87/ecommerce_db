package com.cybertek.model;

import com.cybertek.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
// no need @Where because no delete option
public class Order extends BaseEntity<Long> {

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus=OrderStatus.IN_PROGRESS; // default value of orderStatus

    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
