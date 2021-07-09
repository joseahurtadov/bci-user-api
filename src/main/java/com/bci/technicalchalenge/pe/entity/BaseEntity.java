package com.bci.technicalchalenge.pe.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity<K> implements Serializable {

    public abstract K getId();

    public abstract void setId(K id);

}
