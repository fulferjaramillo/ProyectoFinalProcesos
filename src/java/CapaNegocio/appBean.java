/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import Util.MyUtil;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author fernando
 */
//@Named(value = "appBean")
@ManagedBean
@ApplicationScoped
public class appBean {

    /**
     * Creates a new instance of appBean
     */
    public appBean() {
    }

    public String getBaseUrl() {
        return MyUtil.baseurl();

    }
    public String getBasePath(){
    return MyUtil.basepath();
    }
}
