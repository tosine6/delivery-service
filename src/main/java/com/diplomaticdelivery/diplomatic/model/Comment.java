package com.diplomaticdelivery.diplomatic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity{

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToOne
    private User author;

}
