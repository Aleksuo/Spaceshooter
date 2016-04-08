/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom.components;

import spaceshooter.dom.GameObject;

/**
 *
 * @author Aleksi
 */
public class Component {

    private GameObject obj;

    public Component() {

    }

    public GameObject getObj() {
        return obj;
    }

    public void setObj(GameObject obj) {
        this.obj = obj;
    }

}
