package com.alamnr.flyway.domain;


import org.hibernate.annotations.Type;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="orders")
// @TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
public class Order {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@Column(nullable=false, unique=true)
private String trackingNumber;


//  @Type(type = "jsonb")
//  @Column(columnDefinition = "jsonb")
@Type(JsonBinaryType.class)
@Column(columnDefinition = "jsonb")
private String items;
}