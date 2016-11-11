
/**
 * Created by NEERAJPC on 10/24/2016.
 */
/*
 * Copyright (C) 2015 Antonio Leiva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.firebase.quickstart.database.models;
import java.io.Serializable;


public class Restra implements Serializable{
    private String restra_name;
    private String city;
    private String area;
    private String lat;
    private String lng;
    private String image;
    private String id;

    public Restra() {
    }

    public Restra(String restra_name,String city,String area, String lat, String lng, String image, String id) {
        this.restra_name = restra_name;
        this.city =city;
        this.area =area;
        this.image =image;
        this.lat =lat;
        this.lng=lng;
        this.id=id;
    }

    public String getRestra_name() {
        return restra_name;
    }

    public void setRestra_name(String restra_name) {
        this.restra_name = restra_name;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getLat() {
        return lat;
    }
    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
