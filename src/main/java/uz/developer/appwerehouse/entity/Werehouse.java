package uz.developer.appwerehouse.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.developer.appwerehouse.entity.template.BaseEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Werehouse extends BaseEntity {
}
