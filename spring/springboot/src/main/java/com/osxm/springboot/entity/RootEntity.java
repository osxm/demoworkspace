/**
 * @Title: RootEntity.java
 * @Package com.osxm.springboot.entity
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月7日
 * @version V1.0
 */
package com.osxm.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

/**
  * @ClassName: RootEntity
  * @Description: TODO
  * @author oscarchen
  */
@MappedSuperclass
public abstract class RootEntity implements Serializable {

    private static final long serialVersionUID = 1L; 

    private Date sysCreateDate;

    private Date sysUpdateDate;

    //@Column(length = 30, nullable = false)
    private String sysCreator;

    //@Column(length = 30)
    private String sysModifer;

    public Date getSysCreateDate() {
        return sysCreateDate;
    }

    public void setSysCreateDate(Date sysCreateDate) {
        this.sysCreateDate = sysCreateDate;
    }

    public Date getSysUpdateDate() {
        return sysUpdateDate;
    }

    public void setSysUpdateDate(Date sysUpdateDate) {
        this.sysUpdateDate = sysUpdateDate;
    }

    public String getSysCreator() {
        return sysCreator;
    }

    public void setSysCreator(String sysCreator) {
        this.sysCreator = sysCreator;
    }

    public String getSysModifer() {
        return sysModifer;
    }

    public void setSysModifer(String sysModifer) {
        this.sysModifer = sysModifer;
    }
}
